package androidx.room.parser;

import androidx.compose.runtime.ComposerKt;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.room.jarjarred.org.antlr.v4.runtime.FailedPredicateException;
import androidx.room.jarjarred.org.antlr.v4.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.v4.runtime.Parser;
import androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuntimeMetaData;
import androidx.room.jarjarred.org.antlr.v4.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.Vocabulary;
import androidx.room.jarjarred.org.antlr.v4.runtime.VocabularyImpl;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNDeserializer;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ParserATNSimulator;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContextCache;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFA;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeListener;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeVisitor;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.TerminalNode;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import java.util.List;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: loaded from: classes.dex */
public class SQLiteParser extends Parser {
    public static final int AMP = 16;
    public static final int ASSIGN = 6;
    public static final int BIND_PARAMETER = 156;
    public static final int BLOB_LITERAL = 158;
    public static final int CLOSE_PAR = 4;
    public static final int COMMA = 5;
    public static final int DIV = 12;
    public static final int DOT = 2;
    public static final int DO_NOTHING = 152;
    public static final int DO_UPDATE = 153;
    public static final int EQ = 22;
    public static final int FALSE = 26;
    public static final int GT = 20;
    public static final int GT2 = 15;
    public static final int GT_EQ = 21;
    public static final int IDENTIFIER = 154;
    public static final int K_ABORT = 27;
    public static final int K_ACTION = 28;
    public static final int K_ADD = 29;
    public static final int K_AFTER = 30;
    public static final int K_ALL = 31;
    public static final int K_ALTER = 32;
    public static final int K_ANALYZE = 33;
    public static final int K_AND = 34;
    public static final int K_AS = 35;
    public static final int K_ASC = 36;
    public static final int K_ATTACH = 37;
    public static final int K_AUTOINCREMENT = 38;
    public static final int K_BEFORE = 39;
    public static final int K_BEGIN = 40;
    public static final int K_BETWEEN = 41;
    public static final int K_BY = 42;
    public static final int K_CASCADE = 43;
    public static final int K_CASE = 44;
    public static final int K_CAST = 45;
    public static final int K_CHECK = 46;
    public static final int K_COLLATE = 47;
    public static final int K_COLUMN = 48;
    public static final int K_COMMIT = 49;
    public static final int K_CONFLICT = 50;
    public static final int K_CONSTRAINT = 51;
    public static final int K_CREATE = 52;
    public static final int K_CROSS = 53;
    public static final int K_CURRENT_DATE = 54;
    public static final int K_CURRENT_TIME = 55;
    public static final int K_CURRENT_TIMESTAMP = 56;
    public static final int K_DATABASE = 57;
    public static final int K_DEFAULT = 58;
    public static final int K_DEFERRABLE = 59;
    public static final int K_DEFERRED = 60;
    public static final int K_DELETE = 61;
    public static final int K_DESC = 62;
    public static final int K_DETACH = 63;
    public static final int K_DISTINCT = 64;
    public static final int K_DROP = 65;
    public static final int K_EACH = 66;
    public static final int K_ELSE = 67;
    public static final int K_END = 68;
    public static final int K_ESCAPE = 69;
    public static final int K_EXCEPT = 70;
    public static final int K_EXCLUSIVE = 71;
    public static final int K_EXISTS = 72;
    public static final int K_EXPLAIN = 73;
    public static final int K_FAIL = 74;
    public static final int K_FOR = 75;
    public static final int K_FOREIGN = 76;
    public static final int K_FROM = 77;
    public static final int K_FULL = 78;
    public static final int K_GLOB = 79;
    public static final int K_GROUP = 80;
    public static final int K_HAVING = 81;
    public static final int K_IF = 82;
    public static final int K_IGNORE = 83;
    public static final int K_IMMEDIATE = 84;
    public static final int K_IN = 85;
    public static final int K_INDEX = 86;
    public static final int K_INDEXED = 87;
    public static final int K_INITIALLY = 88;
    public static final int K_INNER = 89;
    public static final int K_INSERT = 90;
    public static final int K_INSTEAD = 91;
    public static final int K_INTERSECT = 92;
    public static final int K_INTO = 93;
    public static final int K_IS = 94;
    public static final int K_ISNULL = 95;
    public static final int K_JOIN = 96;
    public static final int K_KEY = 97;
    public static final int K_LEFT = 98;
    public static final int K_LIKE = 99;
    public static final int K_LIMIT = 100;
    public static final int K_MATCH = 101;
    public static final int K_NATURAL = 102;
    public static final int K_NO = 103;
    public static final int K_NOT = 104;
    public static final int K_NOTNULL = 105;
    public static final int K_NULL = 106;
    public static final int K_OF = 107;
    public static final int K_OFFSET = 108;
    public static final int K_ON = 109;
    public static final int K_OR = 110;
    public static final int K_ORDER = 111;
    public static final int K_OUTER = 112;
    public static final int K_PLAN = 113;
    public static final int K_PRAGMA = 114;
    public static final int K_PRIMARY = 115;
    public static final int K_QUERY = 116;
    public static final int K_RAISE = 117;
    public static final int K_RECURSIVE = 118;
    public static final int K_REFERENCES = 119;
    public static final int K_REGEXP = 120;
    public static final int K_REINDEX = 121;
    public static final int K_RELEASE = 122;
    public static final int K_RENAME = 123;
    public static final int K_REPLACE = 124;
    public static final int K_RESTRICT = 125;
    public static final int K_RIGHT = 126;
    public static final int K_ROLLBACK = 127;
    public static final int K_ROW = 128;
    public static final int K_SAVEPOINT = 129;
    public static final int K_SELECT = 130;
    public static final int K_SET = 131;
    public static final int K_TABLE = 132;
    public static final int K_TEMP = 133;
    public static final int K_TEMPORARY = 134;
    public static final int K_THEN = 135;
    public static final int K_TO = 136;
    public static final int K_TRANSACTION = 137;
    public static final int K_TRIGGER = 138;
    public static final int K_UNION = 139;
    public static final int K_UNIQUE = 140;
    public static final int K_UPDATE = 141;
    public static final int K_USING = 142;
    public static final int K_VACUUM = 143;
    public static final int K_VALUES = 144;
    public static final int K_VIEW = 145;
    public static final int K_VIRTUAL = 146;
    public static final int K_WHEN = 147;
    public static final int K_WHERE = 148;
    public static final int K_WITH = 149;
    public static final int K_WITHOUT = 150;
    public static final int LT = 18;
    public static final int LT2 = 14;
    public static final int LT_EQ = 19;
    public static final int MINUS = 9;
    public static final int MOD = 13;
    public static final int MULTILINE_COMMENT = 160;
    public static final int NOT_EQ1 = 23;
    public static final int NOT_EQ2 = 24;
    public static final int NUMERIC_LITERAL = 155;
    public static final int OPEN_PAR = 3;
    public static final int PIPE = 17;
    public static final int PIPE2 = 11;
    public static final int PLUS = 8;
    public static final int RULE_alter_table_stmt = 4;
    public static final int RULE_analyze_stmt = 5;
    public static final int RULE_any_name = 84;
    public static final int RULE_attach_stmt = 6;
    public static final int RULE_begin_stmt = 7;
    public static final int RULE_binary_operator = 60;
    public static final int RULE_boolean_literal = 58;
    public static final int RULE_collation_name = 74;
    public static final int RULE_column_alias = 63;
    public static final int RULE_column_constraint = 35;
    public static final int RULE_column_def = 33;
    public static final int RULE_column_name = 73;
    public static final int RULE_column_name_list = 64;
    public static final int RULE_comma_separated_expr = 38;
    public static final int RULE_commit_stmt = 8;
    public static final int RULE_common_table_expression = 44;
    public static final int RULE_compound_operator = 55;
    public static final int RULE_conflict_clause = 36;
    public static final int RULE_create_index_stmt = 9;
    public static final int RULE_create_table_stmt = 10;
    public static final int RULE_create_trigger_stmt = 11;
    public static final int RULE_create_view_stmt = 12;
    public static final int RULE_create_virtual_table_stmt = 13;
    public static final int RULE_delete_stmt = 14;
    public static final int RULE_delete_stmt_limited = 15;
    public static final int RULE_detach_stmt = 16;
    public static final int RULE_drop_index_stmt = 17;
    public static final int RULE_drop_table_stmt = 18;
    public static final int RULE_drop_trigger_stmt = 19;
    public static final int RULE_drop_view_stmt = 20;
    public static final int RULE_error = 1;
    public static final int RULE_error_message = 61;
    public static final int RULE_expr = 37;
    public static final int RULE_foreign_key_clause = 39;
    public static final int RULE_foreign_table = 75;
    public static final int RULE_function_name = 67;
    public static final int RULE_index_name = 76;
    public static final int RULE_indexed_column = 41;
    public static final int RULE_insert_stmt = 21;
    public static final int RULE_join_clause = 52;
    public static final int RULE_join_constraint = 54;
    public static final int RULE_join_operator = 53;
    public static final int RULE_keyword = 65;
    public static final int RULE_limit_clause = 48;
    public static final int RULE_literal_value = 57;
    public static final int RULE_module_argument = 62;
    public static final int RULE_module_name = 79;
    public static final int RULE_name = 66;
    public static final int RULE_new_table_name = 72;
    public static final int RULE_order_clause = 46;
    public static final int RULE_ordering_term = 47;
    public static final int RULE_parse = 0;
    public static final int RULE_pragma_name = 80;
    public static final int RULE_pragma_stmt = 23;
    public static final int RULE_pragma_value = 49;
    public static final int RULE_qualified_table_name = 45;
    public static final int RULE_raise_function = 40;
    public static final int RULE_reindex_stmt = 24;
    public static final int RULE_release_stmt = 25;
    public static final int RULE_result_column = 50;
    public static final int RULE_rollback_stmt = 26;
    public static final int RULE_savepoint_name = 81;
    public static final int RULE_savepoint_stmt = 27;
    public static final int RULE_schema_name = 68;
    public static final int RULE_select_or_values = 29;
    public static final int RULE_select_stmt = 28;
    public static final int RULE_signed_number = 56;
    public static final int RULE_sql_stmt = 3;
    public static final int RULE_sql_stmt_list = 2;
    public static final int RULE_table_alias = 82;
    public static final int RULE_table_constraint = 42;
    public static final int RULE_table_function = 69;
    public static final int RULE_table_name = 70;
    public static final int RULE_table_or_index_name = 71;
    public static final int RULE_table_or_subquery = 51;
    public static final int RULE_transaction_name = 83;
    public static final int RULE_trigger_name = 77;
    public static final int RULE_type_name = 34;
    public static final int RULE_unary_operator = 59;
    public static final int RULE_update_stmt = 30;
    public static final int RULE_update_stmt_limited = 31;
    public static final int RULE_upsert_clause = 22;
    public static final int RULE_vacuum_stmt = 32;
    public static final int RULE_view_name = 78;
    public static final int RULE_with_clause = 43;
    public static final int SCOL = 1;
    public static final int SINGLE_LINE_COMMENT = 159;
    public static final int SPACES = 161;
    public static final int STAR = 7;
    public static final int STRING_LITERAL = 157;
    public static final int TILDE = 10;
    public static final int TRUE = 25;
    public static final int UNEXPECTED_CHAR = 162;
    public static final Vocabulary VOCABULARY = null;
    public static final int WITHOUT_ROWID = 151;
    public static final ATN _ATN = null;
    private static final String[] _LITERAL_NAMES = null;
    private static final String[] _SYMBOLIC_NAMES = null;
    protected static final DFA[] _decisionToDFA = null;
    public static final String _serializedATN = "\u0003悋Ꜫ脳맭䅼㯧瞆奤\u0003¤ؓ\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004\u0004\t\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t\u0007\u0004\b\t\b\u0004\t\t\t\u0004\n\t\n\u0004\u000b\t\u000b\u0004\f\t\f\u0004\r\t\r\u0004\u000e\t\u000e\u0004\u000f\t\u000f\u0004\u0010\t\u0010\u0004\u0011\t\u0011\u0004\u0012\t\u0012\u0004\u0013\t\u0013\u0004\u0014\t\u0014\u0004\u0015\t\u0015\u0004\u0016\t\u0016\u0004\u0017\t\u0017\u0004\u0018\t\u0018\u0004\u0019\t\u0019\u0004\u001a\t\u001a\u0004\u001b\t\u001b\u0004\u001c\t\u001c\u0004\u001d\t\u001d\u0004\u001e\t\u001e\u0004\u001f\t\u001f\u0004 \t \u0004!\t!\u0004\"\t\"\u0004#\t#\u0004$\t$\u0004%\t%\u0004&\t&\u0004'\t'\u0004(\t(\u0004)\t)\u0004*\t*\u0004+\t+\u0004,\t,\u0004-\t-\u0004.\t.\u0004/\t/\u00040\t0\u00041\t1\u00042\t2\u00043\t3\u00044\t4\u00045\t5\u00046\t6\u00047\t7\u00048\t8\u00049\t9\u0004:\t:\u0004;\t;\u0004<\t<\u0004=\t=\u0004>\t>\u0004?\t?\u0004@\t@\u0004A\tA\u0004B\tB\u0004C\tC\u0004D\tD\u0004E\tE\u0004F\tF\u0004G\tG\u0004H\tH\u0004I\tI\u0004J\tJ\u0004K\tK\u0004L\tL\u0004M\tM\u0004N\tN\u0004O\tO\u0004P\tP\u0004Q\tQ\u0004R\tR\u0004S\tS\u0004T\tT\u0004U\tU\u0004V\tV\u0003\u0002\u0003\u0002\u0007\u0002¯\n\u0002\f\u0002\u000e\u0002²\u000b\u0002\u0003\u0002\u0003\u0002\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0004\u0007\u0004º\n\u0004\f\u0004\u000e\u0004½\u000b\u0004\u0003\u0004\u0003\u0004\u0006\u0004Á\n\u0004\r\u0004\u000e\u0004Â\u0003\u0004\u0007\u0004Æ\n\u0004\f\u0004\u000e\u0004É\u000b\u0004\u0003\u0004\u0007\u0004Ì\n\u0004\f\u0004\u000e\u0004Ï\u000b\u0004\u0003\u0005\u0003\u0005\u0003\u0005\u0005\u0005Ô\n\u0005\u0005\u0005Ö\n\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0005\u0005ó\n\u0005\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0005\u0006ú\n\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0005\u0006Ă\n\u0006\u0003\u0006\u0005\u0006ą\n\u0006\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0005\u0007Ď\n\u0007\u0003\b\u0003\b\u0005\bĒ\n\b\u0003\b\u0003\b\u0003\b\u0003\b\u0003\t\u0003\t\u0005\tĚ\n\t\u0003\t\u0003\t\u0005\tĞ\n\t\u0005\tĠ\n\t\u0003\n\u0003\n\u0003\n\u0005\nĥ\n\n\u0005\nħ\n\n\u0003\u000b\u0003\u000b\u0005\u000bī\n\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0005\u000bı\n\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0005\u000bĶ\n\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0007\u000bĿ\n\u000b\f\u000b\u000e\u000bł\u000b\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0005\u000bŇ\n\u000b\u0003\f\u0003\f\u0005\fŋ\n\f\u0003\f\u0003\f\u0003\f\u0003\f\u0005\fő\n\f\u0003\f\u0003\f\u0003\f\u0005\fŖ\n\f\u0003\f\u0003\f\u0003\f\u0003\f\u0003\f\u0007\fŝ\n\f\f\f\u000e\fŠ\u000b\f\u0003\f\u0003\f\u0007\fŤ\n\f\f\f\u000e\fŧ\u000b\f\u0003\f\u0003\f\u0005\fū\n\f\u0003\f\u0003\f\u0005\fů\n\f\u0003\r\u0003\r\u0005\rų\n\r\u0003\r\u0003\r\u0003\r\u0003\r\u0005\rŹ\n\r\u0003\r\u0003\r\u0003\r\u0005\rž\n\r\u0003\r\u0003\r\u0003\r\u0003\r\u0003\r\u0005\rƅ\n\r\u0003\r\u0003\r\u0003\r\u0003\r\u0003\r\u0003\r\u0003\r\u0007\rƎ\n\r\f\r\u000e\rƑ\u000b\r\u0005\rƓ\n\r\u0005\rƕ\n\r\u0003\r\u0003\r\u0003\r\u0003\r\u0005\rƛ\n\r\u0003\r\u0003\r\u0003\r\u0003\r\u0005\rơ\n\r\u0003\r\u0003\r\u0005\rƥ\n\r\u0003\r\u0003\r\u0003\r\u0003\r\u0003\r\u0005\rƬ\n\r\u0003\r\u0003\r\u0006\rư\n\r\r\r\u000e\rƱ\u0003\r\u0003\r\u0003\u000e\u0003\u000e\u0005\u000eƸ\n\u000e\u0003\u000e\u0003\u000e\u0003\u000e\u0003\u000e\u0005\u000eƾ\n\u000e\u0003\u000e\u0003\u000e\u0003\u000e\u0005\u000eǃ\n\u000e\u0003\u000e\u0003\u000e\u0003\u000e\u0003\u000e\u0007\u000eǉ\n\u000e\f\u000e\u000e\u000eǌ\u000b\u000e\u0005\u000eǎ\n\u000e\u0003\u000e\u0003\u000e\u0003\u000e\u0003\u000f\u0003\u000f\u0003\u000f\u0003\u000f\u0003\u000f\u0003\u000f\u0005\u000fǙ\n\u000f\u0003\u000f\u0003\u000f\u0003\u000f\u0005\u000fǞ\n\u000f\u0003\u000f\u0003\u000f\u0003\u000f\u0003\u000f\u0003\u000f\u0003\u000f\u0003\u000f\u0007\u000fǧ\n\u000f\f\u000f\u000e\u000fǪ\u000b\u000f\u0003\u000f\u0003\u000f\u0005\u000fǮ\n\u000f\u0003\u0010\u0005\u0010Ǳ\n\u0010\u0003\u0010\u0003\u0010\u0003\u0010\u0003\u0010\u0003\u0010\u0005\u0010Ǹ\n\u0010\u0003\u0011\u0005\u0011ǻ\n\u0011\u0003\u0011\u0003\u0011\u0003\u0011\u0003\u0011\u0003\u0011\u0005\u0011Ȃ\n\u0011\u0003\u0011\u0005\u0011ȅ\n\u0011\u0003\u0011\u0005\u0011Ȉ\n\u0011\u0003\u0012\u0003\u0012\u0005\u0012Ȍ\n\u0012\u0003\u0012\u0003\u0012\u0003\u0013\u0003\u0013\u0003\u0013\u0003\u0013\u0005\u0013Ȕ\n\u0013\u0003\u0013\u0003\u0013\u0003\u0013\u0005\u0013ș\n\u0013\u0003\u0013\u0003\u0013\u0003\u0014\u0003\u0014\u0003\u0014\u0003\u0014\u0005\u0014ȡ\n\u0014\u0003\u0014\u0003\u0014\u0003\u0014\u0005\u0014Ȧ\n\u0014\u0003\u0014\u0003\u0014\u0003\u0015\u0003\u0015\u0003\u0015\u0003\u0015\u0005\u0015Ȯ\n\u0015\u0003\u0015\u0003\u0015\u0003\u0015\u0005\u0015ȳ\n\u0015\u0003\u0015\u0003\u0015\u0003\u0016\u0003\u0016\u0003\u0016\u0003\u0016\u0005\u0016Ȼ\n\u0016\u0003\u0016\u0003\u0016\u0003\u0016\u0005\u0016ɀ\n\u0016\u0003\u0016\u0003\u0016\u0003\u0017\u0005\u0017Ʌ\n\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0005\u0017ɘ\n\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0005\u0017ɞ\n\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0005\u0017ɣ\n\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0007\u0017ɩ\n\u0017\f\u0017\u000e\u0017ɬ\u000b\u0017\u0003\u0017\u0003\u0017\u0005\u0017ɰ\n\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0007\u0017ɻ\n\u0017\f\u0017\u000e\u0017ɾ\u000b\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0005\u0017ʃ\n\u0017\u0003\u0017\u0005\u0017ʆ\n\u0017\u0003\u0018\u0003\u0018\u0003\u0018\u0003\u0018\u0003\u0018\u0003\u0018\u0007\u0018ʎ\n\u0018\f\u0018\u000e\u0018ʑ\u000b\u0018\u0003\u0018\u0003\u0018\u0003\u0018\u0005\u0018ʖ\n\u0018\u0005\u0018ʘ\n\u0018\u0003\u0018\u0003\u0018\u0003\u0018\u0003\u0018\u0003\u0018\u0005\u0018ʟ\n\u0018\u0003\u0018\u0003\u0018\u0003\u0018\u0003\u0018\u0003\u0018\u0005\u0018ʦ\n\u0018\u0003\u0018\u0003\u0018\u0003\u0018\u0007\u0018ʫ\n\u0018\f\u0018\u000e\u0018ʮ\u000b\u0018\u0003\u0018\u0003\u0018\u0005\u0018ʲ\n\u0018\u0005\u0018ʴ\n\u0018\u0003\u0019\u0003\u0019\u0003\u0019\u0003\u0019\u0005\u0019ʺ\n\u0019\u0003\u0019\u0003\u0019\u0003\u0019\u0003\u0019\u0003\u0019\u0003\u0019\u0003\u0019\u0005\u0019˃\n\u0019\u0003\u001a\u0003\u001a\u0003\u001a\u0003\u001a\u0003\u001a\u0005\u001aˊ\n\u001a\u0003\u001a\u0003\u001a\u0005\u001aˎ\n\u001a\u0005\u001aː\n\u001a\u0003\u001b\u0003\u001b\u0005\u001b˔\n\u001b\u0003\u001b\u0003\u001b\u0003\u001c\u0003\u001c\u0003\u001c\u0005\u001c˛\n\u001c\u0005\u001c˝\n\u001c\u0003\u001c\u0003\u001c\u0005\u001cˡ\n\u001c\u0003\u001c\u0005\u001cˤ\n\u001c\u0003\u001d\u0003\u001d\u0003\u001d\u0003\u001e\u0005\u001e˪\n\u001e\u0003\u001e\u0003\u001e\u0003\u001e\u0003\u001e\u0007\u001e˰\n\u001e\f\u001e\u000e\u001e˳\u000b\u001e\u0003\u001e\u0005\u001e˶\n\u001e\u0003\u001e\u0005\u001e˹\n\u001e\u0003\u001f\u0003\u001f\u0005\u001f˽\n\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0007\u001f̂\n\u001f\f\u001f\u000e\u001f̅\u000b\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0007\u001f̋\n\u001f\f\u001f\u000e\u001f̎\u000b\u001f\u0003\u001f\u0005\u001f̑\n\u001f\u0005\u001f̓\n\u001f\u0003\u001f\u0003\u001f\u0005\u001f̗\n\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0005\u001f̞\n\u001f\u0005\u001f̠\n\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0007\u001f̫\n\u001f\f\u001f\u000e\u001f̮\u000b\u001f\u0005\u001f̰\n\u001f\u0003 \u0005 ̳\n \u0003 \u0003 \u0003 \u0003 \u0003 \u0003 \u0003 \u0003 \u0003 \u0003 \u0003 \u0005 ̀\n \u0003 \u0003 \u0003 \u0003 \u0005 ͆\n \u0003 \u0003 \u0003 \u0003 \u0003 \u0005 ͍\n \u0003 \u0003 \u0003 \u0007 ͒\n \f \u000e ͕\u000b \u0003 \u0003 \u0005 ͙\n \u0003!\u0005!͜\n!\u0003!\u0003!\u0003!\u0003!\u0003!\u0003!\u0003!\u0003!\u0003!\u0003!\u0003!\u0005!ͩ\n!\u0003!\u0003!\u0003!\u0003!\u0005!ͯ\n!\u0003!\u0003!\u0003!\u0003!\u0003!\u0005!Ͷ\n!\u0003!\u0003!\u0003!\u0007!ͻ\n!\f!\u000e!;\u000b!\u0003!\u0003!\u0005!\u0382\n!\u0003!\u0005!΅\n!\u0003!\u0005!Έ\n!\u0003\"\u0003\"\u0005\"Ό\n\"\u0003#\u0003#\u0005#ΐ\n#\u0003#\u0007#Γ\n#\f#\u000e#Ζ\u000b#\u0003$\u0006$Ι\n$\r$\u000e$Κ\u0003$\u0003$\u0003$\u0003$\u0003$\u0003$\u0003$\u0003$\u0003$\u0003$\u0005$Χ\n$\u0003%\u0003%\u0005%Ϋ\n%\u0003%\u0003%\u0003%\u0005%ΰ\n%\u0003%\u0003%\u0005%δ\n%\u0003%\u0005%η\n%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0005%ω\n%\u0003%\u0003%\u0003%\u0005%ώ\n%\u0003&\u0003&\u0003&\u0005&ϓ\n&\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0005'ϛ\n'\u0003'\u0003'\u0003'\u0005'Ϡ\n'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0005'ϩ\n'\u0003'\u0003'\u0005'ϭ\n'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0005'Ͻ\n'\u0003'\u0005'Ѐ\n'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0005'Ј\n'\u0003'\u0003'\u0003'\u0003'\u0003'\u0006'Џ\n'\r'\u000e'А\u0003'\u0003'\u0005'Е\n'\u0003'\u0003'\u0003'\u0005'К\n'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0005'У\n'\u0003'\u0003'\u0003'\u0005'Ш\n'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0003'\u0005'д\n'\u0003'\u0003'\u0003'\u0003'\u0005'к\n'\u0003'\u0003'\u0003'\u0003'\u0003'\u0005'с\n'\u0003'\u0003'\u0005'х\n'\u0003'\u0003'\u0003'\u0003'\u0005'ы\n'\u0003'\u0003'\u0003'\u0003'\u0005'ё\n'\u0003'\u0003'\u0003'\u0003'\u0005'ї\n'\u0003'\u0003'\u0003'\u0005'ќ\n'\u0003'\u0003'\u0005'Ѡ\n'\u0007'Ѣ\n'\f'\u000e'ѥ\u000b'\u0003(\u0003(\u0003(\u0007(Ѫ\n(\f(\u000e(ѭ\u000b(\u0003)\u0003)\u0003)\u0003)\u0003)\u0003)\u0007)ѵ\n)\f)\u000e)Ѹ\u000b)\u0003)\u0003)\u0005)Ѽ\n)\u0003)\u0003)\u0003)\u0003)\u0003)\u0003)\u0003)\u0003)\u0003)\u0003)\u0005)҈\n)\u0003)\u0003)\u0005)Ҍ\n)\u0007)Ҏ\n)\f)\u000e)ґ\u000b)\u0003)\u0005)Ҕ\n)\u0003)\u0003)\u0003)\u0003)\u0003)\u0005)қ\n)\u0005)ҝ\n)\u0003*\u0003*\u0003*\u0003*\u0003*\u0003*\u0005*ҥ\n*\u0003*\u0003*\u0003+\u0003+\u0005+ҫ\n+\u0003+\u0003+\u0005+ү\n+\u0003+\u0005+Ҳ\n+\u0003,\u0003,\u0005,Ҷ\n,\u0003,\u0003,\u0003,\u0005,һ\n,\u0003,\u0003,\u0003,\u0003,\u0007,Ӂ\n,\f,\u000e,ӄ\u000b,\u0003,\u0003,\u0003,\u0003,\u0003,\u0003,\u0003,\u0003,\u0003,\u0003,\u0003,\u0003,\u0003,\u0003,\u0007,Ӕ\n,\f,\u000e,ӗ\u000b,\u0003,\u0003,\u0003,\u0005,Ӝ\n,\u0003-\u0003-\u0005-Ӡ\n-\u0003-\u0003-\u0003-\u0007-ӥ\n-\f-\u000e-Ө\u000b-\u0003.\u0003.\u0003.\u0003.\u0003.\u0007.ӯ\n.\f.\u000e.Ӳ\u000b.\u0003.\u0003.\u0005.Ӷ\n.\u0003.\u0003.\u0003.\u0003.\u0003.\u0003/\u0003/\u0003/\u0005/Ԁ\n/\u0003/\u0003/\u0003/\u0005/ԅ\n/\u0003/\u0003/\u0003/\u0003/\u0003/\u0005/Ԍ\n/\u00030\u00030\u00030\u00030\u00030\u00070ԓ\n0\f0\u000e0Ԗ\u000b0\u00031\u00031\u00031\u00051ԛ\n1\u00031\u00051Ԟ\n1\u00032\u00032\u00032\u00032\u00052Ԥ\n2\u00033\u00033\u00033\u00033\u00053Ԫ\n3\u00034\u00034\u00034\u00034\u00034\u00034\u00034\u00054Գ\n4\u00034\u00054Զ\n4\u00054Ը\n4\u00035\u00035\u00035\u00055Խ\n5\u00035\u00035\u00055Ձ\n5\u00035\u00055Մ\n5\u00035\u00035\u00035\u00035\u00035\u00055Ջ\n5\u00035\u00035\u00035\u00055Ր\n5\u00035\u00035\u00035\u00035\u00035\u00075\u0557\n5\f5\u000e5՚\u000b5\u00055՜\n5\u00035\u00035\u00055ՠ\n5\u00035\u00055գ\n5\u00035\u00035\u00035\u00035\u00075թ\n5\f5\u000e5լ\u000b5\u00035\u00055կ\n5\u00035\u00035\u00035\u00035\u00035\u00035\u00055շ\n5\u00035\u00055պ\n5\u00055ռ\n5\u00036\u00036\u00036\u00036\u00036\u00076փ\n6\f6\u000e6ֆ\u000b6\u00037\u00037\u00057֊\n7\u00037\u00037\u00057֎\n7\u00037\u00037\u00057֒\n7\u00037\u00057֕\n7\u00038\u00038\u00038\u00038\u00038\u00038\u00038\u00078֞\n8\f8\u000e8֡\u000b8\u00038\u00038\u00058֥\n8\u00039\u00039\u00039\u00039\u00039\u00059֬\n9\u0003:\u0005:֯\n:\u0003:\u0003:\u0003;\u0003;\u0003;\u0003;\u0003;\u0003;\u0003;\u0003;\u0005;ֻ\n;\u0003<\u0003<\u0003=\u0003=\u0003>\u0003>\u0003>\u0003>\u0003>\u0003>\u0003>\u0003>\u0005>\u05c9\n>\u0003?\u0003?\u0003@\u0003@\u0005@\u05cf\n@\u0003A\u0003A\u0003B\u0003B\u0003B\u0003B\u0007Bח\nB\fB\u000eBך\u000bB\u0003B\u0003B\u0003C\u0003C\u0003D\u0003D\u0003E\u0003E\u0003F\u0003F\u0003G\u0003G\u0003H\u0003H\u0003I\u0003I\u0003J\u0003J\u0003K\u0003K\u0003L\u0003L\u0003M\u0003M\u0003N\u0003N\u0003O\u0003O\u0003P\u0003P\u0003Q\u0003Q\u0003R\u0003R\u0003S\u0003S\u0003T\u0003T\u0003T\u0003T\u0003T\u0003T\u0005T؆\nT\u0003U\u0003U\u0003V\u0003V\u0003V\u0003V\u0003V\u0003V\u0003V\u0005Vؑ\nV\u0003V\u0004ŞΚ\u0003LW\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e ¢¤¦¨ª\u0002\u0015\u0005\u0002>>IIVV\u0004\u000233FF\u0003\u0002\u0087\u0088\u0004\u0002!!BB\u0004\u0002&&@@\u0007\u0002\u001d\u001dLLUU~~\u0081\u0081\u0006\u0002QQeeggzz\u0004\u0002??\u008f\u008f\u0005\u0002\u001d\u001dLL\u0081\u0081\u0004\u0002\u0007\u0007nn\u0003\u0002\n\u000b\u0003\u0002\u001b\u001c\u0004\u0002\n\fjj\u0004\u0002\t\t\u000e\u000f\u0003\u0002\u0010\u0013\u0003\u0002\u0014\u0017\u0004\u0002\b\b\u0018\u001a\u0004\u0002\u009c\u009c\u009f\u009f\u0003\u0002\u001d\u0098\u0002܀\u0002°\u0003\u0002\u0002\u0002\u0004µ\u0003\u0002\u0002\u0002\u0006»\u0003\u0002\u0002\u0002\bÕ\u0003\u0002\u0002\u0002\nô\u0003\u0002\u0002\u0002\fĆ\u0003\u0002\u0002\u0002\u000eď\u0003\u0002\u0002\u0002\u0010ė\u0003\u0002\u0002\u0002\u0012ġ\u0003\u0002\u0002\u0002\u0014Ĩ\u0003\u0002\u0002\u0002\u0016ň\u0003\u0002\u0002\u0002\u0018Ű\u0003\u0002\u0002\u0002\u001aƵ\u0003\u0002\u0002\u0002\u001cǒ\u0003\u0002\u0002\u0002\u001eǰ\u0003\u0002\u0002\u0002 Ǻ\u0003\u0002\u0002\u0002\"ȉ\u0003\u0002\u0002\u0002$ȏ\u0003\u0002\u0002\u0002&Ȝ\u0003\u0002\u0002\u0002(ȩ\u0003\u0002\u0002\u0002*ȶ\u0003\u0002\u0002\u0002,Ʉ\u0003\u0002\u0002\u0002.ʇ\u0003\u0002\u0002\u00020ʵ\u0003\u0002\u0002\u00022˄\u0003\u0002\u0002\u00024ˑ\u0003\u0002\u0002\u00026˗\u0003\u0002\u0002\u00028˥\u0003\u0002\u0002\u0002:˩\u0003\u0002\u0002\u0002<̯\u0003\u0002\u0002\u0002>̲\u0003\u0002\u0002\u0002@͛\u0003\u0002\u0002\u0002BΉ\u0003\u0002\u0002\u0002D\u038d\u0003\u0002\u0002\u0002FΘ\u0003\u0002\u0002\u0002HΪ\u0003\u0002\u0002\u0002Jϒ\u0003\u0002\u0002\u0002LЙ\u0003\u0002\u0002\u0002NѦ\u0003\u0002\u0002\u0002PѮ\u0003\u0002\u0002\u0002RҞ\u0003\u0002\u0002\u0002TҪ\u0003\u0002\u0002\u0002Vҵ\u0003\u0002\u0002\u0002Xӝ\u0003\u0002\u0002\u0002Zө\u0003\u0002\u0002\u0002\\ӿ\u0003\u0002\u0002\u0002^ԍ\u0003\u0002\u0002\u0002`ԗ\u0003\u0002\u0002\u0002bԟ\u0003\u0002\u0002\u0002dԩ\u0003\u0002\u0002\u0002fԷ\u0003\u0002\u0002\u0002hջ\u0003\u0002\u0002\u0002jս\u0003\u0002\u0002\u0002l֔\u0003\u0002\u0002\u0002n֤\u0003\u0002\u0002\u0002p֫\u0003\u0002\u0002\u0002r֮\u0003\u0002\u0002\u0002tֺ\u0003\u0002\u0002\u0002vּ\u0003\u0002\u0002\u0002x־\u0003\u0002\u0002\u0002z\u05c8\u0003\u0002\u0002\u0002|\u05ca\u0003\u0002\u0002\u0002~\u05ce\u0003\u0002\u0002\u0002\u0080א\u0003\u0002\u0002\u0002\u0082ג\u0003\u0002\u0002\u0002\u0084ם\u0003\u0002\u0002\u0002\u0086ן\u0003\u0002\u0002\u0002\u0088ס\u0003\u0002\u0002\u0002\u008aף\u0003\u0002\u0002\u0002\u008cץ\u0003\u0002\u0002\u0002\u008eק\u0003\u0002\u0002\u0002\u0090ש\u0003\u0002\u0002\u0002\u0092\u05eb\u0003\u0002\u0002\u0002\u0094\u05ed\u0003\u0002\u0002\u0002\u0096ׯ\u0003\u0002\u0002\u0002\u0098ױ\u0003\u0002\u0002\u0002\u009a׳\u0003\u0002\u0002\u0002\u009c\u05f5\u0003\u0002\u0002\u0002\u009e\u05f7\u0003\u0002\u0002\u0002 \u05f9\u0003\u0002\u0002\u0002¢\u05fb\u0003\u0002\u0002\u0002¤\u05fd\u0003\u0002\u0002\u0002¦\u0605\u0003\u0002\u0002\u0002¨؇\u0003\u0002\u0002\u0002ªؐ\u0003\u0002\u0002\u0002¬¯\u0005\u0006\u0004\u0002\u00ad¯\u0005\u0004\u0003\u0002®¬\u0003\u0002\u0002\u0002®\u00ad\u0003\u0002\u0002\u0002¯²\u0003\u0002\u0002\u0002°®\u0003\u0002\u0002\u0002°±\u0003\u0002\u0002\u0002±³\u0003\u0002\u0002\u0002²°\u0003\u0002\u0002\u0002³´\u0007\u0002\u0002\u0003´\u0003\u0003\u0002\u0002\u0002µ¶\u0007¤\u0002\u0002¶·\b\u0003\u0001\u0002·\u0005\u0003\u0002\u0002\u0002¸º\u0007\u0003\u0002\u0002¹¸\u0003\u0002\u0002\u0002º½\u0003\u0002\u0002\u0002»¹\u0003\u0002\u0002\u0002»¼\u0003\u0002\u0002\u0002¼¾\u0003\u0002\u0002\u0002½»\u0003\u0002\u0002\u0002¾Ç\u0005\b\u0005\u0002¿Á\u0007\u0003\u0002\u0002À¿\u0003\u0002\u0002\u0002ÁÂ\u0003\u0002\u0002\u0002ÂÀ\u0003\u0002\u0002\u0002ÂÃ\u0003\u0002\u0002\u0002ÃÄ\u0003\u0002\u0002\u0002ÄÆ\u0005\b\u0005\u0002ÅÀ\u0003\u0002\u0002\u0002ÆÉ\u0003\u0002\u0002\u0002ÇÅ\u0003\u0002\u0002\u0002ÇÈ\u0003\u0002\u0002\u0002ÈÍ\u0003\u0002\u0002\u0002ÉÇ\u0003\u0002\u0002\u0002ÊÌ\u0007\u0003\u0002\u0002ËÊ\u0003\u0002\u0002\u0002ÌÏ\u0003\u0002\u0002\u0002ÍË\u0003\u0002\u0002\u0002ÍÎ\u0003\u0002\u0002\u0002Î\u0007\u0003\u0002\u0002\u0002ÏÍ\u0003\u0002\u0002\u0002ÐÓ\u0007K\u0002\u0002ÑÒ\u0007v\u0002\u0002ÒÔ\u0007s\u0002\u0002ÓÑ\u0003\u0002\u0002\u0002ÓÔ\u0003\u0002\u0002\u0002ÔÖ\u0003\u0002\u0002\u0002ÕÐ\u0003\u0002\u0002\u0002ÕÖ\u0003\u0002\u0002\u0002Öò\u0003\u0002\u0002\u0002×ó\u0005\n\u0006\u0002Øó\u0005\f\u0007\u0002Ùó\u0005\u000e\b\u0002Úó\u0005\u0010\t\u0002Ûó\u0005\u0012\n\u0002Üó\u0005\u0014\u000b\u0002Ýó\u0005\u0016\f\u0002Þó\u0005\u0018\r\u0002ßó\u0005\u001a\u000e\u0002àó\u0005\u001c\u000f\u0002áó\u0005\u001e\u0010\u0002âó\u0005 \u0011\u0002ãó\u0005\"\u0012\u0002äó\u0005$\u0013\u0002åó\u0005&\u0014\u0002æó\u0005(\u0015\u0002çó\u0005*\u0016\u0002èó\u0005,\u0017\u0002éó\u00050\u0019\u0002êó\u00052\u001a\u0002ëó\u00054\u001b\u0002ìó\u00056\u001c\u0002íó\u00058\u001d\u0002îó\u0005:\u001e\u0002ïó\u0005> \u0002ðó\u0005@!\u0002ñó\u0005B\"\u0002ò×\u0003\u0002\u0002\u0002òØ\u0003\u0002\u0002\u0002òÙ\u0003\u0002\u0002\u0002òÚ\u0003\u0002\u0002\u0002òÛ\u0003\u0002\u0002\u0002òÜ\u0003\u0002\u0002\u0002òÝ\u0003\u0002\u0002\u0002òÞ\u0003\u0002\u0002\u0002òß\u0003\u0002\u0002\u0002òà\u0003\u0002\u0002\u0002òá\u0003\u0002\u0002\u0002òâ\u0003\u0002\u0002\u0002òã\u0003\u0002\u0002\u0002òä\u0003\u0002\u0002\u0002òå\u0003\u0002\u0002\u0002òæ\u0003\u0002\u0002\u0002òç\u0003\u0002\u0002\u0002òè\u0003\u0002\u0002\u0002òé\u0003\u0002\u0002\u0002òê\u0003\u0002\u0002\u0002òë\u0003\u0002\u0002\u0002òì\u0003\u0002\u0002\u0002òí\u0003\u0002\u0002\u0002òî\u0003\u0002\u0002\u0002òï\u0003\u0002\u0002\u0002òð\u0003\u0002\u0002\u0002òñ\u0003\u0002\u0002\u0002ó\t\u0003\u0002\u0002\u0002ôõ\u0007\"\u0002\u0002õù\u0007\u0086\u0002\u0002ö÷\u0005\u008aF\u0002÷ø\u0007\u0004\u0002\u0002øú\u0003\u0002\u0002\u0002ùö\u0003\u0002\u0002\u0002ùú\u0003\u0002\u0002\u0002úû\u0003\u0002\u0002\u0002ûĄ\u0005\u008eH\u0002üý\u0007}\u0002\u0002ýþ\u0007\u008a\u0002\u0002þą\u0005\u0092J\u0002ÿā\u0007\u001f\u0002\u0002ĀĂ\u00072\u0002\u0002āĀ\u0003\u0002\u0002\u0002āĂ\u0003\u0002\u0002\u0002Ăă\u0003\u0002\u0002\u0002ăą\u0005D#\u0002Ąü\u0003\u0002\u0002\u0002Ąÿ\u0003\u0002\u0002\u0002ą\u000b\u0003\u0002\u0002\u0002Ćč\u0007#\u0002\u0002ćĎ\u0005\u008aF\u0002ĈĎ\u0005\u0090I\u0002ĉĊ\u0005\u008aF\u0002Ċċ\u0007\u0004\u0002\u0002ċČ\u0005\u0090I\u0002ČĎ\u0003\u0002\u0002\u0002čć\u0003\u0002\u0002\u0002čĈ\u0003\u0002\u0002\u0002čĉ\u0003\u0002\u0002\u0002čĎ\u0003\u0002\u0002\u0002Ď\r\u0003\u0002\u0002\u0002ďđ\u0007'\u0002\u0002ĐĒ\u0007;\u0002\u0002đĐ\u0003\u0002\u0002\u0002đĒ\u0003\u0002\u0002\u0002Ēē\u0003\u0002\u0002\u0002ēĔ\u0005L'\u0002Ĕĕ\u0007%\u0002\u0002ĕĖ\u0005\u008aF\u0002Ė\u000f\u0003\u0002\u0002\u0002ėę\u0007*\u0002\u0002ĘĚ\t\u0002\u0002\u0002ęĘ\u0003\u0002\u0002\u0002ęĚ\u0003\u0002\u0002\u0002Ěğ\u0003\u0002\u0002\u0002ěĝ\u0007\u008b\u0002\u0002ĜĞ\u0005¨U\u0002ĝĜ\u0003\u0002\u0002\u0002ĝĞ\u0003\u0002\u0002\u0002ĞĠ\u0003\u0002\u0002\u0002ğě\u0003\u0002\u0002\u0002ğĠ\u0003\u0002\u0002\u0002Ġ\u0011\u0003\u0002\u0002\u0002ġĦ\t\u0003\u0002\u0002ĢĤ\u0007\u008b\u0002\u0002ģĥ\u0005¨U\u0002Ĥģ\u0003\u0002\u0002\u0002Ĥĥ\u0003\u0002\u0002\u0002ĥħ\u0003\u0002\u0002\u0002ĦĢ\u0003\u0002\u0002\u0002Ħħ\u0003\u0002\u0002\u0002ħ\u0013\u0003\u0002\u0002\u0002ĨĪ\u00076\u0002\u0002ĩī\u0007\u008e\u0002\u0002Īĩ\u0003\u0002\u0002\u0002Īī\u0003\u0002\u0002\u0002īĬ\u0003\u0002\u0002\u0002Ĭİ\u0007X\u0002\u0002ĭĮ\u0007T\u0002\u0002Įį\u0007j\u0002\u0002įı\u0007J\u0002\u0002İĭ\u0003\u0002\u0002\u0002İı\u0003\u0002\u0002\u0002ıĵ\u0003\u0002\u0002\u0002Ĳĳ\u0005\u008aF\u0002ĳĴ\u0007\u0004\u0002\u0002ĴĶ\u0003\u0002\u0002\u0002ĵĲ\u0003\u0002\u0002\u0002ĵĶ\u0003\u0002\u0002\u0002Ķķ\u0003\u0002\u0002\u0002ķĸ\u0005\u009aN\u0002ĸĹ\u0007o\u0002\u0002Ĺĺ\u0005\u008eH\u0002ĺĻ\u0007\u0005\u0002\u0002Ļŀ\u0005T+\u0002ļĽ\u0007\u0007\u0002\u0002ĽĿ\u0005T+\u0002ľļ\u0003\u0002\u0002\u0002Ŀł\u0003\u0002\u0002\u0002ŀľ\u0003\u0002\u0002\u0002ŀŁ\u0003\u0002\u0002\u0002ŁŃ\u0003\u0002\u0002\u0002łŀ\u0003\u0002\u0002\u0002Ńņ\u0007\u0006\u0002\u0002ńŅ\u0007\u0096\u0002\u0002ŅŇ\u0005L'\u0002ņń\u0003\u0002\u0002\u0002ņŇ\u0003\u0002\u0002\u0002Ň\u0015\u0003\u0002\u0002\u0002ňŊ\u00076\u0002\u0002ŉŋ\t\u0004\u0002\u0002Ŋŉ\u0003\u0002\u0002\u0002Ŋŋ\u0003\u0002\u0002\u0002ŋŌ\u0003\u0002\u0002\u0002ŌŐ\u0007\u0086\u0002\u0002ōŎ\u0007T\u0002\u0002Ŏŏ\u0007j\u0002\u0002ŏő\u0007J\u0002\u0002Őō\u0003\u0002\u0002\u0002Őő\u0003\u0002\u0002\u0002őŕ\u0003\u0002\u0002\u0002Œœ\u0005\u008aF\u0002œŔ\u0007\u0004\u0002\u0002ŔŖ\u0003\u0002\u0002\u0002ŕŒ\u0003\u0002\u0002\u0002ŕŖ\u0003\u0002\u0002\u0002Ŗŗ\u0003\u0002\u0002\u0002ŗŮ\u0005\u008eH\u0002Řř\u0007\u0005\u0002\u0002řŞ\u0005D#\u0002Śś\u0007\u0007\u0002\u0002śŝ\u0005D#\u0002ŜŚ\u0003\u0002\u0002\u0002ŝŠ\u0003\u0002\u0002\u0002Şş\u0003\u0002\u0002\u0002ŞŜ\u0003\u0002\u0002\u0002şť\u0003\u0002\u0002\u0002ŠŞ\u0003\u0002\u0002\u0002šŢ\u0007\u0007\u0002\u0002ŢŤ\u0005V,\u0002ţš\u0003\u0002\u0002\u0002Ťŧ\u0003\u0002\u0002\u0002ťţ\u0003\u0002\u0002\u0002ťŦ\u0003\u0002\u0002\u0002ŦŨ\u0003\u0002\u0002\u0002ŧť\u0003\u0002\u0002\u0002ŨŪ\u0007\u0006\u0002\u0002ũū\u0007\u0099\u0002\u0002Ūũ\u0003\u0002\u0002\u0002Ūū\u0003\u0002\u0002\u0002ūů\u0003\u0002\u0002\u0002Ŭŭ\u0007%\u0002\u0002ŭů\u0005:\u001e\u0002ŮŘ\u0003\u0002\u0002\u0002ŮŬ\u0003\u0002\u0002\u0002ů\u0017\u0003\u0002\u0002\u0002ŰŲ\u00076\u0002\u0002űų\t\u0004\u0002\u0002Ųű\u0003\u0002\u0002\u0002Ųų\u0003\u0002\u0002\u0002ųŴ\u0003\u0002\u0002\u0002ŴŸ\u0007\u008c\u0002\u0002ŵŶ\u0007T\u0002\u0002Ŷŷ\u0007j\u0002\u0002ŷŹ\u0007J\u0002\u0002Ÿŵ\u0003\u0002\u0002\u0002ŸŹ\u0003\u0002\u0002\u0002ŹŽ\u0003\u0002\u0002\u0002źŻ\u0005\u008aF\u0002Żż\u0007\u0004\u0002\u0002żž\u0003\u0002\u0002\u0002Žź\u0003\u0002\u0002\u0002Žž\u0003\u0002\u0002\u0002žſ\u0003\u0002\u0002\u0002ſƄ\u0005\u009cO\u0002ƀƅ\u0007)\u0002\u0002Ɓƅ\u0007 \u0002\u0002Ƃƃ\u0007]\u0002\u0002ƃƅ\u0007m\u0002\u0002Ƅƀ\u0003\u0002\u0002\u0002ƄƁ\u0003\u0002\u0002\u0002ƄƂ\u0003\u0002\u0002\u0002Ƅƅ\u0003\u0002\u0002\u0002ƅƔ\u0003\u0002\u0002\u0002Ɔƕ\u0007?\u0002\u0002Ƈƕ\u0007\\\u0002\u0002ƈƒ\u0007\u008f\u0002\u0002ƉƊ\u0007m\u0002\u0002ƊƏ\u0005\u0094K\u0002Ƌƌ\u0007\u0007\u0002\u0002ƌƎ\u0005\u0094K\u0002ƍƋ\u0003\u0002\u0002\u0002ƎƑ\u0003\u0002\u0002\u0002Əƍ\u0003\u0002\u0002\u0002ƏƐ\u0003\u0002\u0002\u0002ƐƓ\u0003\u0002\u0002\u0002ƑƏ\u0003\u0002\u0002\u0002ƒƉ\u0003\u0002\u0002\u0002ƒƓ\u0003\u0002\u0002\u0002Ɠƕ\u0003\u0002\u0002\u0002ƔƆ\u0003\u0002\u0002\u0002ƔƇ\u0003\u0002\u0002\u0002Ɣƈ\u0003\u0002\u0002\u0002ƕƖ\u0003\u0002\u0002\u0002Ɩƚ\u0007o\u0002\u0002ƗƘ\u0005\u008aF\u0002Ƙƙ\u0007\u0004\u0002\u0002ƙƛ\u0003\u0002\u0002\u0002ƚƗ\u0003\u0002\u0002\u0002ƚƛ\u0003\u0002\u0002\u0002ƛƜ\u0003\u0002\u0002\u0002ƜƠ\u0005\u008eH\u0002Ɲƞ\u0007M\u0002\u0002ƞƟ\u0007D\u0002\u0002Ɵơ\u0007\u0082\u0002\u0002ƠƝ\u0003\u0002\u0002\u0002Ơơ\u0003\u0002\u0002\u0002ơƤ\u0003\u0002\u0002\u0002Ƣƣ\u0007\u0095\u0002\u0002ƣƥ\u0005L'\u0002ƤƢ\u0003\u0002\u0002\u0002Ƥƥ\u0003\u0002\u0002\u0002ƥƦ\u0003\u0002\u0002\u0002ƦƯ\u0007*\u0002\u0002ƧƬ\u0005> \u0002ƨƬ\u0005,\u0017\u0002ƩƬ\u0005\u001e\u0010\u0002ƪƬ\u0005:\u001e\u0002ƫƧ\u0003\u0002\u0002\u0002ƫƨ\u0003\u0002\u0002\u0002ƫƩ\u0003\u0002\u0002\u0002ƫƪ\u0003\u0002\u0002\u0002Ƭƭ\u0003\u0002\u0002\u0002ƭƮ\u0007\u0003\u0002\u0002Ʈư\u0003\u0002\u0002\u0002Ưƫ\u0003\u0002\u0002\u0002ưƱ\u0003\u0002\u0002\u0002ƱƯ\u0003\u0002\u0002\u0002ƱƲ\u0003\u0002\u0002\u0002ƲƳ\u0003\u0002\u0002\u0002Ƴƴ\u0007F\u0002\u0002ƴ\u0019\u0003\u0002\u0002\u0002ƵƷ\u00076\u0002\u0002ƶƸ\t\u0004\u0002\u0002Ʒƶ\u0003\u0002\u0002\u0002ƷƸ\u0003\u0002\u0002\u0002Ƹƹ\u0003\u0002\u0002\u0002ƹƽ\u0007\u0093\u0002\u0002ƺƻ\u0007T\u0002\u0002ƻƼ\u0007j\u0002\u0002Ƽƾ\u0007J\u0002\u0002ƽƺ\u0003\u0002\u0002\u0002ƽƾ\u0003\u0002\u0002\u0002ƾǂ\u0003\u0002\u0002\u0002ƿǀ\u0005\u008aF\u0002ǀǁ\u0007\u0004\u0002\u0002ǁǃ\u0003\u0002\u0002\u0002ǂƿ\u0003\u0002\u0002\u0002ǂǃ\u0003\u0002\u0002\u0002ǃǄ\u0003\u0002\u0002\u0002ǄǍ\u0005\u009eP\u0002ǅǊ\u0005\u0094K\u0002ǆǇ\u0007\u0007\u0002\u0002Ǉǉ\u0005\u0094K\u0002ǈǆ\u0003\u0002\u0002\u0002ǉǌ\u0003\u0002\u0002\u0002Ǌǈ\u0003\u0002\u0002\u0002Ǌǋ\u0003\u0002\u0002\u0002ǋǎ\u0003\u0002\u0002\u0002ǌǊ\u0003\u0002\u0002\u0002Ǎǅ\u0003\u0002\u0002\u0002Ǎǎ\u0003\u0002\u0002\u0002ǎǏ\u0003\u0002\u0002\u0002Ǐǐ\u0007%\u0002\u0002ǐǑ\u0005:\u001e\u0002Ǒ\u001b\u0003\u0002\u0002\u0002ǒǓ\u00076\u0002\u0002Ǔǔ\u0007\u0094\u0002\u0002ǔǘ\u0007\u0086\u0002\u0002Ǖǖ\u0007T\u0002\u0002ǖǗ\u0007j\u0002\u0002ǗǙ\u0007J\u0002\u0002ǘǕ\u0003\u0002\u0002\u0002ǘǙ\u0003\u0002\u0002\u0002Ǚǝ\u0003\u0002\u0002\u0002ǚǛ\u0005\u008aF\u0002Ǜǜ\u0007\u0004\u0002\u0002ǜǞ\u0003\u0002\u0002\u0002ǝǚ\u0003\u0002\u0002\u0002ǝǞ\u0003\u0002\u0002\u0002Ǟǟ\u0003\u0002\u0002\u0002ǟǠ\u0005\u008eH\u0002Ǡǡ\u0007\u0090\u0002\u0002ǡǭ\u0005 Q\u0002Ǣǣ\u0007\u0005\u0002\u0002ǣǨ\u0005~@\u0002Ǥǥ\u0007\u0007\u0002\u0002ǥǧ\u0005~@\u0002ǦǤ\u0003\u0002\u0002\u0002ǧǪ\u0003\u0002\u0002\u0002ǨǦ\u0003\u0002\u0002\u0002Ǩǩ\u0003\u0002\u0002\u0002ǩǫ\u0003\u0002\u0002\u0002ǪǨ\u0003\u0002\u0002\u0002ǫǬ\u0007\u0006\u0002\u0002ǬǮ\u0003\u0002\u0002\u0002ǭǢ\u0003\u0002\u0002\u0002ǭǮ\u0003\u0002\u0002\u0002Ǯ\u001d\u0003\u0002\u0002\u0002ǯǱ\u0005X-\u0002ǰǯ\u0003\u0002\u0002\u0002ǰǱ\u0003\u0002\u0002\u0002Ǳǲ\u0003\u0002\u0002\u0002ǲǳ\u0007?\u0002\u0002ǳǴ\u0007O\u0002\u0002ǴǷ\u0005\\/\u0002ǵǶ\u0007\u0096\u0002\u0002ǶǸ\u0005L'\u0002Ƿǵ\u0003\u0002\u0002\u0002ǷǸ\u0003\u0002\u0002\u0002Ǹ\u001f\u0003\u0002\u0002\u0002ǹǻ\u0005X-\u0002Ǻǹ\u0003\u0002\u0002\u0002Ǻǻ\u0003\u0002\u0002\u0002ǻǼ\u0003\u0002\u0002\u0002Ǽǽ\u0007?\u0002\u0002ǽǾ\u0007O\u0002\u0002Ǿȁ\u0005\\/\u0002ǿȀ\u0007\u0096\u0002\u0002ȀȂ\u0005L'\u0002ȁǿ\u0003\u0002\u0002\u0002ȁȂ\u0003\u0002\u0002\u0002Ȃȇ\u0003\u0002\u0002\u0002ȃȅ\u0005^0\u0002Ȅȃ\u0003\u0002\u0002\u0002Ȅȅ\u0003\u0002\u0002\u0002ȅȆ\u0003\u0002\u0002\u0002ȆȈ\u0005b2\u0002ȇȄ\u0003\u0002\u0002\u0002ȇȈ\u0003\u0002\u0002\u0002Ȉ!\u0003\u0002\u0002\u0002ȉȋ\u0007A\u0002\u0002ȊȌ\u0007;\u0002\u0002ȋȊ\u0003\u0002\u0002\u0002ȋȌ\u0003\u0002\u0002\u0002Ȍȍ\u0003\u0002\u0002\u0002ȍȎ\u0005\u008aF\u0002Ȏ#\u0003\u0002\u0002\u0002ȏȐ\u0007C\u0002\u0002Ȑȓ\u0007X\u0002\u0002ȑȒ\u0007T\u0002\u0002ȒȔ\u0007J\u0002\u0002ȓȑ\u0003\u0002\u0002\u0002ȓȔ\u0003\u0002\u0002\u0002ȔȘ\u0003\u0002\u0002\u0002ȕȖ\u0005\u008aF\u0002Ȗȗ\u0007\u0004\u0002\u0002ȗș\u0003\u0002\u0002\u0002Șȕ\u0003\u0002\u0002\u0002Șș\u0003\u0002\u0002\u0002șȚ\u0003\u0002\u0002\u0002Țț\u0005\u009aN\u0002ț%\u0003\u0002\u0002\u0002Ȝȝ\u0007C\u0002\u0002ȝȠ\u0007\u0086\u0002\u0002Ȟȟ\u0007T\u0002\u0002ȟȡ\u0007J\u0002\u0002ȠȞ\u0003\u0002\u0002\u0002Ƞȡ\u0003\u0002\u0002\u0002ȡȥ\u0003\u0002\u0002\u0002Ȣȣ\u0005\u008aF\u0002ȣȤ\u0007\u0004\u0002\u0002ȤȦ\u0003\u0002\u0002\u0002ȥȢ\u0003\u0002\u0002\u0002ȥȦ\u0003\u0002\u0002\u0002Ȧȧ\u0003\u0002\u0002\u0002ȧȨ\u0005\u008eH\u0002Ȩ'\u0003\u0002\u0002\u0002ȩȪ\u0007C\u0002\u0002Ȫȭ\u0007\u008c\u0002\u0002ȫȬ\u0007T\u0002\u0002ȬȮ\u0007J\u0002\u0002ȭȫ\u0003\u0002\u0002\u0002ȭȮ\u0003\u0002\u0002\u0002ȮȲ\u0003\u0002\u0002\u0002ȯȰ\u0005\u008aF\u0002Ȱȱ\u0007\u0004\u0002\u0002ȱȳ\u0003\u0002\u0002\u0002Ȳȯ\u0003\u0002\u0002\u0002Ȳȳ\u0003\u0002\u0002\u0002ȳȴ\u0003\u0002\u0002\u0002ȴȵ\u0005\u009cO\u0002ȵ)\u0003\u0002\u0002\u0002ȶȷ\u0007C\u0002\u0002ȷȺ\u0007\u0093\u0002\u0002ȸȹ\u0007T\u0002\u0002ȹȻ\u0007J\u0002\u0002Ⱥȸ\u0003\u0002\u0002\u0002ȺȻ\u0003\u0002\u0002\u0002Ȼȿ\u0003\u0002\u0002\u0002ȼȽ\u0005\u008aF\u0002ȽȾ\u0007\u0004\u0002\u0002Ⱦɀ\u0003\u0002\u0002\u0002ȿȼ\u0003\u0002\u0002\u0002ȿɀ\u0003\u0002\u0002\u0002ɀɁ\u0003\u0002\u0002\u0002Ɂɂ\u0005\u009eP\u0002ɂ+\u0003\u0002\u0002\u0002ɃɅ\u0005X-\u0002ɄɃ\u0003\u0002\u0002\u0002ɄɅ\u0003\u0002\u0002\u0002Ʌɗ\u0003\u0002\u0002\u0002Ɇɘ\u0007\\\u0002\u0002ɇɘ\u0007~\u0002\u0002Ɉɉ\u0007\\\u0002\u0002ɉɊ\u0007p\u0002\u0002Ɋɘ\u0007~\u0002\u0002ɋɌ\u0007\\\u0002\u0002Ɍɍ\u0007p\u0002\u0002ɍɘ\u0007\u0081\u0002\u0002Ɏɏ\u0007\\\u0002\u0002ɏɐ\u0007p\u0002\u0002ɐɘ\u0007\u001d\u0002\u0002ɑɒ\u0007\\\u0002\u0002ɒɓ\u0007p\u0002\u0002ɓɘ\u0007L\u0002\u0002ɔɕ\u0007\\\u0002\u0002ɕɖ\u0007p\u0002\u0002ɖɘ\u0007U\u0002\u0002ɗɆ\u0003\u0002\u0002\u0002ɗɇ\u0003\u0002\u0002\u0002ɗɈ\u0003\u0002\u0002\u0002ɗɋ\u0003\u0002\u0002\u0002ɗɎ\u0003\u0002\u0002\u0002ɗɑ\u0003\u0002\u0002\u0002ɗɔ\u0003\u0002\u0002\u0002ɘə\u0003\u0002\u0002\u0002əɝ\u0007_\u0002\u0002ɚɛ\u0005\u008aF\u0002ɛɜ\u0007\u0004\u0002\u0002ɜɞ\u0003\u0002\u0002\u0002ɝɚ\u0003\u0002\u0002\u0002ɝɞ\u0003\u0002\u0002\u0002ɞɟ\u0003\u0002\u0002\u0002ɟɢ\u0005\u008eH\u0002ɠɡ\u0007%\u0002\u0002ɡɣ\u0005¦T\u0002ɢɠ\u0003\u0002\u0002\u0002ɢɣ\u0003\u0002\u0002\u0002ɣɯ\u0003\u0002\u0002\u0002ɤɥ\u0007\u0005\u0002\u0002ɥɪ\u0005\u0094K\u0002ɦɧ\u0007\u0007\u0002\u0002ɧɩ\u0005\u0094K\u0002ɨɦ\u0003\u0002\u0002\u0002ɩɬ\u0003\u0002\u0002\u0002ɪɨ\u0003\u0002\u0002\u0002ɪɫ\u0003\u0002\u0002\u0002ɫɭ\u0003\u0002\u0002\u0002ɬɪ\u0003\u0002\u0002\u0002ɭɮ\u0007\u0006\u0002\u0002ɮɰ\u0003\u0002\u0002\u0002ɯɤ\u0003\u0002\u0002\u0002ɯɰ\u0003\u0002\u0002\u0002ɰʂ\u0003\u0002\u0002\u0002ɱɲ\u0007\u0092\u0002\u0002ɲɳ\u0007\u0005\u0002\u0002ɳɴ\u0005N(\u0002ɴɼ\u0007\u0006\u0002\u0002ɵɶ\u0007\u0007\u0002\u0002ɶɷ\u0007\u0005\u0002\u0002ɷɸ\u0005N(\u0002ɸɹ\u0007\u0006\u0002\u0002ɹɻ\u0003\u0002\u0002\u0002ɺɵ\u0003\u0002\u0002\u0002ɻɾ\u0003\u0002\u0002\u0002ɼɺ\u0003\u0002\u0002\u0002ɼɽ\u0003\u0002\u0002\u0002ɽʃ\u0003\u0002\u0002\u0002ɾɼ\u0003\u0002\u0002\u0002ɿʃ\u0005:\u001e\u0002ʀʁ\u0007<\u0002\u0002ʁʃ\u0007\u0092\u0002\u0002ʂɱ\u0003\u0002\u0002\u0002ʂɿ\u0003\u0002\u0002\u0002ʂʀ\u0003\u0002\u0002\u0002ʃʅ\u0003\u0002\u0002\u0002ʄʆ\u0005.\u0018\u0002ʅʄ\u0003\u0002\u0002\u0002ʅʆ\u0003\u0002\u0002\u0002ʆ-\u0003\u0002\u0002\u0002ʇʈ\u0007o\u0002\u0002ʈʗ\u00074\u0002\u0002ʉʊ\u0007\u0005\u0002\u0002ʊʏ\u0005T+\u0002ʋʌ\u0007\u0007\u0002\u0002ʌʎ\u0005T+\u0002ʍʋ\u0003\u0002\u0002\u0002ʎʑ\u0003\u0002\u0002\u0002ʏʍ\u0003\u0002\u0002\u0002ʏʐ\u0003\u0002\u0002\u0002ʐʒ\u0003\u0002\u0002\u0002ʑʏ\u0003\u0002\u0002\u0002ʒʕ\u0007\u0006\u0002\u0002ʓʔ\u0007\u0096\u0002\u0002ʔʖ\u0005L'\u0002ʕʓ\u0003\u0002\u0002\u0002ʕʖ\u0003\u0002\u0002\u0002ʖʘ\u0003\u0002\u0002\u0002ʗʉ\u0003\u0002\u0002\u0002ʗʘ\u0003\u0002\u0002\u0002ʘʳ\u0003\u0002\u0002\u0002ʙʴ\u0007\u009a\u0002\u0002ʚʛ\u0007\u009b\u0002\u0002ʛʞ\u0007\u0085\u0002\u0002ʜʟ\u0005\u0094K\u0002ʝʟ\u0005\u0082B\u0002ʞʜ\u0003\u0002\u0002\u0002ʞʝ\u0003\u0002\u0002\u0002ʟʠ\u0003\u0002\u0002\u0002ʠʡ\u0007\b\u0002\u0002ʡʬ\u0005L'\u0002ʢʥ\u0007\u0007\u0002\u0002ʣʦ\u0005\u0094K\u0002ʤʦ\u0005\u0082B\u0002ʥʣ\u0003\u0002\u0002\u0002ʥʤ\u0003\u0002\u0002\u0002ʦʧ\u0003\u0002\u0002\u0002ʧʨ\u0007\b\u0002\u0002ʨʩ\u0005L'\u0002ʩʫ\u0003\u0002\u0002\u0002ʪʢ\u0003\u0002\u0002\u0002ʫʮ\u0003\u0002\u0002\u0002ʬʪ\u0003\u0002\u0002\u0002ʬʭ\u0003\u0002\u0002\u0002ʭʱ\u0003\u0002\u0002\u0002ʮʬ\u0003\u0002\u0002\u0002ʯʰ\u0007\u0096\u0002\u0002ʰʲ\u0005L'\u0002ʱʯ\u0003\u0002\u0002\u0002ʱʲ\u0003\u0002\u0002\u0002ʲʴ\u0003\u0002\u0002\u0002ʳʙ\u0003\u0002\u0002\u0002ʳʚ\u0003\u0002\u0002\u0002ʴ/\u0003\u0002\u0002\u0002ʵʹ\u0007t\u0002\u0002ʶʷ\u0005\u008aF\u0002ʷʸ\u0007\u0004\u0002\u0002ʸʺ\u0003\u0002\u0002\u0002ʹʶ\u0003\u0002\u0002\u0002ʹʺ\u0003\u0002\u0002\u0002ʺʻ\u0003\u0002\u0002\u0002ʻ˂\u0005¢R\u0002ʼʽ\u0007\b\u0002\u0002ʽ˃\u0005d3\u0002ʾʿ\u0007\u0005\u0002\u0002ʿˀ\u0005d3\u0002ˀˁ\u0007\u0006\u0002\u0002ˁ˃\u0003\u0002\u0002\u0002˂ʼ\u0003\u0002\u0002\u0002˂ʾ\u0003\u0002\u0002\u0002˂˃\u0003\u0002\u0002\u0002˃1\u0003\u0002\u0002\u0002˄ˏ\u0007{\u0002\u0002˅ː\u0005\u0096L\u0002ˆˇ\u0005\u008aF\u0002ˇˈ\u0007\u0004\u0002\u0002ˈˊ\u0003\u0002\u0002\u0002ˉˆ\u0003\u0002\u0002\u0002ˉˊ\u0003\u0002\u0002\u0002ˊˍ\u0003\u0002\u0002\u0002ˋˎ\u0005\u008eH\u0002ˌˎ\u0005\u009aN\u0002ˍˋ\u0003\u0002\u0002\u0002ˍˌ\u0003\u0002\u0002\u0002ˎː\u0003\u0002\u0002\u0002ˏ˅\u0003\u0002\u0002\u0002ˏˉ\u0003\u0002\u0002\u0002ˏː\u0003\u0002\u0002\u0002ː3\u0003\u0002\u0002\u0002ˑ˓\u0007|\u0002\u0002˒˔\u0007\u0083\u0002\u0002˓˒\u0003\u0002\u0002\u0002˓˔\u0003\u0002\u0002\u0002˔˕\u0003\u0002\u0002\u0002˕˖\u0005¤S\u0002˖5\u0003\u0002\u0002\u0002˗˜\u0007\u0081\u0002\u0002˘˚\u0007\u008b\u0002\u0002˙˛\u0005¨U\u0002˚˙\u0003\u0002\u0002\u0002˚˛\u0003\u0002\u0002\u0002˛˝\u0003\u0002\u0002\u0002˜˘\u0003\u0002\u0002\u0002˜˝\u0003\u0002\u0002\u0002˝ˣ\u0003\u0002\u0002\u0002˞ˠ\u0007\u008a\u0002\u0002˟ˡ\u0007\u0083\u0002\u0002ˠ˟\u0003\u0002\u0002\u0002ˠˡ\u0003\u0002\u0002\u0002ˡˢ\u0003\u0002\u0002\u0002ˢˤ\u0005¤S\u0002ˣ˞\u0003\u0002\u0002\u0002ˣˤ\u0003\u0002\u0002\u0002ˤ7\u0003\u0002\u0002\u0002˥˦\u0007\u0083\u0002\u0002˦˧\u0005¤S\u0002˧9\u0003\u0002\u0002\u0002˨˪\u0005X-\u0002˩˨\u0003\u0002\u0002\u0002˩˪\u0003\u0002\u0002\u0002˪˫\u0003\u0002\u0002\u0002˫˱\u0005<\u001f\u0002ˬ˭\u0005p9\u0002˭ˮ\u0005<\u001f\u0002ˮ˰\u0003\u0002\u0002\u0002˯ˬ\u0003\u0002\u0002\u0002˰˳\u0003\u0002\u0002\u0002˱˯\u0003\u0002\u0002\u0002˱˲\u0003\u0002\u0002\u0002˲˵\u0003\u0002\u0002\u0002˳˱\u0003\u0002\u0002\u0002˴˶\u0005^0\u0002˵˴\u0003\u0002\u0002\u0002˵˶\u0003\u0002\u0002\u0002˶˸\u0003\u0002\u0002\u0002˷˹\u0005b2\u0002˸˷\u0003\u0002\u0002\u0002˸˹\u0003\u0002\u0002\u0002˹;\u0003\u0002\u0002\u0002˺˼\u0007\u0084\u0002\u0002˻˽\t\u0005\u0002\u0002˼˻\u0003\u0002\u0002\u0002˼˽\u0003\u0002\u0002\u0002˽˾\u0003\u0002\u0002\u0002˾̃\u0005f4\u0002˿̀\u0007\u0007\u0002\u0002̀̂\u0005f4\u0002́˿\u0003\u0002\u0002\u0002̂̅\u0003\u0002\u0002\u0002̃́\u0003\u0002\u0002\u0002̃̄\u0003\u0002\u0002\u0002̄̒\u0003\u0002\u0002\u0002̅̃\u0003\u0002\u0002\u0002̆̐\u0007O\u0002\u0002̇̌\u0005h5\u0002̈̉\u0007\u0007\u0002\u0002̉̋\u0005h5\u0002̊̈\u0003\u0002\u0002\u0002̋̎\u0003\u0002\u0002\u0002̌̊\u0003\u0002\u0002\u0002̌̍\u0003\u0002\u0002\u0002̍̑\u0003\u0002\u0002\u0002̎̌\u0003\u0002\u0002\u0002̏̑\u0005j6\u0002̐̇\u0003\u0002\u0002\u0002̐̏\u0003\u0002\u0002\u0002̑̓\u0003\u0002\u0002\u0002̒̆\u0003\u0002\u0002\u0002̒̓\u0003\u0002\u0002\u0002̖̓\u0003\u0002\u0002\u0002̔̕\u0007\u0096\u0002\u0002̗̕\u0005L'\u0002̖̔\u0003\u0002\u0002\u0002̖̗\u0003\u0002\u0002\u0002̗̟\u0003\u0002\u0002\u0002̘̙\u0007R\u0002\u0002̙̚\u0007,\u0002\u0002̝̚\u0005N(\u0002̛̜\u0007S\u0002\u0002̜̞\u0005L'\u0002̛̝\u0003\u0002\u0002\u0002̝̞\u0003\u0002\u0002\u0002̞̠\u0003\u0002\u0002\u0002̟̘\u0003\u0002\u0002\u0002̟̠\u0003\u0002\u0002\u0002̠̰\u0003\u0002\u0002\u0002̡̢\u0007\u0092\u0002\u0002̢̣\u0007\u0005\u0002\u0002̣̤\u0005N(\u0002̤̬\u0007\u0006\u0002\u0002̥̦\u0007\u0007\u0002\u0002̧̦\u0007\u0005\u0002\u0002̧̨\u0005N(\u0002̨̩\u0007\u0006\u0002\u0002̩̫\u0003\u0002\u0002\u0002̪̥\u0003\u0002\u0002\u0002̫̮\u0003\u0002\u0002\u0002̬̪\u0003\u0002\u0002\u0002̬̭\u0003\u0002\u0002\u0002̭̰\u0003\u0002\u0002\u0002̮̬\u0003\u0002\u0002\u0002̯˺\u0003\u0002\u0002\u0002̡̯\u0003\u0002\u0002\u0002̰=\u0003\u0002\u0002\u0002̱̳\u0005X-\u0002̲̱\u0003\u0002\u0002\u0002̲̳\u0003\u0002\u0002\u0002̴̳\u0003\u0002\u0002\u0002̴̿\u0007\u008f\u0002\u0002̵̶\u0007p\u0002\u0002̶̀\u0007\u0081\u0002\u0002̷̸\u0007p\u0002\u0002̸̀\u0007\u001d\u0002\u0002̹̺\u0007p\u0002\u0002̺̀\u0007~\u0002\u0002̻̼\u0007p\u0002\u0002̼̀\u0007L\u0002\u0002̽̾\u0007p\u0002\u0002̾̀\u0007U\u0002\u0002̵̿\u0003\u0002\u0002\u0002̷̿\u0003\u0002\u0002\u0002̹̿\u0003\u0002\u0002\u0002̻̿\u0003\u0002\u0002\u0002̿̽\u0003\u0002\u0002\u0002̿̀\u0003\u0002\u0002\u0002̀́\u0003\u0002\u0002\u0002́͂\u0005\\/\u0002͂ͅ\u0007\u0085\u0002\u0002̓͆\u0005\u0094K\u0002̈́͆\u0005\u0082B\u0002̓ͅ\u0003\u0002\u0002\u0002̈́ͅ\u0003\u0002\u0002\u0002͇͆\u0003\u0002\u0002\u0002͇͈\u0007\b\u0002\u0002͈͓\u0005L'\u0002͉͌\u0007\u0007\u0002\u0002͍͊\u0005\u0094K\u0002͍͋\u0005\u0082B\u0002͌͊\u0003\u0002\u0002\u0002͌͋\u0003\u0002\u0002\u0002͍͎\u0003\u0002\u0002\u0002͎͏\u0007\b\u0002\u0002͏͐\u0005L'\u0002͐͒\u0003\u0002\u0002\u0002͉͑\u0003\u0002\u0002\u0002͕͒\u0003\u0002\u0002\u0002͓͑\u0003\u0002\u0002\u0002͓͔\u0003\u0002\u0002\u0002͔͘\u0003\u0002\u0002\u0002͕͓\u0003\u0002\u0002\u0002͖͗\u0007\u0096\u0002\u0002͙͗\u0005L'\u0002͖͘\u0003\u0002\u0002\u0002͙͘\u0003\u0002\u0002\u0002͙?\u0003\u0002\u0002\u0002͚͜\u0005X-\u0002͚͛\u0003\u0002\u0002\u0002͛͜\u0003\u0002\u0002\u0002͜͝\u0003\u0002\u0002\u0002ͨ͝\u0007\u008f\u0002\u0002͟͞\u0007p\u0002\u0002ͩ͟\u0007\u0081\u0002\u0002͠͡\u0007p\u0002\u0002ͩ͡\u0007\u001d\u0002\u0002ͣ͢\u0007p\u0002\u0002ͣͩ\u0007~\u0002\u0002ͤͥ\u0007p\u0002\u0002ͥͩ\u0007L\u0002\u0002ͦͧ\u0007p\u0002\u0002ͧͩ\u0007U\u0002\u0002ͨ͞\u0003\u0002\u0002\u0002ͨ͠\u0003\u0002\u0002\u0002ͨ͢\u0003\u0002\u0002\u0002ͨͤ\u0003\u0002\u0002\u0002ͨͦ\u0003\u0002\u0002\u0002ͨͩ\u0003\u0002\u0002\u0002ͩͪ\u0003\u0002\u0002\u0002ͪͫ\u0005\\/\u0002ͫͮ\u0007\u0085\u0002\u0002ͬͯ\u0005\u0094K\u0002ͭͯ\u0005\u0082B\u0002ͮͬ\u0003\u0002\u0002\u0002ͮͭ\u0003\u0002\u0002\u0002ͯͰ\u0003\u0002\u0002\u0002Ͱͱ\u0007\b\u0002\u0002ͱͼ\u0005L'\u0002Ͳ͵\u0007\u0007\u0002\u0002ͳͶ\u0005\u0094K\u0002ʹͶ\u0005\u0082B\u0002͵ͳ\u0003\u0002\u0002\u0002͵ʹ\u0003\u0002\u0002\u0002Ͷͷ\u0003\u0002\u0002\u0002ͷ\u0378\u0007\b\u0002\u0002\u0378\u0379\u0005L'\u0002\u0379ͻ\u0003\u0002\u0002\u0002ͺͲ\u0003\u0002\u0002\u0002ͻ;\u0003\u0002\u0002\u0002ͼͺ\u0003\u0002\u0002\u0002ͼͽ\u0003\u0002\u0002\u0002ͽ\u0381\u0003\u0002\u0002\u0002;ͼ\u0003\u0002\u0002\u0002Ϳ\u0380\u0007\u0096\u0002\u0002\u0380\u0382\u0005L'\u0002\u0381Ϳ\u0003\u0002\u0002\u0002\u0381\u0382\u0003\u0002\u0002\u0002\u0382·\u0003\u0002\u0002\u0002\u0383΅\u0005^0\u0002΄\u0383\u0003\u0002\u0002\u0002΄΅\u0003\u0002\u0002\u0002΅Ά\u0003\u0002\u0002\u0002ΆΈ\u0005b2\u0002·΄\u0003\u0002\u0002\u0002·Έ\u0003\u0002\u0002\u0002ΈA\u0003\u0002\u0002\u0002Ή\u038b\u0007\u0091\u0002\u0002ΊΌ\u0005\u008aF\u0002\u038bΊ\u0003\u0002\u0002\u0002\u038bΌ\u0003\u0002\u0002\u0002ΌC\u0003\u0002\u0002\u0002\u038dΏ\u0005\u0094K\u0002Ύΐ\u0005F$\u0002ΏΎ\u0003\u0002\u0002\u0002Ώΐ\u0003\u0002\u0002\u0002ΐΔ\u0003\u0002\u0002\u0002ΑΓ\u0005H%\u0002ΒΑ\u0003\u0002\u0002\u0002ΓΖ\u0003\u0002\u0002\u0002ΔΒ\u0003\u0002\u0002\u0002ΔΕ\u0003\u0002\u0002\u0002ΕE\u0003\u0002\u0002\u0002ΖΔ\u0003\u0002\u0002\u0002ΗΙ\u0005\u0086D\u0002ΘΗ\u0003\u0002\u0002\u0002ΙΚ\u0003\u0002\u0002\u0002ΚΛ\u0003\u0002\u0002\u0002ΚΘ\u0003\u0002\u0002\u0002ΛΦ\u0003\u0002\u0002\u0002ΜΝ\u0007\u0005\u0002\u0002ΝΞ\u0005r:\u0002ΞΟ\u0007\u0006\u0002\u0002ΟΧ\u0003\u0002\u0002\u0002ΠΡ\u0007\u0005\u0002\u0002Ρ\u03a2\u0005r:\u0002\u03a2Σ\u0007\u0007\u0002\u0002ΣΤ\u0005r:\u0002ΤΥ\u0007\u0006\u0002\u0002ΥΧ\u0003\u0002\u0002\u0002ΦΜ\u0003\u0002\u0002\u0002ΦΠ\u0003\u0002\u0002\u0002ΦΧ\u0003\u0002\u0002\u0002ΧG\u0003\u0002\u0002\u0002ΨΩ\u00075\u0002\u0002ΩΫ\u0005\u0086D\u0002ΪΨ\u0003\u0002\u0002\u0002ΪΫ\u0003\u0002\u0002\u0002Ϋύ\u0003\u0002\u0002\u0002άέ\u0007u\u0002\u0002έί\u0007c\u0002\u0002ήΰ\t\u0006\u0002\u0002ίή\u0003\u0002\u0002\u0002ίΰ\u0003\u0002\u0002\u0002ΰα\u0003\u0002\u0002\u0002αγ\u0005J&\u0002βδ\u0007(\u0002\u0002γβ\u0003\u0002\u0002\u0002γδ\u0003\u0002\u0002\u0002δώ\u0003\u0002\u0002\u0002εη\u0007j\u0002\u0002ζε\u0003\u0002\u0002\u0002ζη\u0003\u0002\u0002\u0002ηθ\u0003\u0002\u0002\u0002θι\u0007l\u0002\u0002ιώ\u0005J&\u0002κλ\u0007\u008e\u0002\u0002λώ\u0005J&\u0002μν\u00070\u0002\u0002νξ\u0007\u0005\u0002\u0002ξο\u0005L'\u0002οπ\u0007\u0006\u0002\u0002πώ\u0003\u0002\u0002\u0002ρψ\u0007<\u0002\u0002ςω\u0005r:\u0002σω\u0005t;\u0002τυ\u0007\u0005\u0002\u0002υφ\u0005L'\u0002φχ\u0007\u0006\u0002\u0002χω\u0003\u0002\u0002\u0002ψς\u0003\u0002\u0002\u0002ψσ\u0003\u0002\u0002\u0002ψτ\u0003\u0002\u0002\u0002ωώ\u0003\u0002\u0002\u0002ϊϋ\u00071\u0002\u0002ϋώ\u0005\u0096L\u0002όώ\u0005P)\u0002ύά\u0003\u0002\u0002\u0002ύζ\u0003\u0002\u0002\u0002ύκ\u0003\u0002\u0002\u0002ύμ\u0003\u0002\u0002\u0002ύρ\u0003\u0002\u0002\u0002ύϊ\u0003\u0002\u0002\u0002ύό\u0003\u0002\u0002\u0002ώI\u0003\u0002\u0002\u0002Ϗϐ\u0007o\u0002\u0002ϐϑ\u00074\u0002\u0002ϑϓ\t\u0007\u0002\u0002ϒϏ\u0003\u0002\u0002\u0002ϒϓ\u0003\u0002\u0002\u0002ϓK\u0003\u0002\u0002\u0002ϔϕ\b'\u0001\u0002ϕК\u0005t;\u0002ϖК\u0007\u009e\u0002\u0002ϗϘ\u0005\u008aF\u0002Ϙϙ\u0007\u0004\u0002\u0002ϙϛ\u0003\u0002\u0002\u0002Ϛϗ\u0003\u0002\u0002\u0002Ϛϛ\u0003\u0002\u0002\u0002ϛϜ\u0003\u0002\u0002\u0002Ϝϝ\u0005\u008eH\u0002ϝϞ\u0007\u0004\u0002\u0002ϞϠ\u0003\u0002\u0002\u0002ϟϚ\u0003\u0002\u0002\u0002ϟϠ\u0003\u0002\u0002\u0002Ϡϡ\u0003\u0002\u0002\u0002ϡК\u0005\u0094K\u0002Ϣϣ\u0005x=\u0002ϣϤ\u0005L'\u0010ϤК\u0003\u0002\u0002\u0002ϥϦ\u0005\u0088E\u0002ϦϬ\u0007\u0005\u0002\u0002ϧϩ\u0007B\u0002\u0002Ϩϧ\u0003\u0002\u0002\u0002Ϩϩ\u0003\u0002\u0002\u0002ϩϪ\u0003\u0002\u0002\u0002Ϫϭ\u0005N(\u0002ϫϭ\u0007\t\u0002\u0002ϬϨ\u0003\u0002\u0002\u0002Ϭϫ\u0003\u0002\u0002\u0002Ϭϭ\u0003\u0002\u0002\u0002ϭϮ\u0003\u0002\u0002\u0002Ϯϯ\u0007\u0006\u0002\u0002ϯК\u0003\u0002\u0002\u0002ϰϱ\u0007\u0005\u0002\u0002ϱϲ\u0005N(\u0002ϲϳ\u0007\u0006\u0002\u0002ϳК\u0003\u0002\u0002\u0002ϴϵ\u0007/\u0002\u0002ϵ϶\u0007\u0005\u0002\u0002϶Ϸ\u0005L'\u0002Ϸϸ\u0007%\u0002\u0002ϸϹ\u0005F$\u0002ϹϺ\u0007\u0006\u0002\u0002ϺК\u0003\u0002\u0002\u0002ϻϽ\u0007j\u0002\u0002ϼϻ\u0003\u0002\u0002\u0002ϼϽ\u0003\u0002\u0002\u0002ϽϾ\u0003\u0002\u0002\u0002ϾЀ\u0007J\u0002\u0002Ͽϼ\u0003\u0002\u0002\u0002ϿЀ\u0003\u0002\u0002\u0002ЀЁ\u0003\u0002\u0002\u0002ЁЂ\u0007\u0005\u0002\u0002ЂЃ\u0005:\u001e\u0002ЃЄ\u0007\u0006\u0002\u0002ЄК\u0003\u0002\u0002\u0002ЅЇ\u0007.\u0002\u0002ІЈ\u0005L'\u0002ЇІ\u0003\u0002\u0002\u0002ЇЈ\u0003\u0002\u0002\u0002ЈЎ\u0003\u0002\u0002\u0002ЉЊ\u0007\u0095\u0002\u0002ЊЋ\u0005L'\u0002ЋЌ\u0007\u0089\u0002\u0002ЌЍ\u0005L'\u0002ЍЏ\u0003\u0002\u0002\u0002ЎЉ\u0003\u0002\u0002\u0002ЏА\u0003\u0002\u0002\u0002АЎ\u0003\u0002\u0002\u0002АБ\u0003\u0002\u0002\u0002БД\u0003\u0002\u0002\u0002ВГ\u0007E\u0002\u0002ГЕ\u0005L'\u0002ДВ\u0003\u0002\u0002\u0002ДЕ\u0003\u0002\u0002\u0002ЕЖ\u0003\u0002\u0002\u0002ЖЗ\u0007F\u0002\u0002ЗК\u0003\u0002\u0002\u0002ИК\u0005R*\u0002Йϔ\u0003\u0002\u0002\u0002Йϖ\u0003\u0002\u0002\u0002Йϟ\u0003\u0002\u0002\u0002ЙϢ\u0003\u0002\u0002\u0002Йϥ\u0003\u0002\u0002\u0002Йϰ\u0003\u0002\u0002\u0002Йϴ\u0003\u0002\u0002\u0002ЙϿ\u0003\u0002\u0002\u0002ЙЅ\u0003\u0002\u0002\u0002ЙИ\u0003\u0002\u0002\u0002Кѣ\u0003\u0002\u0002\u0002ЛМ\f\u000f\u0002\u0002МН\u0005z>\u0002НО\u0005L'\u0010ОѢ\u0003\u0002\u0002\u0002ПР\f\b\u0002\u0002РТ\u0007`\u0002\u0002СУ\u0007j\u0002\u0002ТС\u0003\u0002\u0002\u0002ТУ\u0003\u0002\u0002\u0002УФ\u0003\u0002\u0002\u0002ФѢ\u0005L'\tХЧ\f\u0007\u0002\u0002ЦШ\u0007j\u0002\u0002ЧЦ\u0003\u0002\u0002\u0002ЧШ\u0003\u0002\u0002\u0002ШЩ\u0003\u0002\u0002\u0002ЩЪ\u0007+\u0002\u0002ЪЫ\u0005L'\u0002ЫЬ\u0007$\u0002\u0002ЬЭ\u0005L'\bЭѢ\u0003\u0002\u0002\u0002ЮЯ\f\u000b\u0002\u0002Яа\u00071\u0002\u0002аѢ\u0005\u0096L\u0002бг\f\n\u0002\u0002вд\u0007j\u0002\u0002гв\u0003\u0002\u0002\u0002гд\u0003\u0002\u0002\u0002де\u0003\u0002\u0002\u0002еж\t\b\u0002\u0002жй\u0005L'\u0002зи\u0007G\u0002\u0002ик\u0005L'\u0002йз\u0003\u0002\u0002\u0002йк\u0003\u0002\u0002\u0002кѢ\u0003\u0002\u0002\u0002лр\f\t\u0002\u0002мс\u0007a\u0002\u0002нс\u0007k\u0002\u0002оп\u0007j\u0002\u0002пс\u0007l\u0002\u0002рм\u0003\u0002\u0002\u0002рн\u0003\u0002\u0002\u0002ро\u0003\u0002\u0002\u0002сѢ\u0003\u0002\u0002\u0002тф\f\u0006\u0002\u0002ух\u0007j\u0002\u0002фу\u0003\u0002\u0002\u0002фх\u0003\u0002\u0002\u0002хц\u0003\u0002\u0002\u0002цџ\u0007W\u0002\u0002чъ\u0007\u0005\u0002\u0002шы\u0005:\u001e\u0002щы\u0005N(\u0002ъш\u0003\u0002\u0002\u0002ъщ\u0003\u0002\u0002\u0002ъы\u0003\u0002\u0002\u0002ыь\u0003\u0002\u0002\u0002ьѠ\u0007\u0006\u0002\u0002эю\u0005\u008aF\u0002юя\u0007\u0004\u0002\u0002яё\u0003\u0002\u0002\u0002ѐэ\u0003\u0002\u0002\u0002ѐё\u0003\u0002\u0002\u0002ёђ\u0003\u0002\u0002\u0002ђѠ\u0005\u008eH\u0002ѓє\u0005\u008aF\u0002єѕ\u0007\u0004\u0002\u0002ѕї\u0003\u0002\u0002\u0002іѓ\u0003\u0002\u0002\u0002ії\u0003\u0002\u0002\u0002їј\u0003\u0002\u0002\u0002јљ\u0005\u008cG\u0002љћ\u0007\u0005\u0002\u0002њќ\u0005N(\u0002ћњ\u0003\u0002\u0002\u0002ћќ\u0003\u0002\u0002\u0002ќѝ\u0003\u0002\u0002\u0002ѝў\u0007\u0006\u0002\u0002ўѠ\u0003\u0002\u0002\u0002џч\u0003\u0002\u0002\u0002џѐ\u0003\u0002\u0002\u0002џі\u0003\u0002\u0002\u0002ѠѢ\u0003\u0002\u0002\u0002ѡЛ\u0003\u0002\u0002\u0002ѡП\u0003\u0002\u0002\u0002ѡХ\u0003\u0002\u0002\u0002ѡЮ\u0003\u0002\u0002\u0002ѡб\u0003\u0002\u0002\u0002ѡл\u0003\u0002\u0002\u0002ѡт\u0003\u0002\u0002\u0002Ѣѥ\u0003\u0002\u0002\u0002ѣѡ\u0003\u0002\u0002\u0002ѣѤ\u0003\u0002\u0002\u0002ѤM\u0003\u0002\u0002\u0002ѥѣ\u0003\u0002\u0002\u0002Ѧѫ\u0005L'\u0002ѧѨ\u0007\u0007\u0002\u0002ѨѪ\u0005L'\u0002ѩѧ\u0003\u0002\u0002\u0002Ѫѭ\u0003\u0002\u0002\u0002ѫѩ\u0003\u0002\u0002\u0002ѫѬ\u0003\u0002\u0002\u0002ѬO\u0003\u0002\u0002\u0002ѭѫ\u0003\u0002\u0002\u0002Ѯѯ\u0007y\u0002\u0002ѯѻ\u0005\u0098M\u0002Ѱѱ\u0007\u0005\u0002\u0002ѱѶ\u0005\u0094K\u0002Ѳѳ\u0007\u0007\u0002\u0002ѳѵ\u0005\u0094K\u0002ѴѲ\u0003\u0002\u0002\u0002ѵѸ\u0003\u0002\u0002\u0002ѶѴ\u0003\u0002\u0002\u0002Ѷѷ\u0003\u0002\u0002\u0002ѷѹ\u0003\u0002\u0002\u0002ѸѶ\u0003\u0002\u0002\u0002ѹѺ\u0007\u0006\u0002\u0002ѺѼ\u0003\u0002\u0002\u0002ѻѰ\u0003\u0002\u0002\u0002ѻѼ\u0003\u0002\u0002\u0002Ѽҏ\u0003\u0002\u0002\u0002ѽѾ\u0007o\u0002\u0002Ѿ҇\t\t\u0002\u0002ѿҀ\u0007\u0085\u0002\u0002Ҁ҈\u0007l\u0002\u0002ҁ҂\u0007\u0085\u0002\u0002҂҈\u0007<\u0002\u0002҃҈\u0007-\u0002\u0002҄҈\u0007\u007f\u0002\u0002҅҆\u0007i\u0002\u0002҆҈\u0007\u001e\u0002\u0002҇ѿ\u0003\u0002\u0002\u0002҇ҁ\u0003\u0002\u0002\u0002҇҃\u0003\u0002\u0002\u0002҇҄\u0003\u0002\u0002\u0002҇҅\u0003\u0002\u0002\u0002҈Ҍ\u0003\u0002\u0002\u0002҉Ҋ\u0007g\u0002\u0002ҊҌ\u0005\u0086D\u0002ҋѽ\u0003\u0002\u0002\u0002ҋ҉\u0003\u0002\u0002\u0002ҌҎ\u0003\u0002\u0002\u0002ҍҋ\u0003\u0002\u0002\u0002Ҏґ\u0003\u0002\u0002\u0002ҏҍ\u0003\u0002\u0002\u0002ҏҐ\u0003\u0002\u0002\u0002ҐҜ\u0003\u0002\u0002\u0002ґҏ\u0003\u0002\u0002\u0002ҒҔ\u0007j\u0002\u0002ғҒ\u0003\u0002\u0002\u0002ғҔ\u0003\u0002\u0002\u0002Ҕҕ\u0003\u0002\u0002\u0002ҕҚ\u0007=\u0002\u0002Җҗ\u0007Z\u0002\u0002җқ\u0007>\u0002\u0002Ҙҙ\u0007Z\u0002\u0002ҙқ\u0007V\u0002\u0002ҚҖ\u0003\u0002\u0002\u0002ҚҘ\u0003\u0002\u0002\u0002Ққ\u0003\u0002\u0002\u0002қҝ\u0003\u0002\u0002\u0002Ҝғ\u0003\u0002\u0002\u0002Ҝҝ\u0003\u0002\u0002\u0002ҝQ\u0003\u0002\u0002\u0002Ҟҟ\u0007w\u0002\u0002ҟҤ\u0007\u0005\u0002\u0002Ҡҥ\u0007U\u0002\u0002ҡҢ\t\n\u0002\u0002Ңң\u0007\u0007\u0002\u0002ңҥ\u0005|?\u0002ҤҠ\u0003\u0002\u0002\u0002Ҥҡ\u0003\u0002\u0002\u0002ҥҦ\u0003\u0002\u0002\u0002Ҧҧ\u0007\u0006\u0002\u0002ҧS\u0003\u0002\u0002\u0002Ҩҫ\u0005\u0094K\u0002ҩҫ\u0005L'\u0002ҪҨ\u0003\u0002\u0002\u0002Ҫҩ\u0003\u0002\u0002\u0002ҫҮ\u0003\u0002\u0002\u0002Ҭҭ\u00071\u0002\u0002ҭү\u0005\u0096L\u0002ҮҬ\u0003\u0002\u0002\u0002Үү\u0003\u0002\u0002\u0002үұ\u0003\u0002\u0002\u0002ҰҲ\t\u0006\u0002\u0002ұҰ\u0003\u0002\u0002\u0002ұҲ\u0003\u0002\u0002\u0002ҲU\u0003\u0002\u0002\u0002ҳҴ\u00075\u0002\u0002ҴҶ\u0005\u0086D\u0002ҵҳ\u0003\u0002\u0002\u0002ҵҶ\u0003\u0002\u0002\u0002Ҷӛ\u0003\u0002\u0002\u0002ҷҸ\u0007u\u0002\u0002Ҹһ\u0007c\u0002\u0002ҹһ\u0007\u008e\u0002\u0002Һҷ\u0003\u0002\u0002\u0002Һҹ\u0003\u0002\u0002\u0002һҼ\u0003\u0002\u0002\u0002Ҽҽ\u0007\u0005\u0002\u0002ҽӂ\u0005T+\u0002Ҿҿ\u0007\u0007\u0002\u0002ҿӁ\u0005T+\u0002ӀҾ\u0003\u0002\u0002\u0002Ӂӄ\u0003\u0002\u0002\u0002ӂӀ\u0003\u0002\u0002\u0002ӂӃ\u0003\u0002\u0002\u0002ӃӅ\u0003\u0002\u0002\u0002ӄӂ\u0003\u0002\u0002\u0002Ӆӆ\u0007\u0006\u0002\u0002ӆӇ\u0005J&\u0002ӇӜ\u0003\u0002\u0002\u0002ӈӉ\u00070\u0002\u0002Ӊӊ\u0007\u0005\u0002\u0002ӊӋ\u0005L'\u0002Ӌӌ\u0007\u0006\u0002\u0002ӌӜ\u0003\u0002\u0002\u0002Ӎӎ\u0007N\u0002\u0002ӎӏ\u0007c\u0002\u0002ӏӐ\u0007\u0005\u0002\u0002Ӑӕ\u0005\u0094K\u0002ӑӒ\u0007\u0007\u0002\u0002ӒӔ\u0005\u0094K\u0002ӓӑ\u0003\u0002\u0002\u0002Ӕӗ\u0003\u0002\u0002\u0002ӕӓ\u0003\u0002\u0002\u0002ӕӖ\u0003\u0002\u0002\u0002ӖӘ\u0003\u0002\u0002\u0002ӗӕ\u0003\u0002\u0002\u0002Әә\u0007\u0006\u0002\u0002әӚ\u0005P)\u0002ӚӜ\u0003\u0002\u0002\u0002ӛҺ\u0003\u0002\u0002\u0002ӛӈ\u0003\u0002\u0002\u0002ӛӍ\u0003\u0002\u0002\u0002ӜW\u0003\u0002\u0002\u0002ӝӟ\u0007\u0097\u0002\u0002ӞӠ\u0007x\u0002\u0002ӟӞ\u0003\u0002\u0002\u0002ӟӠ\u0003\u0002\u0002\u0002Ӡӡ\u0003\u0002\u0002\u0002ӡӦ\u0005Z.\u0002Ӣӣ\u0007\u0007\u0002\u0002ӣӥ\u0005Z.\u0002ӤӢ\u0003\u0002\u0002\u0002ӥӨ\u0003\u0002\u0002\u0002ӦӤ\u0003\u0002\u0002\u0002Ӧӧ\u0003\u0002\u0002\u0002ӧY\u0003\u0002\u0002\u0002ӨӦ\u0003\u0002\u0002\u0002өӵ\u0005\u008eH\u0002Ӫӫ\u0007\u0005\u0002\u0002ӫӰ\u0005\u0094K\u0002Ӭӭ\u0007\u0007\u0002\u0002ӭӯ\u0005\u0094K\u0002ӮӬ\u0003\u0002\u0002\u0002ӯӲ\u0003\u0002\u0002\u0002ӰӮ\u0003\u0002\u0002\u0002Ӱӱ\u0003\u0002\u0002\u0002ӱӳ\u0003\u0002\u0002\u0002ӲӰ\u0003\u0002\u0002\u0002ӳӴ\u0007\u0006\u0002\u0002ӴӶ\u0003\u0002\u0002\u0002ӵӪ\u0003\u0002\u0002\u0002ӵӶ\u0003\u0002\u0002\u0002Ӷӷ\u0003\u0002\u0002\u0002ӷӸ\u0007%\u0002\u0002Ӹӹ\u0007\u0005\u0002\u0002ӹӺ\u0005:\u001e\u0002Ӻӻ\u0007\u0006\u0002\u0002ӻ[\u0003\u0002\u0002\u0002Ӽӽ\u0005\u008aF\u0002ӽӾ\u0007\u0004\u0002\u0002ӾԀ\u0003\u0002\u0002\u0002ӿӼ\u0003\u0002\u0002\u0002ӿԀ\u0003\u0002\u0002\u0002Ԁԁ\u0003\u0002\u0002\u0002ԁԄ\u0005\u008eH\u0002Ԃԃ\u0007%\u0002\u0002ԃԅ\u0005¦T\u0002ԄԂ\u0003\u0002\u0002\u0002Ԅԅ\u0003\u0002\u0002\u0002ԅԋ\u0003\u0002\u0002\u0002Ԇԇ\u0007Y\u0002\u0002ԇԈ\u0007,\u0002\u0002ԈԌ\u0005\u009aN\u0002ԉԊ\u0007j\u0002\u0002ԊԌ\u0007Y\u0002\u0002ԋԆ\u0003\u0002\u0002\u0002ԋԉ\u0003\u0002\u0002\u0002ԋԌ\u0003\u0002\u0002\u0002Ԍ]\u0003\u0002\u0002\u0002ԍԎ\u0007q\u0002\u0002Ԏԏ\u0007,\u0002\u0002ԏԔ\u0005`1\u0002Ԑԑ\u0007\u0007\u0002\u0002ԑԓ\u0005`1\u0002ԒԐ\u0003\u0002\u0002\u0002ԓԖ\u0003\u0002\u0002\u0002ԔԒ\u0003\u0002\u0002\u0002Ԕԕ\u0003\u0002\u0002\u0002ԕ_\u0003\u0002\u0002\u0002ԖԔ\u0003\u0002\u0002\u0002ԗԚ\u0005L'\u0002Ԙԙ\u00071\u0002\u0002ԙԛ\u0005\u0096L\u0002ԚԘ\u0003\u0002\u0002\u0002Ԛԛ\u0003\u0002\u0002\u0002ԛԝ\u0003\u0002\u0002\u0002ԜԞ\t\u0006\u0002\u0002ԝԜ\u0003\u0002\u0002\u0002ԝԞ\u0003\u0002\u0002\u0002Ԟa\u0003\u0002\u0002\u0002ԟԠ\u0007f\u0002\u0002Ԡԣ\u0005L'\u0002ԡԢ\t\u000b\u0002\u0002ԢԤ\u0005L'\u0002ԣԡ\u0003\u0002\u0002\u0002ԣԤ\u0003\u0002\u0002\u0002Ԥc\u0003\u0002\u0002\u0002ԥԪ\u0005r:\u0002ԦԪ\u0005\u0086D\u0002ԧԪ\u0007\u009f\u0002\u0002ԨԪ\u0005v<\u0002ԩԥ\u0003\u0002\u0002\u0002ԩԦ\u0003\u0002\u0002\u0002ԩԧ\u0003\u0002\u0002\u0002ԩԨ\u0003\u0002\u0002\u0002Ԫe\u0003\u0002\u0002\u0002ԫԸ\u0007\t\u0002\u0002Ԭԭ\u0005\u008eH\u0002ԭԮ\u0007\u0004\u0002\u0002Ԯԯ\u0007\t\u0002\u0002ԯԸ\u0003\u0002\u0002\u0002\u0530Ե\u0005L'\u0002ԱԳ\u0007%\u0002\u0002ԲԱ\u0003\u0002\u0002\u0002ԲԳ\u0003\u0002\u0002\u0002ԳԴ\u0003\u0002\u0002\u0002ԴԶ\u0005\u0080A\u0002ԵԲ\u0003\u0002\u0002\u0002ԵԶ\u0003\u0002\u0002\u0002ԶԸ\u0003\u0002\u0002\u0002Էԫ\u0003\u0002\u0002\u0002ԷԬ\u0003\u0002\u0002\u0002Է\u0530\u0003\u0002\u0002\u0002Ըg\u0003\u0002\u0002\u0002ԹԺ\u0005\u008aF\u0002ԺԻ\u0007\u0004\u0002\u0002ԻԽ\u0003\u0002\u0002\u0002ԼԹ\u0003\u0002\u0002\u0002ԼԽ\u0003\u0002\u0002\u0002ԽԾ\u0003\u0002\u0002\u0002ԾՃ\u0005\u008eH\u0002ԿՁ\u0007%\u0002\u0002ՀԿ\u0003\u0002\u0002\u0002ՀՁ\u0003\u0002\u0002\u0002ՁՂ\u0003\u0002\u0002\u0002ՂՄ\u0005¦T\u0002ՃՀ\u0003\u0002\u0002\u0002ՃՄ\u0003\u0002\u0002\u0002ՄՊ\u0003\u0002\u0002\u0002ՅՆ\u0007Y\u0002\u0002ՆՇ\u0007,\u0002\u0002ՇՋ\u0005\u009aN\u0002ՈՉ\u0007j\u0002\u0002ՉՋ\u0007Y\u0002\u0002ՊՅ\u0003\u0002\u0002\u0002ՊՈ\u0003\u0002\u0002\u0002ՊՋ\u0003\u0002\u0002\u0002Ջռ\u0003\u0002\u0002\u0002ՌՍ\u0005\u008aF\u0002ՍՎ\u0007\u0004\u0002\u0002ՎՐ\u0003\u0002\u0002\u0002ՏՌ\u0003\u0002\u0002\u0002ՏՐ\u0003\u0002\u0002\u0002ՐՑ\u0003\u0002\u0002\u0002ՑՒ\u0005\u008cG\u0002Ւ՛\u0007\u0005\u0002\u0002Փ\u0558\u0005L'\u0002ՔՕ\u0007\u0007\u0002\u0002Օ\u0557\u0005L'\u0002ՖՔ\u0003\u0002\u0002\u0002\u0557՚\u0003\u0002\u0002\u0002\u0558Ֆ\u0003\u0002\u0002\u0002\u0558ՙ\u0003\u0002\u0002\u0002ՙ՜\u0003\u0002\u0002\u0002՚\u0558\u0003\u0002\u0002\u0002՛Փ\u0003\u0002\u0002\u0002՛՜\u0003\u0002\u0002\u0002՜՝\u0003\u0002\u0002\u0002՝բ\u0007\u0006\u0002\u0002՞ՠ\u0007%\u0002\u0002՟՞\u0003\u0002\u0002\u0002՟ՠ\u0003\u0002\u0002\u0002ՠա\u0003\u0002\u0002\u0002ագ\u0005¦T\u0002բ՟\u0003\u0002\u0002\u0002բգ\u0003\u0002\u0002\u0002գռ\u0003\u0002\u0002\u0002դծ\u0007\u0005\u0002\u0002եժ\u0005h5\u0002զէ\u0007\u0007\u0002\u0002էթ\u0005h5\u0002ըզ\u0003\u0002\u0002\u0002թլ\u0003\u0002\u0002\u0002ժը\u0003\u0002\u0002\u0002ժի\u0003\u0002\u0002\u0002իկ\u0003\u0002\u0002\u0002լժ\u0003\u0002\u0002\u0002խկ\u0005j6\u0002ծե\u0003\u0002\u0002\u0002ծխ\u0003\u0002\u0002\u0002կհ\u0003\u0002\u0002\u0002հձ\u0007\u0006\u0002\u0002ձռ\u0003\u0002\u0002\u0002ղճ\u0007\u0005\u0002\u0002ճմ\u0005:\u001e\u0002մչ\u0007\u0006\u0002\u0002յշ\u0007%\u0002\u0002նյ\u0003\u0002\u0002\u0002նշ\u0003\u0002\u0002\u0002շո\u0003\u0002\u0002\u0002ոպ\u0005¦T\u0002չն\u0003\u0002\u0002\u0002չպ\u0003\u0002\u0002\u0002պռ\u0003\u0002\u0002\u0002ջԼ\u0003\u0002\u0002\u0002ջՏ\u0003\u0002\u0002\u0002ջդ\u0003\u0002\u0002\u0002ջղ\u0003\u0002\u0002\u0002ռi\u0003\u0002\u0002\u0002սք\u0005h5\u0002վտ\u0005l7\u0002տր\u0005h5\u0002րց\u0005n8\u0002ցփ\u0003\u0002\u0002\u0002ւվ\u0003\u0002\u0002\u0002փֆ\u0003\u0002\u0002\u0002քւ\u0003\u0002\u0002\u0002քօ\u0003\u0002\u0002\u0002օk\u0003\u0002\u0002\u0002ֆք\u0003\u0002\u0002\u0002և֕\u0007\u0007\u0002\u0002ֈ֊\u0007h\u0002\u0002։ֈ\u0003\u0002\u0002\u0002։֊\u0003\u0002\u0002\u0002֊֑\u0003\u0002\u0002\u0002\u058b֍\u0007d\u0002\u0002\u058c֎\u0007r\u0002\u0002֍\u058c\u0003\u0002\u0002\u0002֍֎\u0003\u0002\u0002\u0002֎֒\u0003\u0002\u0002\u0002֏֒\u0007[\u0002\u0002\u0590֒\u00077\u0002\u0002֑\u058b\u0003\u0002\u0002\u0002֑֏\u0003\u0002\u0002\u0002֑\u0590\u0003\u0002\u0002\u0002֑֒\u0003\u0002\u0002\u0002֒֓\u0003\u0002\u0002\u0002֓֕\u0007b\u0002\u0002֔և\u0003\u0002\u0002\u0002֔։\u0003\u0002\u0002\u0002֕m\u0003\u0002\u0002\u0002֖֗\u0007o\u0002\u0002֥֗\u0005L'\u0002֘֙\u0007\u0090\u0002\u0002֚֙\u0007\u0005\u0002\u0002֚֟\u0005\u0094K\u0002֛֜\u0007\u0007\u0002\u0002֜֞\u0005\u0094K\u0002֛֝\u0003\u0002\u0002\u0002֞֡\u0003\u0002\u0002\u0002֟֝\u0003\u0002\u0002\u0002֟֠\u0003\u0002\u0002\u0002֢֠\u0003\u0002\u0002\u0002֡֟\u0003\u0002\u0002\u0002֢֣\u0007\u0006\u0002\u0002֣֥\u0003\u0002\u0002\u0002֤֖\u0003\u0002\u0002\u0002֤֘\u0003\u0002\u0002\u0002֤֥\u0003\u0002\u0002\u0002֥o\u0003\u0002\u0002\u0002֦֬\u0007\u008d\u0002\u0002֧֨\u0007\u008d\u0002\u0002֨֬\u0007!\u0002\u0002֩֬\u0007^\u0002\u0002֪֬\u0007H\u0002\u0002֦֫\u0003\u0002\u0002\u0002֧֫\u0003\u0002\u0002\u0002֫֩\u0003\u0002\u0002\u0002֪֫\u0003\u0002\u0002\u0002֬q\u0003\u0002\u0002\u0002֭֯\t\f\u0002\u0002֭֮\u0003\u0002\u0002\u0002֮֯\u0003\u0002\u0002\u0002ְ֯\u0003\u0002\u0002\u0002ְֱ\u0007\u009d\u0002\u0002ֱs\u0003\u0002\u0002\u0002ֲֻ\u0007\u009d\u0002\u0002ֳֻ\u0007\u009f\u0002\u0002ִֻ\u0007 \u0002\u0002ֵֻ\u0007l\u0002\u0002ֶֻ\u00079\u0002\u0002ַֻ\u00078\u0002\u0002ָֻ\u0007:\u0002\u0002ֹֻ\u0005v<\u0002ֲֺ\u0003\u0002\u0002\u0002ֳֺ\u0003\u0002\u0002\u0002ִֺ\u0003\u0002\u0002\u0002ֵֺ\u0003\u0002\u0002\u0002ֶֺ\u0003\u0002\u0002\u0002ַֺ\u0003\u0002\u0002\u0002ָֺ\u0003\u0002\u0002\u0002ֺֹ\u0003\u0002\u0002\u0002ֻu\u0003\u0002\u0002\u0002ּֽ\t\r\u0002\u0002ֽw\u0003\u0002\u0002\u0002־ֿ\t\u000e\u0002\u0002ֿy\u0003\u0002\u0002\u0002׀\u05c9\u0007\r\u0002\u0002ׁ\u05c9\t\u000f\u0002\u0002ׂ\u05c9\t\f\u0002\u0002׃\u05c9\t\u0010\u0002\u0002ׄ\u05c9\t\u0011\u0002\u0002ׅ\u05c9\t\u0012\u0002\u0002׆\u05c9\u0007$\u0002\u0002ׇ\u05c9\u0007p\u0002\u0002\u05c8׀\u0003\u0002\u0002\u0002\u05c8ׁ\u0003\u0002\u0002\u0002\u05c8ׂ\u0003\u0002\u0002\u0002\u05c8׃\u0003\u0002\u0002\u0002\u05c8ׄ\u0003\u0002\u0002\u0002\u05c8ׅ\u0003\u0002\u0002\u0002\u05c8׆\u0003\u0002\u0002\u0002\u05c8ׇ\u0003\u0002\u0002\u0002\u05c9{\u0003\u0002\u0002\u0002\u05ca\u05cb\u0007\u009f\u0002\u0002\u05cb}\u0003\u0002\u0002\u0002\u05cc\u05cf\u0005L'\u0002\u05cd\u05cf\u0005D#\u0002\u05ce\u05cc\u0003\u0002\u0002\u0002\u05ce\u05cd\u0003\u0002\u0002\u0002\u05cf\u007f\u0003\u0002\u0002\u0002אב\t\u0013\u0002\u0002ב\u0081\u0003\u0002\u0002\u0002גד\u0007\u0005\u0002\u0002דט\u0005\u0094K\u0002הו\u0007\u0007\u0002\u0002וח\u0005\u0094K\u0002זה\u0003\u0002\u0002\u0002חך\u0003\u0002\u0002\u0002טז\u0003\u0002\u0002\u0002טי\u0003\u0002\u0002\u0002יכ\u0003\u0002\u0002\u0002ךט\u0003\u0002\u0002\u0002כל\u0007\u0006\u0002\u0002ל\u0083\u0003\u0002\u0002\u0002םמ\t\u0014\u0002\u0002מ\u0085\u0003\u0002\u0002\u0002ןנ\u0005ªV\u0002נ\u0087\u0003\u0002\u0002\u0002סע\u0005ªV\u0002ע\u0089\u0003\u0002\u0002\u0002ףפ\u0005ªV\u0002פ\u008b\u0003\u0002\u0002\u0002ץצ\u0005ªV\u0002צ\u008d\u0003\u0002\u0002\u0002קר\u0005ªV\u0002ר\u008f\u0003\u0002\u0002\u0002שת\u0005ªV\u0002ת\u0091\u0003\u0002\u0002\u0002\u05eb\u05ec\u0005ªV\u0002\u05ec\u0093\u0003\u0002\u0002\u0002\u05ed\u05ee\u0005ªV\u0002\u05ee\u0095\u0003\u0002\u0002\u0002ׯװ\u0005ªV\u0002װ\u0097\u0003\u0002\u0002\u0002ױײ\u0005ªV\u0002ײ\u0099\u0003\u0002\u0002\u0002׳״\u0005ªV\u0002״\u009b\u0003\u0002\u0002\u0002\u05f5\u05f6\u0005ªV\u0002\u05f6\u009d\u0003\u0002\u0002\u0002\u05f7\u05f8\u0005ªV\u0002\u05f8\u009f\u0003\u0002\u0002\u0002\u05f9\u05fa\u0005ªV\u0002\u05fa¡\u0003\u0002\u0002\u0002\u05fb\u05fc\u0005ªV\u0002\u05fc£\u0003\u0002\u0002\u0002\u05fd\u05fe\u0005ªV\u0002\u05fe¥\u0003\u0002\u0002\u0002\u05ff؆\u0007\u009c\u0002\u0002\u0600؆\u0007\u009f\u0002\u0002\u0601\u0602\u0007\u0005\u0002\u0002\u0602\u0603\u0005¦T\u0002\u0603\u0604\u0007\u0006\u0002\u0002\u0604؆\u0003\u0002\u0002\u0002\u0605\u05ff\u0003\u0002\u0002\u0002\u0605\u0600\u0003\u0002\u0002\u0002\u0605\u0601\u0003\u0002\u0002\u0002؆§\u0003\u0002\u0002\u0002؇؈\u0005ªV\u0002؈©\u0003\u0002\u0002\u0002؉ؑ\u0007\u009c\u0002\u0002؊ؑ\u0005\u0084C\u0002؋ؑ\u0007\u009f\u0002\u0002،؍\u0007\u0005\u0002\u0002؍؎\u0005ªV\u0002؎؏\u0007\u0006\u0002\u0002؏ؑ\u0003\u0002\u0002\u0002ؐ؉\u0003\u0002\u0002\u0002ؐ؊\u0003\u0002\u0002\u0002ؐ؋\u0003\u0002\u0002\u0002ؐ،\u0003\u0002\u0002\u0002ؑ«\u0003\u0002\u0002\u0002Ý®°»ÂÇÍÓÕòùāĄčđęĝğĤĦĪİĵŀņŊŐŕŞťŪŮŲŸŽƄƏƒƔƚƠƤƫƱƷƽǂǊǍǘǝǨǭǰǷǺȁȄȇȋȓȘȠȥȭȲȺȿɄɗɝɢɪɯɼʂʅʏʕʗʞʥʬʱʳʹ˂ˉˍˏ˓˚˜ˠˣ˩˱˵˸˼̖̝̟̬̯̲͓̃̌̐̒̿͌͛ͨͮ͘ͅ͵ͼ\u0381΄·\u038bΏΔΚΦΪίγζψύϒϚϟϨϬϼϿЇАДЙТЧгйрфъѐіћџѡѣѫѶѻ҇ҋҏғҚҜҤҪҮұҵҺӂӕӛӟӦӰӵӿԄԋԔԚԝԣԩԲԵԷԼՀՃՊՏ\u0558՛՟բժծնչջք։֍ֺ֑֤֮֔֟֫\u05c8\u05ceט\u0605ؐ";
    protected static final PredictionContextCache _sharedContextCache = null;
    public static final String[] ruleNames = null;

    @Deprecated
    public static final String[] tokenNames = null;

    public static class Alter_table_stmtContext extends ParserRuleContext {
        public Alter_table_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_ADD() {
            return getToken(29, 0);
        }

        public TerminalNode K_ALTER() {
            return getToken(32, 0);
        }

        public TerminalNode K_COLUMN() {
            return getToken(48, 0);
        }

        public TerminalNode K_RENAME() {
            return getToken(123, 0);
        }

        public TerminalNode K_TABLE() {
            return getToken(132, 0);
        }

        public TerminalNode K_TO() {
            return getToken(136, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitAlter_table_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        public Column_defContext column_def() {
            return (Column_defContext) getRuleContext(Column_defContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterAlter_table_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitAlter_table_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 4;
        }

        public New_table_nameContext new_table_name() {
            return (New_table_nameContext) getRuleContext(New_table_nameContext.class, 0);
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }

        public Table_nameContext table_name() {
            return (Table_nameContext) getRuleContext(Table_nameContext.class, 0);
        }
    }

    public static class Analyze_stmtContext extends ParserRuleContext {
        public Analyze_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_ANALYZE() {
            return getToken(33, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitAnalyze_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterAnalyze_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitAnalyze_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 5;
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }

        public Table_or_index_nameContext table_or_index_name() {
            return (Table_or_index_nameContext) getRuleContext(Table_or_index_nameContext.class, 0);
        }
    }

    public static class Any_nameContext extends ParserRuleContext {
        public Any_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode IDENTIFIER() {
            return getToken(154, 0);
        }

        public TerminalNode STRING_LITERAL() {
            return getToken(157, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitAny_name(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterAny_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitAny_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 84;
        }

        public KeywordContext keyword() {
            return (KeywordContext) getRuleContext(KeywordContext.class, 0);
        }
    }

    public static class Attach_stmtContext extends ParserRuleContext {
        public Attach_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_AS() {
            return getToken(35, 0);
        }

        public TerminalNode K_ATTACH() {
            return getToken(37, 0);
        }

        public TerminalNode K_DATABASE() {
            return getToken(57, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitAttach_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterAttach_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitAttach_stmt(this);
            return;
        }

        public ExprContext expr() {
            return (ExprContext) getRuleContext(ExprContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 6;
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }
    }

    public static class Begin_stmtContext extends ParserRuleContext {
        public Begin_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_BEGIN() {
            return getToken(40, 0);
        }

        public TerminalNode K_DEFERRED() {
            return getToken(60, 0);
        }

        public TerminalNode K_EXCLUSIVE() {
            return getToken(71, 0);
        }

        public TerminalNode K_IMMEDIATE() {
            return getToken(84, 0);
        }

        public TerminalNode K_TRANSACTION() {
            return getToken(137, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitBegin_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterBegin_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitBegin_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 7;
        }

        public Transaction_nameContext transaction_name() {
            return (Transaction_nameContext) getRuleContext(Transaction_nameContext.class, 0);
        }
    }

    public static class Binary_operatorContext extends ParserRuleContext {
        public Binary_operatorContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_AND() {
            return getToken(34, 0);
        }

        public TerminalNode K_OR() {
            return getToken(110, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitBinary_operator(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterBinary_operator(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitBinary_operator(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 60;
        }
    }

    public static class Boolean_literalContext extends ParserRuleContext {
        public Boolean_literalContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode FALSE() {
            return getToken(26, 0);
        }

        public TerminalNode TRUE() {
            return getToken(25, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitBoolean_literal(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterBoolean_literal(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitBoolean_literal(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 58;
        }
    }

    public static class Collation_nameContext extends ParserRuleContext {
        public Collation_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitCollation_name(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterCollation_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitCollation_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 74;
        }
    }

    public static class Column_aliasContext extends ParserRuleContext {
        public Column_aliasContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode IDENTIFIER() {
            return getToken(154, 0);
        }

        public TerminalNode STRING_LITERAL() {
            return getToken(157, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitColumn_alias(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterColumn_alias(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitColumn_alias(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 63;
        }
    }

    public static class Column_constraintContext extends ParserRuleContext {
        public Column_constraintContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_ASC() {
            return getToken(36, 0);
        }

        public TerminalNode K_AUTOINCREMENT() {
            return getToken(38, 0);
        }

        public TerminalNode K_CHECK() {
            return getToken(46, 0);
        }

        public TerminalNode K_COLLATE() {
            return getToken(47, 0);
        }

        public TerminalNode K_CONSTRAINT() {
            return getToken(51, 0);
        }

        public TerminalNode K_DEFAULT() {
            return getToken(58, 0);
        }

        public TerminalNode K_DESC() {
            return getToken(62, 0);
        }

        public TerminalNode K_KEY() {
            return getToken(97, 0);
        }

        public TerminalNode K_NOT() {
            return getToken(104, 0);
        }

        public TerminalNode K_NULL() {
            return getToken(106, 0);
        }

        public TerminalNode K_PRIMARY() {
            return getToken(115, 0);
        }

        public TerminalNode K_UNIQUE() {
            return getToken(140, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitColumn_constraint(this);
        L7:
            return r5.visitChildren(this);
        }

        public Collation_nameContext collation_name() {
            return (Collation_nameContext) getRuleContext(Collation_nameContext.class, 0);
        }

        public Conflict_clauseContext conflict_clause() {
            return (Conflict_clauseContext) getRuleContext(Conflict_clauseContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterColumn_constraint(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitColumn_constraint(this);
            return;
        }

        public ExprContext expr() {
            return (ExprContext) getRuleContext(ExprContext.class, 0);
        }

        public Foreign_key_clauseContext foreign_key_clause() {
            return (Foreign_key_clauseContext) getRuleContext(Foreign_key_clauseContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 35;
        }

        public Literal_valueContext literal_value() {
            return (Literal_valueContext) getRuleContext(Literal_valueContext.class, 0);
        }

        public NameContext name() {
            return (NameContext) getRuleContext(NameContext.class, 0);
        }

        public Signed_numberContext signed_number() {
            return (Signed_numberContext) getRuleContext(Signed_numberContext.class, 0);
        }
    }

    public static class Column_defContext extends ParserRuleContext {
        public Column_defContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitColumn_def(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Column_constraintContext> column_constraint() {
            return getRuleContexts(Column_constraintContext.class);
        }

        public Column_nameContext column_name() {
            return (Column_nameContext) getRuleContext(Column_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterColumn_def(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitColumn_def(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 33;
        }

        public Type_nameContext type_name() {
            return (Type_nameContext) getRuleContext(Type_nameContext.class, 0);
        }

        public Column_constraintContext column_constraint(int r5) {
            return (Column_constraintContext) getRuleContext(Column_constraintContext.class, r5);
        }
    }

    public static class Column_nameContext extends ParserRuleContext {
        public Column_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitColumn_name(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterColumn_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitColumn_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 73;
        }
    }

    public static class Column_name_listContext extends ParserRuleContext {
        public Column_name_listContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitColumn_name_list(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Column_nameContext> column_name() {
            return getRuleContexts(Column_nameContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterColumn_name_list(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitColumn_name_list(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 64;
        }

        public Column_nameContext column_name(int r5) {
            return (Column_nameContext) getRuleContext(Column_nameContext.class, r5);
        }
    }

    public static class Comma_separated_exprContext extends ParserRuleContext {
        public Comma_separated_exprContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitComma_separated_expr(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterComma_separated_expr(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitComma_separated_expr(this);
            return;
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 38;
        }

        public ExprContext expr(int r5) {
            return (ExprContext) getRuleContext(ExprContext.class, r5);
        }
    }

    public static class Commit_stmtContext extends ParserRuleContext {
        public Commit_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_COMMIT() {
            return getToken(49, 0);
        }

        public TerminalNode K_END() {
            return getToken(68, 0);
        }

        public TerminalNode K_TRANSACTION() {
            return getToken(137, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitCommit_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterCommit_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitCommit_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 8;
        }

        public Transaction_nameContext transaction_name() {
            return (Transaction_nameContext) getRuleContext(Transaction_nameContext.class, 0);
        }
    }

    public static class Common_table_expressionContext extends ParserRuleContext {
        public Common_table_expressionContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_AS() {
            return getToken(35, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitCommon_table_expression(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Column_nameContext> column_name() {
            return getRuleContexts(Column_nameContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterCommon_table_expression(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitCommon_table_expression(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 44;
        }

        public Select_stmtContext select_stmt() {
            return (Select_stmtContext) getRuleContext(Select_stmtContext.class, 0);
        }

        public Table_nameContext table_name() {
            return (Table_nameContext) getRuleContext(Table_nameContext.class, 0);
        }

        public Column_nameContext column_name(int r5) {
            return (Column_nameContext) getRuleContext(Column_nameContext.class, r5);
        }
    }

    public static class Compound_operatorContext extends ParserRuleContext {
        public Compound_operatorContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_ALL() {
            return getToken(31, 0);
        }

        public TerminalNode K_EXCEPT() {
            return getToken(70, 0);
        }

        public TerminalNode K_INTERSECT() {
            return getToken(92, 0);
        }

        public TerminalNode K_UNION() {
            return getToken(139, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitCompound_operator(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterCompound_operator(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitCompound_operator(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 55;
        }
    }

    public static class Conflict_clauseContext extends ParserRuleContext {
        public Conflict_clauseContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_ABORT() {
            return getToken(27, 0);
        }

        public TerminalNode K_CONFLICT() {
            return getToken(50, 0);
        }

        public TerminalNode K_FAIL() {
            return getToken(74, 0);
        }

        public TerminalNode K_IGNORE() {
            return getToken(83, 0);
        }

        public TerminalNode K_ON() {
            return getToken(109, 0);
        }

        public TerminalNode K_REPLACE() {
            return getToken(124, 0);
        }

        public TerminalNode K_ROLLBACK() {
            return getToken(127, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitConflict_clause(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterConflict_clause(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitConflict_clause(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 36;
        }
    }

    public static class Create_index_stmtContext extends ParserRuleContext {
        public Create_index_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_CREATE() {
            return getToken(52, 0);
        }

        public TerminalNode K_EXISTS() {
            return getToken(72, 0);
        }

        public TerminalNode K_IF() {
            return getToken(82, 0);
        }

        public TerminalNode K_INDEX() {
            return getToken(86, 0);
        }

        public TerminalNode K_NOT() {
            return getToken(104, 0);
        }

        public TerminalNode K_ON() {
            return getToken(109, 0);
        }

        public TerminalNode K_UNIQUE() {
            return getToken(140, 0);
        }

        public TerminalNode K_WHERE() {
            return getToken(148, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitCreate_index_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterCreate_index_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitCreate_index_stmt(this);
            return;
        }

        public ExprContext expr() {
            return (ExprContext) getRuleContext(ExprContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 9;
        }

        public Index_nameContext index_name() {
            return (Index_nameContext) getRuleContext(Index_nameContext.class, 0);
        }

        public List<Indexed_columnContext> indexed_column() {
            return getRuleContexts(Indexed_columnContext.class);
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }

        public Table_nameContext table_name() {
            return (Table_nameContext) getRuleContext(Table_nameContext.class, 0);
        }

        public Indexed_columnContext indexed_column(int r5) {
            return (Indexed_columnContext) getRuleContext(Indexed_columnContext.class, r5);
        }
    }

    public static class Create_table_stmtContext extends ParserRuleContext {
        public Create_table_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_AS() {
            return getToken(35, 0);
        }

        public TerminalNode K_CREATE() {
            return getToken(52, 0);
        }

        public TerminalNode K_EXISTS() {
            return getToken(72, 0);
        }

        public TerminalNode K_IF() {
            return getToken(82, 0);
        }

        public TerminalNode K_NOT() {
            return getToken(104, 0);
        }

        public TerminalNode K_TABLE() {
            return getToken(132, 0);
        }

        public TerminalNode K_TEMP() {
            return getToken(133, 0);
        }

        public TerminalNode K_TEMPORARY() {
            return getToken(134, 0);
        }

        public TerminalNode WITHOUT_ROWID() {
            return getToken(151, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitCreate_table_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Column_defContext> column_def() {
            return getRuleContexts(Column_defContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterCreate_table_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitCreate_table_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 10;
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }

        public Select_stmtContext select_stmt() {
            return (Select_stmtContext) getRuleContext(Select_stmtContext.class, 0);
        }

        public List<Table_constraintContext> table_constraint() {
            return getRuleContexts(Table_constraintContext.class);
        }

        public Table_nameContext table_name() {
            return (Table_nameContext) getRuleContext(Table_nameContext.class, 0);
        }

        public Column_defContext column_def(int r5) {
            return (Column_defContext) getRuleContext(Column_defContext.class, r5);
        }

        public Table_constraintContext table_constraint(int r5) {
            return (Table_constraintContext) getRuleContext(Table_constraintContext.class, r5);
        }
    }

    public static class Create_trigger_stmtContext extends ParserRuleContext {
        public Create_trigger_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_AFTER() {
            return getToken(30, 0);
        }

        public TerminalNode K_BEFORE() {
            return getToken(39, 0);
        }

        public TerminalNode K_BEGIN() {
            return getToken(40, 0);
        }

        public TerminalNode K_CREATE() {
            return getToken(52, 0);
        }

        public TerminalNode K_DELETE() {
            return getToken(61, 0);
        }

        public TerminalNode K_EACH() {
            return getToken(66, 0);
        }

        public TerminalNode K_END() {
            return getToken(68, 0);
        }

        public TerminalNode K_EXISTS() {
            return getToken(72, 0);
        }

        public TerminalNode K_FOR() {
            return getToken(75, 0);
        }

        public TerminalNode K_IF() {
            return getToken(82, 0);
        }

        public TerminalNode K_INSERT() {
            return getToken(90, 0);
        }

        public TerminalNode K_INSTEAD() {
            return getToken(91, 0);
        }

        public TerminalNode K_NOT() {
            return getToken(104, 0);
        }

        public List<TerminalNode> K_OF() {
            return getTokens(107);
        }

        public TerminalNode K_ON() {
            return getToken(109, 0);
        }

        public TerminalNode K_ROW() {
            return getToken(128, 0);
        }

        public TerminalNode K_TEMP() {
            return getToken(133, 0);
        }

        public TerminalNode K_TEMPORARY() {
            return getToken(134, 0);
        }

        public TerminalNode K_TRIGGER() {
            return getToken(138, 0);
        }

        public TerminalNode K_UPDATE() {
            return getToken(141, 0);
        }

        public TerminalNode K_WHEN() {
            return getToken(147, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitCreate_trigger_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Column_nameContext> column_name() {
            return getRuleContexts(Column_nameContext.class);
        }

        public List<Delete_stmtContext> delete_stmt() {
            return getRuleContexts(Delete_stmtContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterCreate_trigger_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitCreate_trigger_stmt(this);
            return;
        }

        public ExprContext expr() {
            return (ExprContext) getRuleContext(ExprContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 11;
        }

        public List<Insert_stmtContext> insert_stmt() {
            return getRuleContexts(Insert_stmtContext.class);
        }

        public List<Schema_nameContext> schema_name() {
            return getRuleContexts(Schema_nameContext.class);
        }

        public List<Select_stmtContext> select_stmt() {
            return getRuleContexts(Select_stmtContext.class);
        }

        public Table_nameContext table_name() {
            return (Table_nameContext) getRuleContext(Table_nameContext.class, 0);
        }

        public Trigger_nameContext trigger_name() {
            return (Trigger_nameContext) getRuleContext(Trigger_nameContext.class, 0);
        }

        public List<Update_stmtContext> update_stmt() {
            return getRuleContexts(Update_stmtContext.class);
        }

        public TerminalNode K_OF(int r5) {
            return getToken(107, r5);
        }

        public Column_nameContext column_name(int r5) {
            return (Column_nameContext) getRuleContext(Column_nameContext.class, r5);
        }

        public Delete_stmtContext delete_stmt(int r5) {
            return (Delete_stmtContext) getRuleContext(Delete_stmtContext.class, r5);
        }

        public Insert_stmtContext insert_stmt(int r5) {
            return (Insert_stmtContext) getRuleContext(Insert_stmtContext.class, r5);
        }

        public Schema_nameContext schema_name(int r5) {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, r5);
        }

        public Select_stmtContext select_stmt(int r5) {
            return (Select_stmtContext) getRuleContext(Select_stmtContext.class, r5);
        }

        public Update_stmtContext update_stmt(int r5) {
            return (Update_stmtContext) getRuleContext(Update_stmtContext.class, r5);
        }
    }

    public static class Create_view_stmtContext extends ParserRuleContext {
        public Create_view_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_AS() {
            return getToken(35, 0);
        }

        public TerminalNode K_CREATE() {
            return getToken(52, 0);
        }

        public TerminalNode K_EXISTS() {
            return getToken(72, 0);
        }

        public TerminalNode K_IF() {
            return getToken(82, 0);
        }

        public TerminalNode K_NOT() {
            return getToken(104, 0);
        }

        public TerminalNode K_TEMP() {
            return getToken(133, 0);
        }

        public TerminalNode K_TEMPORARY() {
            return getToken(134, 0);
        }

        public TerminalNode K_VIEW() {
            return getToken(145, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitCreate_view_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Column_nameContext> column_name() {
            return getRuleContexts(Column_nameContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterCreate_view_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitCreate_view_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 12;
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }

        public Select_stmtContext select_stmt() {
            return (Select_stmtContext) getRuleContext(Select_stmtContext.class, 0);
        }

        public View_nameContext view_name() {
            return (View_nameContext) getRuleContext(View_nameContext.class, 0);
        }

        public Column_nameContext column_name(int r5) {
            return (Column_nameContext) getRuleContext(Column_nameContext.class, r5);
        }
    }

    public static class Create_virtual_table_stmtContext extends ParserRuleContext {
        public Create_virtual_table_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_CREATE() {
            return getToken(52, 0);
        }

        public TerminalNode K_EXISTS() {
            return getToken(72, 0);
        }

        public TerminalNode K_IF() {
            return getToken(82, 0);
        }

        public TerminalNode K_NOT() {
            return getToken(104, 0);
        }

        public TerminalNode K_TABLE() {
            return getToken(132, 0);
        }

        public TerminalNode K_USING() {
            return getToken(142, 0);
        }

        public TerminalNode K_VIRTUAL() {
            return getToken(146, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitCreate_virtual_table_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterCreate_virtual_table_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitCreate_virtual_table_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 13;
        }

        public List<Module_argumentContext> module_argument() {
            return getRuleContexts(Module_argumentContext.class);
        }

        public Module_nameContext module_name() {
            return (Module_nameContext) getRuleContext(Module_nameContext.class, 0);
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }

        public Table_nameContext table_name() {
            return (Table_nameContext) getRuleContext(Table_nameContext.class, 0);
        }

        public Module_argumentContext module_argument(int r5) {
            return (Module_argumentContext) getRuleContext(Module_argumentContext.class, r5);
        }
    }

    public static class Delete_stmtContext extends ParserRuleContext {
        public Delete_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_DELETE() {
            return getToken(61, 0);
        }

        public TerminalNode K_FROM() {
            return getToken(77, 0);
        }

        public TerminalNode K_WHERE() {
            return getToken(148, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitDelete_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterDelete_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitDelete_stmt(this);
            return;
        }

        public ExprContext expr() {
            return (ExprContext) getRuleContext(ExprContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 14;
        }

        public Qualified_table_nameContext qualified_table_name() {
            return (Qualified_table_nameContext) getRuleContext(Qualified_table_nameContext.class, 0);
        }

        public With_clauseContext with_clause() {
            return (With_clauseContext) getRuleContext(With_clauseContext.class, 0);
        }
    }

    public static class Delete_stmt_limitedContext extends ParserRuleContext {
        public Delete_stmt_limitedContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_DELETE() {
            return getToken(61, 0);
        }

        public TerminalNode K_FROM() {
            return getToken(77, 0);
        }

        public TerminalNode K_WHERE() {
            return getToken(148, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitDelete_stmt_limited(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterDelete_stmt_limited(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitDelete_stmt_limited(this);
            return;
        }

        public ExprContext expr() {
            return (ExprContext) getRuleContext(ExprContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 15;
        }

        public Limit_clauseContext limit_clause() {
            return (Limit_clauseContext) getRuleContext(Limit_clauseContext.class, 0);
        }

        public Order_clauseContext order_clause() {
            return (Order_clauseContext) getRuleContext(Order_clauseContext.class, 0);
        }

        public Qualified_table_nameContext qualified_table_name() {
            return (Qualified_table_nameContext) getRuleContext(Qualified_table_nameContext.class, 0);
        }

        public With_clauseContext with_clause() {
            return (With_clauseContext) getRuleContext(With_clauseContext.class, 0);
        }
    }

    public static class Detach_stmtContext extends ParserRuleContext {
        public Detach_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_DATABASE() {
            return getToken(57, 0);
        }

        public TerminalNode K_DETACH() {
            return getToken(63, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitDetach_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterDetach_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitDetach_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 16;
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }
    }

    public static class Drop_index_stmtContext extends ParserRuleContext {
        public Drop_index_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_DROP() {
            return getToken(65, 0);
        }

        public TerminalNode K_EXISTS() {
            return getToken(72, 0);
        }

        public TerminalNode K_IF() {
            return getToken(82, 0);
        }

        public TerminalNode K_INDEX() {
            return getToken(86, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitDrop_index_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterDrop_index_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitDrop_index_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 17;
        }

        public Index_nameContext index_name() {
            return (Index_nameContext) getRuleContext(Index_nameContext.class, 0);
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }
    }

    public static class Drop_table_stmtContext extends ParserRuleContext {
        public Drop_table_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_DROP() {
            return getToken(65, 0);
        }

        public TerminalNode K_EXISTS() {
            return getToken(72, 0);
        }

        public TerminalNode K_IF() {
            return getToken(82, 0);
        }

        public TerminalNode K_TABLE() {
            return getToken(132, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitDrop_table_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterDrop_table_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitDrop_table_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 18;
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }

        public Table_nameContext table_name() {
            return (Table_nameContext) getRuleContext(Table_nameContext.class, 0);
        }
    }

    public static class Drop_trigger_stmtContext extends ParserRuleContext {
        public Drop_trigger_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_DROP() {
            return getToken(65, 0);
        }

        public TerminalNode K_EXISTS() {
            return getToken(72, 0);
        }

        public TerminalNode K_IF() {
            return getToken(82, 0);
        }

        public TerminalNode K_TRIGGER() {
            return getToken(138, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitDrop_trigger_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterDrop_trigger_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitDrop_trigger_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 19;
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }

        public Trigger_nameContext trigger_name() {
            return (Trigger_nameContext) getRuleContext(Trigger_nameContext.class, 0);
        }
    }

    public static class Drop_view_stmtContext extends ParserRuleContext {
        public Drop_view_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_DROP() {
            return getToken(65, 0);
        }

        public TerminalNode K_EXISTS() {
            return getToken(72, 0);
        }

        public TerminalNode K_IF() {
            return getToken(82, 0);
        }

        public TerminalNode K_VIEW() {
            return getToken(145, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitDrop_view_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterDrop_view_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitDrop_view_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 20;
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }

        public View_nameContext view_name() {
            return (View_nameContext) getRuleContext(View_nameContext.class, 0);
        }
    }

    public static class ErrorContext extends ParserRuleContext {
        public Token UNEXPECTED_CHAR;

        public ErrorContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode UNEXPECTED_CHAR() {
            return getToken(162, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitError(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterError(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitError(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 1;
        }
    }

    public static class Error_messageContext extends ParserRuleContext {
        public Error_messageContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode STRING_LITERAL() {
            return getToken(157, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitError_message(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterError_message(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitError_message(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 61;
        }
    }

    public static class ExprContext extends ParserRuleContext {
        public ExprContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode BIND_PARAMETER() {
            return getToken(156, 0);
        }

        public TerminalNode K_AND() {
            return getToken(34, 0);
        }

        public TerminalNode K_AS() {
            return getToken(35, 0);
        }

        public TerminalNode K_BETWEEN() {
            return getToken(41, 0);
        }

        public TerminalNode K_CASE() {
            return getToken(44, 0);
        }

        public TerminalNode K_CAST() {
            return getToken(45, 0);
        }

        public TerminalNode K_COLLATE() {
            return getToken(47, 0);
        }

        public TerminalNode K_DISTINCT() {
            return getToken(64, 0);
        }

        public TerminalNode K_ELSE() {
            return getToken(67, 0);
        }

        public TerminalNode K_END() {
            return getToken(68, 0);
        }

        public TerminalNode K_ESCAPE() {
            return getToken(69, 0);
        }

        public TerminalNode K_EXISTS() {
            return getToken(72, 0);
        }

        public TerminalNode K_GLOB() {
            return getToken(79, 0);
        }

        public TerminalNode K_IN() {
            return getToken(85, 0);
        }

        public TerminalNode K_IS() {
            return getToken(94, 0);
        }

        public TerminalNode K_ISNULL() {
            return getToken(95, 0);
        }

        public TerminalNode K_LIKE() {
            return getToken(99, 0);
        }

        public TerminalNode K_MATCH() {
            return getToken(101, 0);
        }

        public TerminalNode K_NOT() {
            return getToken(104, 0);
        }

        public TerminalNode K_NOTNULL() {
            return getToken(105, 0);
        }

        public TerminalNode K_NULL() {
            return getToken(106, 0);
        }

        public TerminalNode K_REGEXP() {
            return getToken(120, 0);
        }

        public List<TerminalNode> K_THEN() {
            return getTokens(135);
        }

        public List<TerminalNode> K_WHEN() {
            return getTokens(147);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitExpr(this);
        L7:
            return r5.visitChildren(this);
        }

        public Binary_operatorContext binary_operator() {
            return (Binary_operatorContext) getRuleContext(Binary_operatorContext.class, 0);
        }

        public Collation_nameContext collation_name() {
            return (Collation_nameContext) getRuleContext(Collation_nameContext.class, 0);
        }

        public Column_nameContext column_name() {
            return (Column_nameContext) getRuleContext(Column_nameContext.class, 0);
        }

        public Comma_separated_exprContext comma_separated_expr() {
            return (Comma_separated_exprContext) getRuleContext(Comma_separated_exprContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterExpr(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitExpr(this);
            return;
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public Function_nameContext function_name() {
            return (Function_nameContext) getRuleContext(Function_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 37;
        }

        public Literal_valueContext literal_value() {
            return (Literal_valueContext) getRuleContext(Literal_valueContext.class, 0);
        }

        public Raise_functionContext raise_function() {
            return (Raise_functionContext) getRuleContext(Raise_functionContext.class, 0);
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }

        public Select_stmtContext select_stmt() {
            return (Select_stmtContext) getRuleContext(Select_stmtContext.class, 0);
        }

        public Table_functionContext table_function() {
            return (Table_functionContext) getRuleContext(Table_functionContext.class, 0);
        }

        public Table_nameContext table_name() {
            return (Table_nameContext) getRuleContext(Table_nameContext.class, 0);
        }

        public Type_nameContext type_name() {
            return (Type_nameContext) getRuleContext(Type_nameContext.class, 0);
        }

        public Unary_operatorContext unary_operator() {
            return (Unary_operatorContext) getRuleContext(Unary_operatorContext.class, 0);
        }

        public TerminalNode K_THEN(int r5) {
            return getToken(135, r5);
        }

        public TerminalNode K_WHEN(int r5) {
            return getToken(147, r5);
        }

        public ExprContext expr(int r5) {
            return (ExprContext) getRuleContext(ExprContext.class, r5);
        }
    }

    public static class Foreign_key_clauseContext extends ParserRuleContext {
        public Foreign_key_clauseContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public List<TerminalNode> K_ACTION() {
            return getTokens(28);
        }

        public List<TerminalNode> K_CASCADE() {
            return getTokens(43);
        }

        public List<TerminalNode> K_DEFAULT() {
            return getTokens(58);
        }

        public TerminalNode K_DEFERRABLE() {
            return getToken(59, 0);
        }

        public TerminalNode K_DEFERRED() {
            return getToken(60, 0);
        }

        public List<TerminalNode> K_DELETE() {
            return getTokens(61);
        }

        public TerminalNode K_IMMEDIATE() {
            return getToken(84, 0);
        }

        public TerminalNode K_INITIALLY() {
            return getToken(88, 0);
        }

        public List<TerminalNode> K_MATCH() {
            return getTokens(101);
        }

        public List<TerminalNode> K_NO() {
            return getTokens(103);
        }

        public TerminalNode K_NOT() {
            return getToken(104, 0);
        }

        public List<TerminalNode> K_NULL() {
            return getTokens(106);
        }

        public List<TerminalNode> K_ON() {
            return getTokens(109);
        }

        public TerminalNode K_REFERENCES() {
            return getToken(119, 0);
        }

        public List<TerminalNode> K_RESTRICT() {
            return getTokens(125);
        }

        public List<TerminalNode> K_SET() {
            return getTokens(131);
        }

        public List<TerminalNode> K_UPDATE() {
            return getTokens(141);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitForeign_key_clause(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Column_nameContext> column_name() {
            return getRuleContexts(Column_nameContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterForeign_key_clause(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitForeign_key_clause(this);
            return;
        }

        public Foreign_tableContext foreign_table() {
            return (Foreign_tableContext) getRuleContext(Foreign_tableContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 39;
        }

        public List<NameContext> name() {
            return getRuleContexts(NameContext.class);
        }

        public TerminalNode K_ACTION(int r5) {
            return getToken(28, r5);
        }

        public TerminalNode K_CASCADE(int r5) {
            return getToken(43, r5);
        }

        public TerminalNode K_DEFAULT(int r5) {
            return getToken(58, r5);
        }

        public TerminalNode K_DELETE(int r5) {
            return getToken(61, r5);
        }

        public TerminalNode K_MATCH(int r5) {
            return getToken(101, r5);
        }

        public TerminalNode K_NO(int r5) {
            return getToken(103, r5);
        }

        public TerminalNode K_NULL(int r5) {
            return getToken(106, r5);
        }

        public TerminalNode K_ON(int r5) {
            return getToken(109, r5);
        }

        public TerminalNode K_RESTRICT(int r5) {
            return getToken(125, r5);
        }

        public TerminalNode K_SET(int r5) {
            return getToken(131, r5);
        }

        public TerminalNode K_UPDATE(int r5) {
            return getToken(141, r5);
        }

        public Column_nameContext column_name(int r5) {
            return (Column_nameContext) getRuleContext(Column_nameContext.class, r5);
        }

        public NameContext name(int r5) {
            return (NameContext) getRuleContext(NameContext.class, r5);
        }
    }

    public static class Foreign_tableContext extends ParserRuleContext {
        public Foreign_tableContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitForeign_table(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterForeign_table(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitForeign_table(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 75;
        }
    }

    public static class Function_nameContext extends ParserRuleContext {
        public Function_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitFunction_name(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterFunction_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitFunction_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 67;
        }
    }

    public static class Index_nameContext extends ParserRuleContext {
        public Index_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitIndex_name(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterIndex_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitIndex_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 76;
        }
    }

    public static class Indexed_columnContext extends ParserRuleContext {
        public Indexed_columnContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_ASC() {
            return getToken(36, 0);
        }

        public TerminalNode K_COLLATE() {
            return getToken(47, 0);
        }

        public TerminalNode K_DESC() {
            return getToken(62, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitIndexed_column(this);
        L7:
            return r5.visitChildren(this);
        }

        public Collation_nameContext collation_name() {
            return (Collation_nameContext) getRuleContext(Collation_nameContext.class, 0);
        }

        public Column_nameContext column_name() {
            return (Column_nameContext) getRuleContext(Column_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterIndexed_column(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitIndexed_column(this);
            return;
        }

        public ExprContext expr() {
            return (ExprContext) getRuleContext(ExprContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 41;
        }
    }

    public static class Insert_stmtContext extends ParserRuleContext {
        public Insert_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_ABORT() {
            return getToken(27, 0);
        }

        public TerminalNode K_AS() {
            return getToken(35, 0);
        }

        public TerminalNode K_DEFAULT() {
            return getToken(58, 0);
        }

        public TerminalNode K_FAIL() {
            return getToken(74, 0);
        }

        public TerminalNode K_IGNORE() {
            return getToken(83, 0);
        }

        public TerminalNode K_INSERT() {
            return getToken(90, 0);
        }

        public TerminalNode K_INTO() {
            return getToken(93, 0);
        }

        public TerminalNode K_OR() {
            return getToken(110, 0);
        }

        public TerminalNode K_REPLACE() {
            return getToken(124, 0);
        }

        public TerminalNode K_ROLLBACK() {
            return getToken(127, 0);
        }

        public TerminalNode K_VALUES() {
            return getToken(144, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitInsert_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Column_nameContext> column_name() {
            return getRuleContexts(Column_nameContext.class);
        }

        public List<Comma_separated_exprContext> comma_separated_expr() {
            return getRuleContexts(Comma_separated_exprContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterInsert_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitInsert_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 21;
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }

        public Select_stmtContext select_stmt() {
            return (Select_stmtContext) getRuleContext(Select_stmtContext.class, 0);
        }

        public Table_aliasContext table_alias() {
            return (Table_aliasContext) getRuleContext(Table_aliasContext.class, 0);
        }

        public Table_nameContext table_name() {
            return (Table_nameContext) getRuleContext(Table_nameContext.class, 0);
        }

        public Upsert_clauseContext upsert_clause() {
            return (Upsert_clauseContext) getRuleContext(Upsert_clauseContext.class, 0);
        }

        public With_clauseContext with_clause() {
            return (With_clauseContext) getRuleContext(With_clauseContext.class, 0);
        }

        public Column_nameContext column_name(int r5) {
            return (Column_nameContext) getRuleContext(Column_nameContext.class, r5);
        }

        public Comma_separated_exprContext comma_separated_expr(int r5) {
            return (Comma_separated_exprContext) getRuleContext(Comma_separated_exprContext.class, r5);
        }
    }

    public static class Join_clauseContext extends ParserRuleContext {
        public Join_clauseContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitJoin_clause(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterJoin_clause(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitJoin_clause(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 52;
        }

        public List<Join_constraintContext> join_constraint() {
            return getRuleContexts(Join_constraintContext.class);
        }

        public List<Join_operatorContext> join_operator() {
            return getRuleContexts(Join_operatorContext.class);
        }

        public List<Table_or_subqueryContext> table_or_subquery() {
            return getRuleContexts(Table_or_subqueryContext.class);
        }

        public Join_constraintContext join_constraint(int r5) {
            return (Join_constraintContext) getRuleContext(Join_constraintContext.class, r5);
        }

        public Join_operatorContext join_operator(int r5) {
            return (Join_operatorContext) getRuleContext(Join_operatorContext.class, r5);
        }

        public Table_or_subqueryContext table_or_subquery(int r5) {
            return (Table_or_subqueryContext) getRuleContext(Table_or_subqueryContext.class, r5);
        }
    }

    public static class Join_constraintContext extends ParserRuleContext {
        public Join_constraintContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_ON() {
            return getToken(109, 0);
        }

        public TerminalNode K_USING() {
            return getToken(142, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitJoin_constraint(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Column_nameContext> column_name() {
            return getRuleContexts(Column_nameContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterJoin_constraint(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitJoin_constraint(this);
            return;
        }

        public ExprContext expr() {
            return (ExprContext) getRuleContext(ExprContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 54;
        }

        public Column_nameContext column_name(int r5) {
            return (Column_nameContext) getRuleContext(Column_nameContext.class, r5);
        }
    }

    public static class Join_operatorContext extends ParserRuleContext {
        public Join_operatorContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_CROSS() {
            return getToken(53, 0);
        }

        public TerminalNode K_INNER() {
            return getToken(89, 0);
        }

        public TerminalNode K_JOIN() {
            return getToken(96, 0);
        }

        public TerminalNode K_LEFT() {
            return getToken(98, 0);
        }

        public TerminalNode K_NATURAL() {
            return getToken(102, 0);
        }

        public TerminalNode K_OUTER() {
            return getToken(112, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitJoin_operator(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterJoin_operator(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitJoin_operator(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 53;
        }
    }

    public static class KeywordContext extends ParserRuleContext {
        public KeywordContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_ABORT() {
            return getToken(27, 0);
        }

        public TerminalNode K_ACTION() {
            return getToken(28, 0);
        }

        public TerminalNode K_ADD() {
            return getToken(29, 0);
        }

        public TerminalNode K_AFTER() {
            return getToken(30, 0);
        }

        public TerminalNode K_ALL() {
            return getToken(31, 0);
        }

        public TerminalNode K_ALTER() {
            return getToken(32, 0);
        }

        public TerminalNode K_ANALYZE() {
            return getToken(33, 0);
        }

        public TerminalNode K_AND() {
            return getToken(34, 0);
        }

        public TerminalNode K_AS() {
            return getToken(35, 0);
        }

        public TerminalNode K_ASC() {
            return getToken(36, 0);
        }

        public TerminalNode K_ATTACH() {
            return getToken(37, 0);
        }

        public TerminalNode K_AUTOINCREMENT() {
            return getToken(38, 0);
        }

        public TerminalNode K_BEFORE() {
            return getToken(39, 0);
        }

        public TerminalNode K_BEGIN() {
            return getToken(40, 0);
        }

        public TerminalNode K_BETWEEN() {
            return getToken(41, 0);
        }

        public TerminalNode K_BY() {
            return getToken(42, 0);
        }

        public TerminalNode K_CASCADE() {
            return getToken(43, 0);
        }

        public TerminalNode K_CASE() {
            return getToken(44, 0);
        }

        public TerminalNode K_CAST() {
            return getToken(45, 0);
        }

        public TerminalNode K_CHECK() {
            return getToken(46, 0);
        }

        public TerminalNode K_COLLATE() {
            return getToken(47, 0);
        }

        public TerminalNode K_COLUMN() {
            return getToken(48, 0);
        }

        public TerminalNode K_COMMIT() {
            return getToken(49, 0);
        }

        public TerminalNode K_CONFLICT() {
            return getToken(50, 0);
        }

        public TerminalNode K_CONSTRAINT() {
            return getToken(51, 0);
        }

        public TerminalNode K_CREATE() {
            return getToken(52, 0);
        }

        public TerminalNode K_CROSS() {
            return getToken(53, 0);
        }

        public TerminalNode K_CURRENT_DATE() {
            return getToken(54, 0);
        }

        public TerminalNode K_CURRENT_TIME() {
            return getToken(55, 0);
        }

        public TerminalNode K_CURRENT_TIMESTAMP() {
            return getToken(56, 0);
        }

        public TerminalNode K_DATABASE() {
            return getToken(57, 0);
        }

        public TerminalNode K_DEFAULT() {
            return getToken(58, 0);
        }

        public TerminalNode K_DEFERRABLE() {
            return getToken(59, 0);
        }

        public TerminalNode K_DEFERRED() {
            return getToken(60, 0);
        }

        public TerminalNode K_DELETE() {
            return getToken(61, 0);
        }

        public TerminalNode K_DESC() {
            return getToken(62, 0);
        }

        public TerminalNode K_DETACH() {
            return getToken(63, 0);
        }

        public TerminalNode K_DISTINCT() {
            return getToken(64, 0);
        }

        public TerminalNode K_DROP() {
            return getToken(65, 0);
        }

        public TerminalNode K_EACH() {
            return getToken(66, 0);
        }

        public TerminalNode K_ELSE() {
            return getToken(67, 0);
        }

        public TerminalNode K_END() {
            return getToken(68, 0);
        }

        public TerminalNode K_ESCAPE() {
            return getToken(69, 0);
        }

        public TerminalNode K_EXCEPT() {
            return getToken(70, 0);
        }

        public TerminalNode K_EXCLUSIVE() {
            return getToken(71, 0);
        }

        public TerminalNode K_EXISTS() {
            return getToken(72, 0);
        }

        public TerminalNode K_EXPLAIN() {
            return getToken(73, 0);
        }

        public TerminalNode K_FAIL() {
            return getToken(74, 0);
        }

        public TerminalNode K_FOR() {
            return getToken(75, 0);
        }

        public TerminalNode K_FOREIGN() {
            return getToken(76, 0);
        }

        public TerminalNode K_FROM() {
            return getToken(77, 0);
        }

        public TerminalNode K_FULL() {
            return getToken(78, 0);
        }

        public TerminalNode K_GLOB() {
            return getToken(79, 0);
        }

        public TerminalNode K_GROUP() {
            return getToken(80, 0);
        }

        public TerminalNode K_HAVING() {
            return getToken(81, 0);
        }

        public TerminalNode K_IF() {
            return getToken(82, 0);
        }

        public TerminalNode K_IGNORE() {
            return getToken(83, 0);
        }

        public TerminalNode K_IMMEDIATE() {
            return getToken(84, 0);
        }

        public TerminalNode K_IN() {
            return getToken(85, 0);
        }

        public TerminalNode K_INDEX() {
            return getToken(86, 0);
        }

        public TerminalNode K_INDEXED() {
            return getToken(87, 0);
        }

        public TerminalNode K_INITIALLY() {
            return getToken(88, 0);
        }

        public TerminalNode K_INNER() {
            return getToken(89, 0);
        }

        public TerminalNode K_INSERT() {
            return getToken(90, 0);
        }

        public TerminalNode K_INSTEAD() {
            return getToken(91, 0);
        }

        public TerminalNode K_INTERSECT() {
            return getToken(92, 0);
        }

        public TerminalNode K_INTO() {
            return getToken(93, 0);
        }

        public TerminalNode K_IS() {
            return getToken(94, 0);
        }

        public TerminalNode K_ISNULL() {
            return getToken(95, 0);
        }

        public TerminalNode K_JOIN() {
            return getToken(96, 0);
        }

        public TerminalNode K_KEY() {
            return getToken(97, 0);
        }

        public TerminalNode K_LEFT() {
            return getToken(98, 0);
        }

        public TerminalNode K_LIKE() {
            return getToken(99, 0);
        }

        public TerminalNode K_LIMIT() {
            return getToken(100, 0);
        }

        public TerminalNode K_MATCH() {
            return getToken(101, 0);
        }

        public TerminalNode K_NATURAL() {
            return getToken(102, 0);
        }

        public TerminalNode K_NO() {
            return getToken(103, 0);
        }

        public TerminalNode K_NOT() {
            return getToken(104, 0);
        }

        public TerminalNode K_NOTNULL() {
            return getToken(105, 0);
        }

        public TerminalNode K_NULL() {
            return getToken(106, 0);
        }

        public TerminalNode K_OF() {
            return getToken(107, 0);
        }

        public TerminalNode K_OFFSET() {
            return getToken(108, 0);
        }

        public TerminalNode K_ON() {
            return getToken(109, 0);
        }

        public TerminalNode K_OR() {
            return getToken(110, 0);
        }

        public TerminalNode K_ORDER() {
            return getToken(111, 0);
        }

        public TerminalNode K_OUTER() {
            return getToken(112, 0);
        }

        public TerminalNode K_PLAN() {
            return getToken(113, 0);
        }

        public TerminalNode K_PRAGMA() {
            return getToken(114, 0);
        }

        public TerminalNode K_PRIMARY() {
            return getToken(115, 0);
        }

        public TerminalNode K_QUERY() {
            return getToken(116, 0);
        }

        public TerminalNode K_RAISE() {
            return getToken(117, 0);
        }

        public TerminalNode K_RECURSIVE() {
            return getToken(118, 0);
        }

        public TerminalNode K_REFERENCES() {
            return getToken(119, 0);
        }

        public TerminalNode K_REGEXP() {
            return getToken(120, 0);
        }

        public TerminalNode K_REINDEX() {
            return getToken(121, 0);
        }

        public TerminalNode K_RELEASE() {
            return getToken(122, 0);
        }

        public TerminalNode K_RENAME() {
            return getToken(123, 0);
        }

        public TerminalNode K_REPLACE() {
            return getToken(124, 0);
        }

        public TerminalNode K_RESTRICT() {
            return getToken(125, 0);
        }

        public TerminalNode K_RIGHT() {
            return getToken(126, 0);
        }

        public TerminalNode K_ROLLBACK() {
            return getToken(127, 0);
        }

        public TerminalNode K_ROW() {
            return getToken(128, 0);
        }

        public TerminalNode K_SAVEPOINT() {
            return getToken(129, 0);
        }

        public TerminalNode K_SELECT() {
            return getToken(130, 0);
        }

        public TerminalNode K_SET() {
            return getToken(131, 0);
        }

        public TerminalNode K_TABLE() {
            return getToken(132, 0);
        }

        public TerminalNode K_TEMP() {
            return getToken(133, 0);
        }

        public TerminalNode K_TEMPORARY() {
            return getToken(134, 0);
        }

        public TerminalNode K_THEN() {
            return getToken(135, 0);
        }

        public TerminalNode K_TO() {
            return getToken(136, 0);
        }

        public TerminalNode K_TRANSACTION() {
            return getToken(137, 0);
        }

        public TerminalNode K_TRIGGER() {
            return getToken(138, 0);
        }

        public TerminalNode K_UNION() {
            return getToken(139, 0);
        }

        public TerminalNode K_UNIQUE() {
            return getToken(140, 0);
        }

        public TerminalNode K_UPDATE() {
            return getToken(141, 0);
        }

        public TerminalNode K_USING() {
            return getToken(142, 0);
        }

        public TerminalNode K_VACUUM() {
            return getToken(143, 0);
        }

        public TerminalNode K_VALUES() {
            return getToken(144, 0);
        }

        public TerminalNode K_VIEW() {
            return getToken(145, 0);
        }

        public TerminalNode K_VIRTUAL() {
            return getToken(146, 0);
        }

        public TerminalNode K_WHEN() {
            return getToken(147, 0);
        }

        public TerminalNode K_WHERE() {
            return getToken(148, 0);
        }

        public TerminalNode K_WITH() {
            return getToken(149, 0);
        }

        public TerminalNode K_WITHOUT() {
            return getToken(150, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitKeyword(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterKeyword(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitKeyword(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 65;
        }
    }

    public static class Limit_clauseContext extends ParserRuleContext {
        public Limit_clauseContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_LIMIT() {
            return getToken(100, 0);
        }

        public TerminalNode K_OFFSET() {
            return getToken(108, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitLimit_clause(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterLimit_clause(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitLimit_clause(this);
            return;
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 48;
        }

        public ExprContext expr(int r5) {
            return (ExprContext) getRuleContext(ExprContext.class, r5);
        }
    }

    public static class Literal_valueContext extends ParserRuleContext {
        public Literal_valueContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode BLOB_LITERAL() {
            return getToken(158, 0);
        }

        public TerminalNode K_CURRENT_DATE() {
            return getToken(54, 0);
        }

        public TerminalNode K_CURRENT_TIME() {
            return getToken(55, 0);
        }

        public TerminalNode K_CURRENT_TIMESTAMP() {
            return getToken(56, 0);
        }

        public TerminalNode K_NULL() {
            return getToken(106, 0);
        }

        public TerminalNode NUMERIC_LITERAL() {
            return getToken(155, 0);
        }

        public TerminalNode STRING_LITERAL() {
            return getToken(157, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitLiteral_value(this);
        L7:
            return r5.visitChildren(this);
        }

        public Boolean_literalContext boolean_literal() {
            return (Boolean_literalContext) getRuleContext(Boolean_literalContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterLiteral_value(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitLiteral_value(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 57;
        }
    }

    public static class Module_argumentContext extends ParserRuleContext {
        public Module_argumentContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitModule_argument(this);
        L7:
            return r5.visitChildren(this);
        }

        public Column_defContext column_def() {
            return (Column_defContext) getRuleContext(Column_defContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterModule_argument(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitModule_argument(this);
            return;
        }

        public ExprContext expr() {
            return (ExprContext) getRuleContext(ExprContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 62;
        }
    }

    public static class Module_nameContext extends ParserRuleContext {
        public Module_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitModule_name(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterModule_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitModule_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 79;
        }
    }

    public static class NameContext extends ParserRuleContext {
        public NameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitName(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterName(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitName(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 66;
        }
    }

    public static class New_table_nameContext extends ParserRuleContext {
        public New_table_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitNew_table_name(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterNew_table_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitNew_table_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 72;
        }
    }

    public static class Order_clauseContext extends ParserRuleContext {
        public Order_clauseContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_BY() {
            return getToken(42, 0);
        }

        public TerminalNode K_ORDER() {
            return getToken(111, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitOrder_clause(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterOrder_clause(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitOrder_clause(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 46;
        }

        public List<Ordering_termContext> ordering_term() {
            return getRuleContexts(Ordering_termContext.class);
        }

        public Ordering_termContext ordering_term(int r5) {
            return (Ordering_termContext) getRuleContext(Ordering_termContext.class, r5);
        }
    }

    public static class Ordering_termContext extends ParserRuleContext {
        public Ordering_termContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_ASC() {
            return getToken(36, 0);
        }

        public TerminalNode K_COLLATE() {
            return getToken(47, 0);
        }

        public TerminalNode K_DESC() {
            return getToken(62, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitOrdering_term(this);
        L7:
            return r5.visitChildren(this);
        }

        public Collation_nameContext collation_name() {
            return (Collation_nameContext) getRuleContext(Collation_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterOrdering_term(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitOrdering_term(this);
            return;
        }

        public ExprContext expr() {
            return (ExprContext) getRuleContext(ExprContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 47;
        }
    }

    public static class ParseContext extends ParserRuleContext {
        public ParseContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode EOF() {
            return getToken(-1, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitParse(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterParse(this);
            return;
        }

        public List<ErrorContext> error() {
            return getRuleContexts(ErrorContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitParse(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 0;
        }

        public List<Sql_stmt_listContext> sql_stmt_list() {
            return getRuleContexts(Sql_stmt_listContext.class);
        }

        public ErrorContext error(int r5) {
            return (ErrorContext) getRuleContext(ErrorContext.class, r5);
        }

        public Sql_stmt_listContext sql_stmt_list(int r5) {
            return (Sql_stmt_listContext) getRuleContext(Sql_stmt_listContext.class, r5);
        }
    }

    public static class Pragma_nameContext extends ParserRuleContext {
        public Pragma_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitPragma_name(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterPragma_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitPragma_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 80;
        }
    }

    public static class Pragma_stmtContext extends ParserRuleContext {
        public Pragma_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_PRAGMA() {
            return getToken(114, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitPragma_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterPragma_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitPragma_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 23;
        }

        public Pragma_nameContext pragma_name() {
            return (Pragma_nameContext) getRuleContext(Pragma_nameContext.class, 0);
        }

        public Pragma_valueContext pragma_value() {
            return (Pragma_valueContext) getRuleContext(Pragma_valueContext.class, 0);
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }
    }

    public static class Pragma_valueContext extends ParserRuleContext {
        public Pragma_valueContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode STRING_LITERAL() {
            return getToken(157, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitPragma_value(this);
        L7:
            return r5.visitChildren(this);
        }

        public Boolean_literalContext boolean_literal() {
            return (Boolean_literalContext) getRuleContext(Boolean_literalContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterPragma_value(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitPragma_value(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 49;
        }

        public NameContext name() {
            return (NameContext) getRuleContext(NameContext.class, 0);
        }

        public Signed_numberContext signed_number() {
            return (Signed_numberContext) getRuleContext(Signed_numberContext.class, 0);
        }
    }

    public static class Qualified_table_nameContext extends ParserRuleContext {
        public Qualified_table_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_AS() {
            return getToken(35, 0);
        }

        public TerminalNode K_BY() {
            return getToken(42, 0);
        }

        public TerminalNode K_INDEXED() {
            return getToken(87, 0);
        }

        public TerminalNode K_NOT() {
            return getToken(104, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitQualified_table_name(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterQualified_table_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitQualified_table_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 45;
        }

        public Index_nameContext index_name() {
            return (Index_nameContext) getRuleContext(Index_nameContext.class, 0);
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }

        public Table_aliasContext table_alias() {
            return (Table_aliasContext) getRuleContext(Table_aliasContext.class, 0);
        }

        public Table_nameContext table_name() {
            return (Table_nameContext) getRuleContext(Table_nameContext.class, 0);
        }
    }

    public static class Raise_functionContext extends ParserRuleContext {
        public Raise_functionContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_ABORT() {
            return getToken(27, 0);
        }

        public TerminalNode K_FAIL() {
            return getToken(74, 0);
        }

        public TerminalNode K_IGNORE() {
            return getToken(83, 0);
        }

        public TerminalNode K_RAISE() {
            return getToken(117, 0);
        }

        public TerminalNode K_ROLLBACK() {
            return getToken(127, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitRaise_function(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterRaise_function(this);
            return;
        }

        public Error_messageContext error_message() {
            return (Error_messageContext) getRuleContext(Error_messageContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitRaise_function(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 40;
        }
    }

    public static class Reindex_stmtContext extends ParserRuleContext {
        public Reindex_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_REINDEX() {
            return getToken(121, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitReindex_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        public Collation_nameContext collation_name() {
            return (Collation_nameContext) getRuleContext(Collation_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterReindex_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitReindex_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 24;
        }

        public Index_nameContext index_name() {
            return (Index_nameContext) getRuleContext(Index_nameContext.class, 0);
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }

        public Table_nameContext table_name() {
            return (Table_nameContext) getRuleContext(Table_nameContext.class, 0);
        }
    }

    public static class Release_stmtContext extends ParserRuleContext {
        public Release_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_RELEASE() {
            return getToken(122, 0);
        }

        public TerminalNode K_SAVEPOINT() {
            return getToken(129, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitRelease_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterRelease_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitRelease_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 25;
        }

        public Savepoint_nameContext savepoint_name() {
            return (Savepoint_nameContext) getRuleContext(Savepoint_nameContext.class, 0);
        }
    }

    public static class Result_columnContext extends ParserRuleContext {
        public Result_columnContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_AS() {
            return getToken(35, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitResult_column(this);
        L7:
            return r5.visitChildren(this);
        }

        public Column_aliasContext column_alias() {
            return (Column_aliasContext) getRuleContext(Column_aliasContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterResult_column(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitResult_column(this);
            return;
        }

        public ExprContext expr() {
            return (ExprContext) getRuleContext(ExprContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 50;
        }

        public Table_nameContext table_name() {
            return (Table_nameContext) getRuleContext(Table_nameContext.class, 0);
        }
    }

    public static class Rollback_stmtContext extends ParserRuleContext {
        public Rollback_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_ROLLBACK() {
            return getToken(127, 0);
        }

        public TerminalNode K_SAVEPOINT() {
            return getToken(129, 0);
        }

        public TerminalNode K_TO() {
            return getToken(136, 0);
        }

        public TerminalNode K_TRANSACTION() {
            return getToken(137, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitRollback_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterRollback_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitRollback_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 26;
        }

        public Savepoint_nameContext savepoint_name() {
            return (Savepoint_nameContext) getRuleContext(Savepoint_nameContext.class, 0);
        }

        public Transaction_nameContext transaction_name() {
            return (Transaction_nameContext) getRuleContext(Transaction_nameContext.class, 0);
        }
    }

    public static class Savepoint_nameContext extends ParserRuleContext {
        public Savepoint_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitSavepoint_name(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterSavepoint_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitSavepoint_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 81;
        }
    }

    public static class Savepoint_stmtContext extends ParserRuleContext {
        public Savepoint_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_SAVEPOINT() {
            return getToken(129, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitSavepoint_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterSavepoint_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitSavepoint_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 27;
        }

        public Savepoint_nameContext savepoint_name() {
            return (Savepoint_nameContext) getRuleContext(Savepoint_nameContext.class, 0);
        }
    }

    public static class Schema_nameContext extends ParserRuleContext {
        public Schema_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitSchema_name(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterSchema_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitSchema_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 68;
        }
    }

    public static class Select_or_valuesContext extends ParserRuleContext {
        public Select_or_valuesContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_ALL() {
            return getToken(31, 0);
        }

        public TerminalNode K_BY() {
            return getToken(42, 0);
        }

        public TerminalNode K_DISTINCT() {
            return getToken(64, 0);
        }

        public TerminalNode K_FROM() {
            return getToken(77, 0);
        }

        public TerminalNode K_GROUP() {
            return getToken(80, 0);
        }

        public TerminalNode K_HAVING() {
            return getToken(81, 0);
        }

        public TerminalNode K_SELECT() {
            return getToken(130, 0);
        }

        public TerminalNode K_VALUES() {
            return getToken(144, 0);
        }

        public TerminalNode K_WHERE() {
            return getToken(148, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitSelect_or_values(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Comma_separated_exprContext> comma_separated_expr() {
            return getRuleContexts(Comma_separated_exprContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterSelect_or_values(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitSelect_or_values(this);
            return;
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 29;
        }

        public Join_clauseContext join_clause() {
            return (Join_clauseContext) getRuleContext(Join_clauseContext.class, 0);
        }

        public List<Result_columnContext> result_column() {
            return getRuleContexts(Result_columnContext.class);
        }

        public List<Table_or_subqueryContext> table_or_subquery() {
            return getRuleContexts(Table_or_subqueryContext.class);
        }

        public Comma_separated_exprContext comma_separated_expr(int r5) {
            return (Comma_separated_exprContext) getRuleContext(Comma_separated_exprContext.class, r5);
        }

        public ExprContext expr(int r5) {
            return (ExprContext) getRuleContext(ExprContext.class, r5);
        }

        public Result_columnContext result_column(int r5) {
            return (Result_columnContext) getRuleContext(Result_columnContext.class, r5);
        }

        public Table_or_subqueryContext table_or_subquery(int r5) {
            return (Table_or_subqueryContext) getRuleContext(Table_or_subqueryContext.class, r5);
        }
    }

    public static class Select_stmtContext extends ParserRuleContext {
        public Select_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitSelect_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Compound_operatorContext> compound_operator() {
            return getRuleContexts(Compound_operatorContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterSelect_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitSelect_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 28;
        }

        public Limit_clauseContext limit_clause() {
            return (Limit_clauseContext) getRuleContext(Limit_clauseContext.class, 0);
        }

        public Order_clauseContext order_clause() {
            return (Order_clauseContext) getRuleContext(Order_clauseContext.class, 0);
        }

        public List<Select_or_valuesContext> select_or_values() {
            return getRuleContexts(Select_or_valuesContext.class);
        }

        public With_clauseContext with_clause() {
            return (With_clauseContext) getRuleContext(With_clauseContext.class, 0);
        }

        public Compound_operatorContext compound_operator(int r5) {
            return (Compound_operatorContext) getRuleContext(Compound_operatorContext.class, r5);
        }

        public Select_or_valuesContext select_or_values(int r5) {
            return (Select_or_valuesContext) getRuleContext(Select_or_valuesContext.class, r5);
        }
    }

    public static class Signed_numberContext extends ParserRuleContext {
        public Signed_numberContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode NUMERIC_LITERAL() {
            return getToken(155, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitSigned_number(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterSigned_number(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitSigned_number(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 56;
        }
    }

    public static class Sql_stmtContext extends ParserRuleContext {
        public Sql_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_EXPLAIN() {
            return getToken(73, 0);
        }

        public TerminalNode K_PLAN() {
            return getToken(113, 0);
        }

        public TerminalNode K_QUERY() {
            return getToken(116, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitSql_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        public Alter_table_stmtContext alter_table_stmt() {
            return (Alter_table_stmtContext) getRuleContext(Alter_table_stmtContext.class, 0);
        }

        public Analyze_stmtContext analyze_stmt() {
            return (Analyze_stmtContext) getRuleContext(Analyze_stmtContext.class, 0);
        }

        public Attach_stmtContext attach_stmt() {
            return (Attach_stmtContext) getRuleContext(Attach_stmtContext.class, 0);
        }

        public Begin_stmtContext begin_stmt() {
            return (Begin_stmtContext) getRuleContext(Begin_stmtContext.class, 0);
        }

        public Commit_stmtContext commit_stmt() {
            return (Commit_stmtContext) getRuleContext(Commit_stmtContext.class, 0);
        }

        public Create_index_stmtContext create_index_stmt() {
            return (Create_index_stmtContext) getRuleContext(Create_index_stmtContext.class, 0);
        }

        public Create_table_stmtContext create_table_stmt() {
            return (Create_table_stmtContext) getRuleContext(Create_table_stmtContext.class, 0);
        }

        public Create_trigger_stmtContext create_trigger_stmt() {
            return (Create_trigger_stmtContext) getRuleContext(Create_trigger_stmtContext.class, 0);
        }

        public Create_view_stmtContext create_view_stmt() {
            return (Create_view_stmtContext) getRuleContext(Create_view_stmtContext.class, 0);
        }

        public Create_virtual_table_stmtContext create_virtual_table_stmt() {
            return (Create_virtual_table_stmtContext) getRuleContext(Create_virtual_table_stmtContext.class, 0);
        }

        public Delete_stmtContext delete_stmt() {
            return (Delete_stmtContext) getRuleContext(Delete_stmtContext.class, 0);
        }

        public Delete_stmt_limitedContext delete_stmt_limited() {
            return (Delete_stmt_limitedContext) getRuleContext(Delete_stmt_limitedContext.class, 0);
        }

        public Detach_stmtContext detach_stmt() {
            return (Detach_stmtContext) getRuleContext(Detach_stmtContext.class, 0);
        }

        public Drop_index_stmtContext drop_index_stmt() {
            return (Drop_index_stmtContext) getRuleContext(Drop_index_stmtContext.class, 0);
        }

        public Drop_table_stmtContext drop_table_stmt() {
            return (Drop_table_stmtContext) getRuleContext(Drop_table_stmtContext.class, 0);
        }

        public Drop_trigger_stmtContext drop_trigger_stmt() {
            return (Drop_trigger_stmtContext) getRuleContext(Drop_trigger_stmtContext.class, 0);
        }

        public Drop_view_stmtContext drop_view_stmt() {
            return (Drop_view_stmtContext) getRuleContext(Drop_view_stmtContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterSql_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitSql_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 3;
        }

        public Insert_stmtContext insert_stmt() {
            return (Insert_stmtContext) getRuleContext(Insert_stmtContext.class, 0);
        }

        public Pragma_stmtContext pragma_stmt() {
            return (Pragma_stmtContext) getRuleContext(Pragma_stmtContext.class, 0);
        }

        public Reindex_stmtContext reindex_stmt() {
            return (Reindex_stmtContext) getRuleContext(Reindex_stmtContext.class, 0);
        }

        public Release_stmtContext release_stmt() {
            return (Release_stmtContext) getRuleContext(Release_stmtContext.class, 0);
        }

        public Rollback_stmtContext rollback_stmt() {
            return (Rollback_stmtContext) getRuleContext(Rollback_stmtContext.class, 0);
        }

        public Savepoint_stmtContext savepoint_stmt() {
            return (Savepoint_stmtContext) getRuleContext(Savepoint_stmtContext.class, 0);
        }

        public Select_stmtContext select_stmt() {
            return (Select_stmtContext) getRuleContext(Select_stmtContext.class, 0);
        }

        public Update_stmtContext update_stmt() {
            return (Update_stmtContext) getRuleContext(Update_stmtContext.class, 0);
        }

        public Update_stmt_limitedContext update_stmt_limited() {
            return (Update_stmt_limitedContext) getRuleContext(Update_stmt_limitedContext.class, 0);
        }

        public Vacuum_stmtContext vacuum_stmt() {
            return (Vacuum_stmtContext) getRuleContext(Vacuum_stmtContext.class, 0);
        }
    }

    public static class Sql_stmt_listContext extends ParserRuleContext {
        public Sql_stmt_listContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitSql_stmt_list(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterSql_stmt_list(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitSql_stmt_list(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 2;
        }

        public List<Sql_stmtContext> sql_stmt() {
            return getRuleContexts(Sql_stmtContext.class);
        }

        public Sql_stmtContext sql_stmt(int r5) {
            return (Sql_stmtContext) getRuleContext(Sql_stmtContext.class, r5);
        }
    }

    public static class Table_aliasContext extends ParserRuleContext {
        public Table_aliasContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode IDENTIFIER() {
            return getToken(154, 0);
        }

        public TerminalNode STRING_LITERAL() {
            return getToken(157, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitTable_alias(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterTable_alias(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitTable_alias(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 82;
        }

        public Table_aliasContext table_alias() {
            return (Table_aliasContext) getRuleContext(Table_aliasContext.class, 0);
        }
    }

    public static class Table_constraintContext extends ParserRuleContext {
        public Table_constraintContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_CHECK() {
            return getToken(46, 0);
        }

        public TerminalNode K_CONSTRAINT() {
            return getToken(51, 0);
        }

        public TerminalNode K_FOREIGN() {
            return getToken(76, 0);
        }

        public TerminalNode K_KEY() {
            return getToken(97, 0);
        }

        public TerminalNode K_PRIMARY() {
            return getToken(115, 0);
        }

        public TerminalNode K_UNIQUE() {
            return getToken(140, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitTable_constraint(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Column_nameContext> column_name() {
            return getRuleContexts(Column_nameContext.class);
        }

        public Conflict_clauseContext conflict_clause() {
            return (Conflict_clauseContext) getRuleContext(Conflict_clauseContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterTable_constraint(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitTable_constraint(this);
            return;
        }

        public ExprContext expr() {
            return (ExprContext) getRuleContext(ExprContext.class, 0);
        }

        public Foreign_key_clauseContext foreign_key_clause() {
            return (Foreign_key_clauseContext) getRuleContext(Foreign_key_clauseContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 42;
        }

        public List<Indexed_columnContext> indexed_column() {
            return getRuleContexts(Indexed_columnContext.class);
        }

        public NameContext name() {
            return (NameContext) getRuleContext(NameContext.class, 0);
        }

        public Column_nameContext column_name(int r5) {
            return (Column_nameContext) getRuleContext(Column_nameContext.class, r5);
        }

        public Indexed_columnContext indexed_column(int r5) {
            return (Indexed_columnContext) getRuleContext(Indexed_columnContext.class, r5);
        }
    }

    public static class Table_functionContext extends ParserRuleContext {
        public Table_functionContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitTable_function(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterTable_function(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitTable_function(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 69;
        }
    }

    public static class Table_nameContext extends ParserRuleContext {
        public Table_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitTable_name(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterTable_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitTable_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 70;
        }
    }

    public static class Table_or_index_nameContext extends ParserRuleContext {
        public Table_or_index_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitTable_or_index_name(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterTable_or_index_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitTable_or_index_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 71;
        }
    }

    public static class Table_or_subqueryContext extends ParserRuleContext {
        public Table_or_subqueryContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_AS() {
            return getToken(35, 0);
        }

        public TerminalNode K_BY() {
            return getToken(42, 0);
        }

        public TerminalNode K_INDEXED() {
            return getToken(87, 0);
        }

        public TerminalNode K_NOT() {
            return getToken(104, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitTable_or_subquery(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterTable_or_subquery(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitTable_or_subquery(this);
            return;
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 51;
        }

        public Index_nameContext index_name() {
            return (Index_nameContext) getRuleContext(Index_nameContext.class, 0);
        }

        public Join_clauseContext join_clause() {
            return (Join_clauseContext) getRuleContext(Join_clauseContext.class, 0);
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }

        public Select_stmtContext select_stmt() {
            return (Select_stmtContext) getRuleContext(Select_stmtContext.class, 0);
        }

        public Table_aliasContext table_alias() {
            return (Table_aliasContext) getRuleContext(Table_aliasContext.class, 0);
        }

        public Table_functionContext table_function() {
            return (Table_functionContext) getRuleContext(Table_functionContext.class, 0);
        }

        public Table_nameContext table_name() {
            return (Table_nameContext) getRuleContext(Table_nameContext.class, 0);
        }

        public List<Table_or_subqueryContext> table_or_subquery() {
            return getRuleContexts(Table_or_subqueryContext.class);
        }

        public ExprContext expr(int r5) {
            return (ExprContext) getRuleContext(ExprContext.class, r5);
        }

        public Table_or_subqueryContext table_or_subquery(int r5) {
            return (Table_or_subqueryContext) getRuleContext(Table_or_subqueryContext.class, r5);
        }
    }

    public static class Transaction_nameContext extends ParserRuleContext {
        public Transaction_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitTransaction_name(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterTransaction_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitTransaction_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 83;
        }
    }

    public static class Trigger_nameContext extends ParserRuleContext {
        public Trigger_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitTrigger_name(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterTrigger_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitTrigger_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 77;
        }
    }

    public static class Type_nameContext extends ParserRuleContext {
        public Type_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitType_name(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterType_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitType_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 34;
        }

        public List<NameContext> name() {
            return getRuleContexts(NameContext.class);
        }

        public List<Signed_numberContext> signed_number() {
            return getRuleContexts(Signed_numberContext.class);
        }

        public NameContext name(int r5) {
            return (NameContext) getRuleContext(NameContext.class, r5);
        }

        public Signed_numberContext signed_number(int r5) {
            return (Signed_numberContext) getRuleContext(Signed_numberContext.class, r5);
        }
    }

    public static class Unary_operatorContext extends ParserRuleContext {
        public Unary_operatorContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_NOT() {
            return getToken(104, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitUnary_operator(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterUnary_operator(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitUnary_operator(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 59;
        }
    }

    public static class Update_stmtContext extends ParserRuleContext {
        public Update_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_ABORT() {
            return getToken(27, 0);
        }

        public TerminalNode K_FAIL() {
            return getToken(74, 0);
        }

        public TerminalNode K_IGNORE() {
            return getToken(83, 0);
        }

        public TerminalNode K_OR() {
            return getToken(110, 0);
        }

        public TerminalNode K_REPLACE() {
            return getToken(124, 0);
        }

        public TerminalNode K_ROLLBACK() {
            return getToken(127, 0);
        }

        public TerminalNode K_SET() {
            return getToken(131, 0);
        }

        public TerminalNode K_UPDATE() {
            return getToken(141, 0);
        }

        public TerminalNode K_WHERE() {
            return getToken(148, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitUpdate_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Column_nameContext> column_name() {
            return getRuleContexts(Column_nameContext.class);
        }

        public List<Column_name_listContext> column_name_list() {
            return getRuleContexts(Column_name_listContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterUpdate_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitUpdate_stmt(this);
            return;
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 30;
        }

        public Qualified_table_nameContext qualified_table_name() {
            return (Qualified_table_nameContext) getRuleContext(Qualified_table_nameContext.class, 0);
        }

        public With_clauseContext with_clause() {
            return (With_clauseContext) getRuleContext(With_clauseContext.class, 0);
        }

        public Column_nameContext column_name(int r5) {
            return (Column_nameContext) getRuleContext(Column_nameContext.class, r5);
        }

        public Column_name_listContext column_name_list(int r5) {
            return (Column_name_listContext) getRuleContext(Column_name_listContext.class, r5);
        }

        public ExprContext expr(int r5) {
            return (ExprContext) getRuleContext(ExprContext.class, r5);
        }
    }

    public static class Update_stmt_limitedContext extends ParserRuleContext {
        public Update_stmt_limitedContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_ABORT() {
            return getToken(27, 0);
        }

        public TerminalNode K_FAIL() {
            return getToken(74, 0);
        }

        public TerminalNode K_IGNORE() {
            return getToken(83, 0);
        }

        public TerminalNode K_OR() {
            return getToken(110, 0);
        }

        public TerminalNode K_REPLACE() {
            return getToken(124, 0);
        }

        public TerminalNode K_ROLLBACK() {
            return getToken(127, 0);
        }

        public TerminalNode K_SET() {
            return getToken(131, 0);
        }

        public TerminalNode K_UPDATE() {
            return getToken(141, 0);
        }

        public TerminalNode K_WHERE() {
            return getToken(148, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitUpdate_stmt_limited(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Column_nameContext> column_name() {
            return getRuleContexts(Column_nameContext.class);
        }

        public List<Column_name_listContext> column_name_list() {
            return getRuleContexts(Column_name_listContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterUpdate_stmt_limited(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitUpdate_stmt_limited(this);
            return;
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 31;
        }

        public Limit_clauseContext limit_clause() {
            return (Limit_clauseContext) getRuleContext(Limit_clauseContext.class, 0);
        }

        public Order_clauseContext order_clause() {
            return (Order_clauseContext) getRuleContext(Order_clauseContext.class, 0);
        }

        public Qualified_table_nameContext qualified_table_name() {
            return (Qualified_table_nameContext) getRuleContext(Qualified_table_nameContext.class, 0);
        }

        public With_clauseContext with_clause() {
            return (With_clauseContext) getRuleContext(With_clauseContext.class, 0);
        }

        public Column_nameContext column_name(int r5) {
            return (Column_nameContext) getRuleContext(Column_nameContext.class, r5);
        }

        public Column_name_listContext column_name_list(int r5) {
            return (Column_name_listContext) getRuleContext(Column_name_listContext.class, r5);
        }

        public ExprContext expr(int r5) {
            return (ExprContext) getRuleContext(ExprContext.class, r5);
        }
    }

    public static class Upsert_clauseContext extends ParserRuleContext {
        public Upsert_clauseContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode DO_NOTHING() {
            return getToken(152, 0);
        }

        public TerminalNode DO_UPDATE() {
            return getToken(153, 0);
        }

        public TerminalNode K_CONFLICT() {
            return getToken(50, 0);
        }

        public TerminalNode K_ON() {
            return getToken(109, 0);
        }

        public TerminalNode K_SET() {
            return getToken(131, 0);
        }

        public List<TerminalNode> K_WHERE() {
            return getTokens(148);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitUpsert_clause(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Column_nameContext> column_name() {
            return getRuleContexts(Column_nameContext.class);
        }

        public List<Column_name_listContext> column_name_list() {
            return getRuleContexts(Column_name_listContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterUpsert_clause(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitUpsert_clause(this);
            return;
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 22;
        }

        public List<Indexed_columnContext> indexed_column() {
            return getRuleContexts(Indexed_columnContext.class);
        }

        public TerminalNode K_WHERE(int r5) {
            return getToken(148, r5);
        }

        public Column_nameContext column_name(int r5) {
            return (Column_nameContext) getRuleContext(Column_nameContext.class, r5);
        }

        public Column_name_listContext column_name_list(int r5) {
            return (Column_name_listContext) getRuleContext(Column_name_listContext.class, r5);
        }

        public ExprContext expr(int r5) {
            return (ExprContext) getRuleContext(ExprContext.class, r5);
        }

        public Indexed_columnContext indexed_column(int r5) {
            return (Indexed_columnContext) getRuleContext(Indexed_columnContext.class, r5);
        }
    }

    public static class Vacuum_stmtContext extends ParserRuleContext {
        public Vacuum_stmtContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_VACUUM() {
            return getToken(143, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitVacuum_stmt(this);
        L7:
            return r5.visitChildren(this);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterVacuum_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitVacuum_stmt(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 32;
        }

        public Schema_nameContext schema_name() {
            return (Schema_nameContext) getRuleContext(Schema_nameContext.class, 0);
        }
    }

    public static class View_nameContext extends ParserRuleContext {
        public View_nameContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitView_name(this);
        L7:
            return r5.visitChildren(this);
        }

        public Any_nameContext any_name() {
            return (Any_nameContext) getRuleContext(Any_nameContext.class, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterView_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitView_name(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 78;
        }
    }

    public static class With_clauseContext extends ParserRuleContext {
        public With_clauseContext(ParserRuleContext r5, int r10) {
            super(r5, r10);
        }

        public TerminalNode K_RECURSIVE() {
            return getToken(118, 0);
        }

        public TerminalNode K_WITH() {
            return getToken(149, 0);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
        public <T> T accept(ParseTreeVisitor<? extends T> r5) {
            if ((r5 instanceof SQLiteVisitor) == false) goto L7;
            return (T) ((SQLiteVisitor) r5).visitWith_clause(this);
        L7:
            return r5.visitChildren(this);
        }

        public List<Common_table_expressionContext> common_table_expression() {
            return getRuleContexts(Common_table_expressionContext.class);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void enterRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).enterWith_clause(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext
        public void exitRule(ParseTreeListener r5) {
            if ((r5 instanceof SQLiteListener) == false) goto L6;
            ((SQLiteListener) r5).exitWith_clause(this);
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext
        public int getRuleIndex() {
            return 43;
        }

        public Common_table_expressionContext common_table_expression(int r5) {
            return (Common_table_expressionContext) getRuleContext(Common_table_expressionContext.class, r5);
        }
    }

    static {
        RuntimeMetaData.checkVersion(RuntimeMetaData.VERSION, RuntimeMetaData.VERSION);
        _sharedContextCache = new PredictionContextCache();
        ruleNames = new String[]{"parse", "error", "sql_stmt_list", "sql_stmt", "alter_table_stmt", "analyze_stmt", "attach_stmt", "begin_stmt", "commit_stmt", "create_index_stmt", "create_table_stmt", "create_trigger_stmt", "create_view_stmt", "create_virtual_table_stmt", "delete_stmt", "delete_stmt_limited", "detach_stmt", "drop_index_stmt", "drop_table_stmt", "drop_trigger_stmt", "drop_view_stmt", "insert_stmt", "upsert_clause", "pragma_stmt", "reindex_stmt", "release_stmt", "rollback_stmt", "savepoint_stmt", "select_stmt", "select_or_values", "update_stmt", "update_stmt_limited", "vacuum_stmt", "column_def", "type_name", "column_constraint", "conflict_clause", "expr", "comma_separated_expr", "foreign_key_clause", "raise_function", "indexed_column", "table_constraint", "with_clause", "common_table_expression", "qualified_table_name", "order_clause", "ordering_term", "limit_clause", "pragma_value", "result_column", "table_or_subquery", "join_clause", "join_operator", "join_constraint", "compound_operator", "signed_number", "literal_value", "boolean_literal", "unary_operator", "binary_operator", "error_message", "module_argument", "column_alias", "column_name_list", "keyword", "name", "function_name", "schema_name", "table_function", "table_name", "table_or_index_name", "new_table_name", "column_name", "collation_name", "foreign_table", "index_name", "trigger_name", "view_name", "module_name", "pragma_name", "savepoint_name", "table_alias", "transaction_name", "any_name"};
        String[] r5 = {null, "';'", "'.'", "'('", "')'", "','", "'='", "'*'", "'+'", "'-'", "'~'", "'||'", "'/'", "'%'", "'<<'", "'>>'", "'&'", "'|'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'<>'"};
        _LITERAL_NAMES = r5;
        String[] r10 = {null, "SCOL", "DOT", "OPEN_PAR", "CLOSE_PAR", "COMMA", "ASSIGN", "STAR", "PLUS", "MINUS", "TILDE", "PIPE2", "DIV", "MOD", "LT2", "GT2", "AMP", "PIPE", "LT", "LT_EQ", "GT", "GT_EQ", "EQ", "NOT_EQ1", "NOT_EQ2", "TRUE", "FALSE", "K_ABORT", "K_ACTION", "K_ADD", "K_AFTER", "K_ALL", "K_ALTER", "K_ANALYZE", "K_AND", "K_AS", "K_ASC", "K_ATTACH", "K_AUTOINCREMENT", "K_BEFORE", "K_BEGIN", "K_BETWEEN", "K_BY", "K_CASCADE", "K_CASE", "K_CAST", "K_CHECK", "K_COLLATE", "K_COLUMN", "K_COMMIT", "K_CONFLICT", "K_CONSTRAINT", "K_CREATE", "K_CROSS", "K_CURRENT_DATE", "K_CURRENT_TIME", "K_CURRENT_TIMESTAMP", "K_DATABASE", "K_DEFAULT", "K_DEFERRABLE", "K_DEFERRED", "K_DELETE", "K_DESC", "K_DETACH", "K_DISTINCT", "K_DROP", "K_EACH", "K_ELSE", "K_END", "K_ESCAPE", "K_EXCEPT", "K_EXCLUSIVE", "K_EXISTS", "K_EXPLAIN", "K_FAIL", "K_FOR", "K_FOREIGN", "K_FROM", "K_FULL", "K_GLOB", "K_GROUP", "K_HAVING", "K_IF", "K_IGNORE", "K_IMMEDIATE", "K_IN", "K_INDEX", "K_INDEXED", "K_INITIALLY", "K_INNER", "K_INSERT", "K_INSTEAD", "K_INTERSECT", "K_INTO", "K_IS", "K_ISNULL", "K_JOIN", "K_KEY", "K_LEFT", "K_LIKE", "K_LIMIT", "K_MATCH", "K_NATURAL", "K_NO", "K_NOT", "K_NOTNULL", "K_NULL", "K_OF", "K_OFFSET", "K_ON", "K_OR", "K_ORDER", "K_OUTER", "K_PLAN", "K_PRAGMA", "K_PRIMARY", "K_QUERY", "K_RAISE", "K_RECURSIVE", "K_REFERENCES", "K_REGEXP", "K_REINDEX", "K_RELEASE", "K_RENAME", "K_REPLACE", "K_RESTRICT", "K_RIGHT", "K_ROLLBACK", "K_ROW", "K_SAVEPOINT", "K_SELECT", "K_SET", "K_TABLE", "K_TEMP", "K_TEMPORARY", "K_THEN", "K_TO", "K_TRANSACTION", "K_TRIGGER", "K_UNION", "K_UNIQUE", "K_UPDATE", "K_USING", "K_VACUUM", "K_VALUES", "K_VIEW", "K_VIRTUAL", "K_WHEN", "K_WHERE", "K_WITH", "K_WITHOUT", "WITHOUT_ROWID", "DO_NOTHING", "DO_UPDATE", "IDENTIFIER", "NUMERIC_LITERAL", "BIND_PARAMETER", "STRING_LITERAL", "BLOB_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", "UNEXPECTED_CHAR"};
        _SYMBOLIC_NAMES = r10;
        VOCABULARY = new VocabularyImpl(r5, r10);
        tokenNames = new String[r10.length];
        int r11 = 0;
        int r12 = 0;
    L3:
        String[] r13 = tokenNames;
        if (r12 >= r13.length) goto L12;
        Vocabulary r14 = VOCABULARY;
        String r15 = r14.getLiteralName(r12);
        r13[r12] = r15;
        if (r15 != null) goto L9;
        r13[r12] = r14.getSymbolicName(r12);
    L9:
        if (r13[r12] != null) goto L11;
        r13[r12] = Grammar.INVALID_TOKEN_NAME;
    L11:
        r12 = r12 + 1;
        goto L3
    L12:
        ATN r16 = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
        _ATN = r16;
        _decisionToDFA = new DFA[r16.getNumberOfDecisions()];
    L13:
        ATN r17 = _ATN;
        if (r11 >= r17.getNumberOfDecisions()) goto L16;
        _decisionToDFA[r11] = new DFA(r17.getDecisionState(r11), r11);
        r11 = r11 + 1;
        goto L13
    }

    public SQLiteParser(TokenStream r5) {
        super(r5);
        this._interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private boolean expr_sempred(ExprContext r5, int r10) {
        switch(r10) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return true;
    L6:
        return precpred(this._ctx, 4);
    L8:
        return precpred(this._ctx, 7);
    L10:
        return precpred(this._ctx, 8);
    L12:
        return precpred(this._ctx, 9);
    L14:
        return precpred(this._ctx, 5);
    L16:
        return precpred(this._ctx, 6);
    L18:
        return precpred(this._ctx, 13);
    }

    public final Alter_table_stmtContext alter_table_stmt() throws RecognitionException {
        Alter_table_stmtContext r5 = new Alter_table_stmtContext(this._ctx, getState());
        enterRule(r5, 8, 4);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(242);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(32);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(243);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(132);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(247);     // Catch: Throwable -> L12 RecognitionException -> L14
        this._errHandler.sync(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 9, this._ctx) != 1) goto L7;
        setState(244);     // Catch: Throwable -> L12 RecognitionException -> L14
        schema_name();     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(245);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(2);     // Catch: Throwable -> L12 RecognitionException -> L14
    L7:
        setState(249);     // Catch: Throwable -> L12 RecognitionException -> L14
        table_name();     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(258);     // Catch: Throwable -> L12 RecognitionException -> L14
        this._errHandler.sync(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r10 = this._input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r10 != 29) goto L10;
        setState(253);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(29);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(255);     // Catch: Throwable -> L12 RecognitionException -> L14
        this._errHandler.sync(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 10, this._ctx) != 1) goto L22;
        setState(254);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(48);     // Catch: Throwable -> L12 RecognitionException -> L14
    L22:
        setState(257);     // Catch: Throwable -> L12 RecognitionException -> L14
        column_def();     // Catch: Throwable -> L12 RecognitionException -> L14
    L23:
        exitRule();
        return r5;
    L10:
        if (r10 != 123) goto L17;
        setState(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(123);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(251);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(136);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(252);     // Catch: Throwable -> L12 RecognitionException -> L14
        new_table_name();     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L23
    L17:
        throw new NoViableAltException(this);     // Catch: Throwable -> L12 RecognitionException -> L14
    L12:
        th = move-exception;
        exitRule();
        throw th;
    L14:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L12
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L12
        this._errHandler.recover(this, e);     // Catch: Throwable -> L12
        goto L23
    }

    public final Analyze_stmtContext analyze_stmt() throws RecognitionException {
        Analyze_stmtContext r5 = new Analyze_stmtContext(this._ctx, getState());
        enterRule(r5, 10, 5);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L11 RecognitionException -> L13
        setState(260);     // Catch: Throwable -> L11 RecognitionException -> L13
        match(33);     // Catch: Throwable -> L11 RecognitionException -> L13
        setState(267);     // Catch: Throwable -> L11 RecognitionException -> L13
        this._errHandler.sync(this);     // Catch: Throwable -> L11 RecognitionException -> L13
        int r10 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 12, this._ctx);     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r10 != 1) goto L6;
        setState(261);     // Catch: Throwable -> L11 RecognitionException -> L13
        schema_name();     // Catch: Throwable -> L11 RecognitionException -> L13
    L23:
    L17:
        exitRule();
        return r5;
    L6:
        if (r10 != 2) goto L8;
        setState(262);     // Catch: Throwable -> L11 RecognitionException -> L13
        table_or_index_name();     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L23
    L8:
        if (r10 != 3) goto L23;
        setState(263);     // Catch: Throwable -> L11 RecognitionException -> L13
        schema_name();     // Catch: Throwable -> L11 RecognitionException -> L13
        setState(264);     // Catch: Throwable -> L11 RecognitionException -> L13
        match(2);     // Catch: Throwable -> L11 RecognitionException -> L13
        setState(265);     // Catch: Throwable -> L11 RecognitionException -> L13
        table_or_index_name();     // Catch: Throwable -> L11 RecognitionException -> L13
    L13:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L11
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L11
        this._errHandler.recover(this, e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Any_nameContext any_name() throws RecognitionException {
        Any_nameContext r5 = new Any_nameContext(this._ctx, getState());
        enterRule(r5, 168, 84);
        setState(1550);     // Catch: Throwable -> L12 RecognitionException -> L14
        this._errHandler.sync(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r10 = this._input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r10 != 3) goto L6;
        enterOuterAlt(r5, 4);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1546);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(3);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1547);     // Catch: Throwable -> L12 RecognitionException -> L14
        any_name();     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1548);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(4);     // Catch: Throwable -> L12 RecognitionException -> L14
    L20:
        exitRule();
        return r5;
    L6:
        if (r10 != 154) goto L8;
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1543);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(154);     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L20
    L8:
        if (r10 == 157) goto L17;
        switch(r10) {
            case 27: goto L16;
            case 28: goto L16;
            case 29: goto L16;
            case 30: goto L16;
            case 31: goto L16;
            case 32: goto L16;
            case 33: goto L16;
            case 34: goto L16;
            case 35: goto L16;
            case 36: goto L16;
            case 37: goto L16;
            case 38: goto L16;
            case 39: goto L16;
            case 40: goto L16;
            case 41: goto L16;
            case 42: goto L16;
            case 43: goto L16;
            case 44: goto L16;
            case 45: goto L16;
            case 46: goto L16;
            case 47: goto L16;
            case 48: goto L16;
            case 49: goto L16;
            case 50: goto L16;
            case 51: goto L16;
            case 52: goto L16;
            case 53: goto L16;
            case 54: goto L16;
            case 55: goto L16;
            case 56: goto L16;
            case 57: goto L16;
            case 58: goto L16;
            case 59: goto L16;
            case 60: goto L16;
            case 61: goto L16;
            case 62: goto L16;
            case 63: goto L16;
            case 64: goto L16;
            case 65: goto L16;
            case 66: goto L16;
            case 67: goto L16;
            case 68: goto L16;
            case 69: goto L16;
            case 70: goto L16;
            case 71: goto L16;
            case 72: goto L16;
            case 73: goto L16;
            case 74: goto L16;
            case 75: goto L16;
            case 76: goto L16;
            case 77: goto L16;
            case 78: goto L16;
            case 79: goto L16;
            case 80: goto L16;
            case 81: goto L16;
            case 82: goto L16;
            case 83: goto L16;
            case 84: goto L16;
            case 85: goto L16;
            case 86: goto L16;
            case 87: goto L16;
            case 88: goto L16;
            case 89: goto L16;
            case 90: goto L16;
            case 91: goto L16;
            case 92: goto L16;
            case 93: goto L16;
            case 94: goto L16;
            case 95: goto L16;
            case 96: goto L16;
            case 97: goto L16;
            case 98: goto L16;
            case 99: goto L16;
            case 100: goto L16;
            case 101: goto L16;
            case 102: goto L16;
            case 103: goto L16;
            case 104: goto L16;
            case 105: goto L16;
            case 106: goto L16;
            case 107: goto L16;
            case 108: goto L16;
            case 109: goto L16;
            case 110: goto L16;
            case 111: goto L16;
            case 112: goto L16;
            case 113: goto L16;
            case 114: goto L16;
            case 115: goto L16;
            case 116: goto L16;
            case 117: goto L16;
            case 118: goto L16;
            case 119: goto L16;
            case 120: goto L16;
            case 121: goto L16;
            case 122: goto L16;
            case 123: goto L16;
            case 124: goto L16;
            case 125: goto L16;
            case 126: goto L16;
            case 127: goto L16;
            case 128: goto L16;
            case 129: goto L16;
            case 130: goto L16;
            case 131: goto L16;
            case 132: goto L16;
            case 133: goto L16;
            case 134: goto L16;
            case 135: goto L16;
            case 136: goto L16;
            case 137: goto L16;
            case 138: goto L16;
            case 139: goto L16;
            case 140: goto L16;
            case 141: goto L16;
            case 142: goto L16;
            case 143: goto L16;
            case 144: goto L16;
            case 145: goto L16;
            case 146: goto L16;
            case 147: goto L16;
            case 148: goto L16;
            case 149: goto L16;
            case 150: goto L16;
            default: goto L11;
        };     // Catch: Throwable -> L12 RecognitionException -> L14
    L16:
        enterOuterAlt(r5, 2);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1544);     // Catch: Throwable -> L12 RecognitionException -> L14
        keyword();     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L20
    L11:
        throw new NoViableAltException(this);     // Catch: Throwable -> L12 RecognitionException -> L14
    L17:
        enterOuterAlt(r5, 3);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1545);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(157);     // Catch: Throwable -> L12 RecognitionException -> L14
    L14:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L12
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L12
        this._errHandler.recover(this, e);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Attach_stmtContext attach_stmt() throws RecognitionException {
        Attach_stmtContext r5 = new Attach_stmtContext(this._ctx, getState());
        enterRule(r5, 12, 6);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(269);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(37);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(271);     // Catch: Throwable -> L9 RecognitionException -> L11
        this._errHandler.sync(this);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 13, this._ctx) != 1) goto L7;
        setState(270);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(57);     // Catch: Throwable -> L9 RecognitionException -> L11
    L7:
        setState(273);     // Catch: Throwable -> L9 RecognitionException -> L11
        expr(0);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(274);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(35);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(275);     // Catch: Throwable -> L9 RecognitionException -> L11
        schema_name();     // Catch: Throwable -> L9 RecognitionException -> L11
    L8:
        exitRule();
        return r5;
    L11:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L9
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L9
        this._errHandler.recover(this, e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Begin_stmtContext begin_stmt() throws RecognitionException {
        Begin_stmtContext r5 = new Begin_stmtContext(this._ctx, getState());
        enterRule(r5, 14, 7);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L15 RecognitionException -> L17
        setState(277);     // Catch: Throwable -> L15 RecognitionException -> L17
        match(40);     // Catch: Throwable -> L15 RecognitionException -> L17
        setState(279);     // Catch: Throwable -> L15 RecognitionException -> L17
        this._errHandler.sync(this);     // Catch: Throwable -> L15 RecognitionException -> L17
        int r10 = this._input.LA(1) - 60;     // Catch: Throwable -> L15 RecognitionException -> L17
        if ((r10 & (-64)) == 0) goto L6;
    L21:
        setState(285);     // Catch: Throwable -> L15 RecognitionException -> L17
        this._errHandler.sync(this);     // Catch: Throwable -> L15 RecognitionException -> L17
        if (this._input.LA(1) != 137) goto L27;
        setState(281);     // Catch: Throwable -> L15 RecognitionException -> L17
        match(137);     // Catch: Throwable -> L15 RecognitionException -> L17
        setState(283);     // Catch: Throwable -> L15 RecognitionException -> L17
        this._errHandler.sync(this);     // Catch: Throwable -> L15 RecognitionException -> L17
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 15, this._ctx) != 1) goto L27;
        setState(282);     // Catch: Throwable -> L15 RecognitionException -> L17
        transaction_name();     // Catch: Throwable -> L15 RecognitionException -> L17
    L27:
        exitRule();
        return r5;
    L6:
        if (((1 << r10) & 16779265) == 0) goto L21;
        setState(278);     // Catch: Throwable -> L15 RecognitionException -> L17
        int r11 = this._input.LA(1) - 60;     // Catch: Throwable -> L15 RecognitionException -> L17
        if ((r11 & (-64)) == 0) goto L10;
    L20:
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L15 RecognitionException -> L17
        goto L21
    L10:
        if (((1 << r11) & 16779265) == 0) goto L20;
        if (this._input.LA(1) != (-1)) goto L19;
        this.matchedEOF = true;     // Catch: Throwable -> L15 RecognitionException -> L17
    L19:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L15 RecognitionException -> L17
        consume();     // Catch: Throwable -> L15 RecognitionException -> L17
    L17:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L15
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L15
        this._errHandler.recover(this, e);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Binary_operatorContext binary_operator() throws RecognitionException {
        Binary_operatorContext r5 = new Binary_operatorContext(this._ctx, getState());
        enterRule(r5, 120, 60);
        setState(1478);     // Catch: Throwable -> L12 RecognitionException -> L14
        this._errHandler.sync(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r10 = this._input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r10 != 34) goto L6;
        enterOuterAlt(r5, 7);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1476);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(34);     // Catch: Throwable -> L12 RecognitionException -> L14
    L68:
        exitRule();
        return r5;
    L6:
        if (r10 != 110) goto L8;
        enterOuterAlt(r5, 8);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1477);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(110);     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L68
    L8:
        switch(r10) {
            case 6: goto L56;
            case 7: goto L46;
            case 8: goto L37;
            case 9: goto L37;
            default: goto L9;
        };     // Catch: Throwable -> L12 RecognitionException -> L14
    L9:
        switch(r10) {
            case 11: goto L36;
            case 12: goto L46;
            case 13: goto L46;
            case 14: goto L26;
            case 15: goto L26;
            case 16: goto L26;
            case 17: goto L26;
            case 18: goto L16;
            case 19: goto L16;
            case 20: goto L16;
            case 21: goto L16;
            case 22: goto L56;
            case 23: goto L56;
            case 24: goto L56;
            default: goto L11;
        };     // Catch: Throwable -> L12 RecognitionException -> L14
    L16:
        enterOuterAlt(r5, 5);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1474);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r11 = this._input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if ((r11 & (-64)) == 0) goto L19;
    L25:
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L68
    L19:
        if (((1 << r11) & 3932160) == 0) goto L25;
        if (this._input.LA(1) != (-1)) goto L24;
        this.matchedEOF = true;     // Catch: Throwable -> L12 RecognitionException -> L14
    L24:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        consume();     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L68
    L26:
        enterOuterAlt(r5, 4);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1473);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r12 = this._input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if ((r12 & (-64)) == 0) goto L29;
    L35:
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L68
    L29:
        if (((1 << r12) & 245760) == 0) goto L35;
        if (this._input.LA(1) != (-1)) goto L34;
        this.matchedEOF = true;     // Catch: Throwable -> L12 RecognitionException -> L14
    L34:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        consume();     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L68
    L36:
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1470);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(11);     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L68
    L11:
        throw new NoViableAltException(this);     // Catch: Throwable -> L12 RecognitionException -> L14
    L37:
        enterOuterAlt(r5, 3);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1472);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r13 = this._input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r13 == 8) goto L43;
        if (r13 == 9) goto L43;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L12 RecognitionException -> L14
    L43:
        if (this._input.LA(1) != (-1)) goto L45;
        this.matchedEOF = true;     // Catch: Throwable -> L12 RecognitionException -> L14
    L45:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        consume();     // Catch: Throwable -> L12 RecognitionException -> L14
    L46:
        enterOuterAlt(r5, 2);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1471);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r14 = this._input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if ((r14 & (-64)) == 0) goto L49;
    L55:
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L68
    L49:
        if (((1 << r14) & 12416) == 0) goto L55;
        if (this._input.LA(1) != (-1)) goto L54;
        this.matchedEOF = true;     // Catch: Throwable -> L12 RecognitionException -> L14
    L54:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        consume();     // Catch: Throwable -> L12 RecognitionException -> L14
    L56:
        enterOuterAlt(r5, 6);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1475);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r15 = this._input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if ((r15 & (-64)) == 0) goto L59;
    L65:
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L68
    L59:
        if (((1 << r15) & 29360192) == 0) goto L65;
        if (this._input.LA(1) != (-1)) goto L64;
        this.matchedEOF = true;     // Catch: Throwable -> L12 RecognitionException -> L14
    L64:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        consume();     // Catch: Throwable -> L12 RecognitionException -> L14
    L14:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L12
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L12
        this._errHandler.recover(this, e);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Boolean_literalContext boolean_literal() throws RecognitionException {
        Boolean_literalContext r5 = new Boolean_literalContext(this._ctx, getState());
        enterRule(r5, 116, 58);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1466);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r10 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r10 == 25) goto L13;
        if (r10 == 26) goto L13;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L8 RecognitionException -> L10
    L16:
        exitRule();
        return r5;
    L13:
        if (this._input.LA(1) != (-1)) goto L15;
        this.matchedEOF = true;     // Catch: Throwable -> L8 RecognitionException -> L10
    L15:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        consume();     // Catch: Throwable -> L8 RecognitionException -> L10
    L10:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L8
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L8
        this._errHandler.recover(this, e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Collation_nameContext collation_name() throws RecognitionException {
        Collation_nameContext r5 = new Collation_nameContext(this._ctx, getState());
        enterRule(r5, 148, 74);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1517);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final Column_aliasContext column_alias() throws RecognitionException {
        Column_aliasContext r5 = new Column_aliasContext(this._ctx, getState());
        enterRule(r5, 126, 63);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1486);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r10 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r10 == 154) goto L13;
        if (r10 == 157) goto L13;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L8 RecognitionException -> L10
    L16:
        exitRule();
        return r5;
    L13:
        if (this._input.LA(1) != (-1)) goto L15;
        this.matchedEOF = true;     // Catch: Throwable -> L8 RecognitionException -> L10
    L15:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        consume();     // Catch: Throwable -> L8 RecognitionException -> L10
    L10:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L8
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L8
        this._errHandler.recover(this, e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Column_constraintContext column_constraint() throws RecognitionException {
        Column_constraintContext r5 = new Column_constraintContext(this._ctx, getState());
        enterRule(r5, 70, 35);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(936);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 51) goto L10;
        setState(934);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(51);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(935);     // Catch: Throwable -> L6 RecognitionException -> L8
        name();     // Catch: Throwable -> L6 RecognitionException -> L8
    L10:
        setState(971);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r10 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r10 != 46) goto L13;
        setState(954);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(46);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(955);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(3);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(956);     // Catch: Throwable -> L6 RecognitionException -> L8
        expr(0);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(957);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(4);     // Catch: Throwable -> L6 RecognitionException -> L8
    L58:
        exitRule();
        return r5;
    L13:
        if (r10 != 47) goto L15;
        setState(968);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(47);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(969);     // Catch: Throwable -> L6 RecognitionException -> L8
        collation_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L58
    L15:
        if (r10 != 58) goto L17;
        setState(959);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(58);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(966);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r11 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 131, this._ctx);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r11 != 1) goto L50;
        setState(960);     // Catch: Throwable -> L6 RecognitionException -> L8
        signed_number();     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L58
    L50:
        if (r11 == 2) goto L54;
        if (r11 != 3) goto L58;
        setState(962);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(3);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(963);     // Catch: Throwable -> L6 RecognitionException -> L8
        expr(0);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(964);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(4);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L58
    L54:
        setState(961);     // Catch: Throwable -> L6 RecognitionException -> L8
        literal_value();     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L58
    L17:
        if (r10 == 104) goto L43;
        if (r10 == 106) goto L43;
        if (r10 != 115) goto L22;
        setState(938);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(115);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(939);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(97);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(941);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r12 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r12 == 36) goto L32;
        if (r12 == 62) goto L32;
    L40:
        setState(943);     // Catch: Throwable -> L6 RecognitionException -> L8
        conflict_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(945);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 38) goto L58;
        setState(944);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(38);     // Catch: Throwable -> L6 RecognitionException -> L8
    L32:
        setState(940);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r13 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r13 == 36) goto L37;
        if (r13 == 62) goto L37;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L6 RecognitionException -> L8
    L37:
        if (this._input.LA(1) != (-1)) goto L39;
        this.matchedEOF = true;     // Catch: Throwable -> L6 RecognitionException -> L8
    L39:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        consume();     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L40
    L22:
        if (r10 != 119) goto L24;
        setState(970);     // Catch: Throwable -> L6 RecognitionException -> L8
        foreign_key_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L58
    L24:
        if (r10 != 140) goto L27;
        setState(952);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(140);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(953);     // Catch: Throwable -> L6 RecognitionException -> L8
        conflict_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L58
    L27:
        throw new NoViableAltException(this);     // Catch: Throwable -> L6 RecognitionException -> L8
    L43:
        setState(948);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 104) goto L46;
        setState(947);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(104);     // Catch: Throwable -> L6 RecognitionException -> L8
    L46:
        setState(950);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(106);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(951);     // Catch: Throwable -> L6 RecognitionException -> L8
        conflict_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
    L6:
        th = move-exception;
        exitRule();
        throw th;
    L8:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L6
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L6
        this._errHandler.recover(this, e);     // Catch: Throwable -> L6
        goto L58
    }

    public final Column_defContext column_def() throws RecognitionException {
        Column_defContext r5 = new Column_defContext(this._ctx, getState());
        enterRule(r5, 66, 33);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(907);     // Catch: Throwable -> L18 RecognitionException -> L20
        column_name();     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(909);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 123, this._ctx) != 1) goto L7;
        setState(908);     // Catch: Throwable -> L18 RecognitionException -> L20
        type_name();     // Catch: Throwable -> L18 RecognitionException -> L20
    L7:
        setState(914);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        int r10 = this._input.LA(1);     // Catch: Throwable -> L18 RecognitionException -> L20
    L8:
        if ((r10 & (-64)) == 0) goto L11;
    L12:
        int r11 = r10 - 104;     // Catch: Throwable -> L18 RecognitionException -> L20
        if ((r11 & (-64)) != 0) goto L22;
        if (((1 << r11) & 68719511557L) == 0) goto L22;
    L16:
        setState(911);     // Catch: Throwable -> L18 RecognitionException -> L20
        column_constraint();     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(916);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        r10 = this._input.LA(1);     // Catch: Throwable -> L18 RecognitionException -> L20
    L22:
        exitRule();
        return r5;
    L11:
        if (((1 << r10) & 290693282197929984L) != 0) goto L16;
    L18:
        th = move-exception;
        exitRule();
        throw th;
    L20:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L18
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L18
        this._errHandler.recover(this, e);     // Catch: Throwable -> L18
        goto L22
    }

    public final Column_nameContext column_name() throws RecognitionException {
        Column_nameContext r5 = new Column_nameContext(this._ctx, getState());
        enterRule(r5, 146, 73);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1515);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final Column_name_listContext column_name_list() throws RecognitionException {
        Column_name_listContext r5 = new Column_name_listContext(this._ctx, getState());
        enterRule(r5, 128, 64);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(1488);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(3);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(1489);     // Catch: Throwable -> L7 RecognitionException -> L9
        column_name();     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(1494);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        int r10 = this._input.LA(1);     // Catch: Throwable -> L7 RecognitionException -> L9
    L5:
        if (r10 != 5) goto L11;
        setState(1490);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(5);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(1491);     // Catch: Throwable -> L7 RecognitionException -> L9
        column_name();     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(1496);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        r10 = this._input.LA(1);     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L11:
        setState(1497);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(4);     // Catch: Throwable -> L7 RecognitionException -> L9
    L12:
        exitRule();
        return r5;
    L9:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L7
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L7
        this._errHandler.recover(this, e);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Comma_separated_exprContext comma_separated_expr() throws RecognitionException {
        Comma_separated_exprContext r5 = new Comma_separated_exprContext(this._ctx, getState());
        enterRule(r5, 76, 38);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1124);     // Catch: Throwable -> L8 RecognitionException -> L10
        expr(0);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1129);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r10 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
    L5:
        if (r10 != 5) goto L12;
        setState(1125);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(5);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1126);     // Catch: Throwable -> L8 RecognitionException -> L10
        expr(0);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1131);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        r10 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
    L12:
        exitRule();
        return r5;
    L8:
        th = move-exception;
        exitRule();
        throw th;
    L10:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L8
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L8
        this._errHandler.recover(this, e);     // Catch: Throwable -> L8
        goto L12
    }

    public final Commit_stmtContext commit_stmt() throws RecognitionException {
        Commit_stmtContext r5 = new Commit_stmtContext(this._ctx, getState());
        enterRule(r5, 16, 8);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(287);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r10 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r10 == 49) goto L13;
        if (r10 == 68) goto L13;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L8 RecognitionException -> L10
    L16:
        setState(292);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (this._input.LA(1) != 137) goto L22;
        setState(288);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(137);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(290);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 17, this._ctx) != 1) goto L22;
        setState(289);     // Catch: Throwable -> L8 RecognitionException -> L10
        transaction_name();     // Catch: Throwable -> L8 RecognitionException -> L10
    L22:
        exitRule();
        return r5;
    L13:
        if (this._input.LA(1) != (-1)) goto L15;
        this.matchedEOF = true;     // Catch: Throwable -> L8 RecognitionException -> L10
    L15:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        consume();     // Catch: Throwable -> L8 RecognitionException -> L10
    L10:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L8
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L8
        this._errHandler.recover(this, e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Common_table_expressionContext common_table_expression() throws RecognitionException {
        Common_table_expressionContext r5 = new Common_table_expressionContext(this._ctx, getState());
        enterRule(r5, 88, 44);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(1255);     // Catch: Throwable -> L9 RecognitionException -> L11
        table_name();     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(1267);     // Catch: Throwable -> L9 RecognitionException -> L11
        this._errHandler.sync(this);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (this._input.LA(1) != 3) goto L14;
        setState(1256);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(3);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(1257);     // Catch: Throwable -> L9 RecognitionException -> L11
        column_name();     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(1262);     // Catch: Throwable -> L9 RecognitionException -> L11
        this._errHandler.sync(this);     // Catch: Throwable -> L9 RecognitionException -> L11
        int r10 = this._input.LA(1);     // Catch: Throwable -> L9 RecognitionException -> L11
    L7:
        if (r10 != 5) goto L13;
        setState(1258);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(5);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(1259);     // Catch: Throwable -> L9 RecognitionException -> L11
        column_name();     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(1264);     // Catch: Throwable -> L9 RecognitionException -> L11
        this._errHandler.sync(this);     // Catch: Throwable -> L9 RecognitionException -> L11
        r10 = this._input.LA(1);     // Catch: Throwable -> L9 RecognitionException -> L11
        goto L7
    L13:
        setState(1265);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(4);     // Catch: Throwable -> L9 RecognitionException -> L11
    L14:
        setState(1269);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(35);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(1270);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(3);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(1271);     // Catch: Throwable -> L9 RecognitionException -> L11
        select_stmt();     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(1272);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(4);     // Catch: Throwable -> L9 RecognitionException -> L11
    L15:
        exitRule();
        return r5;
    L9:
        th = move-exception;
        exitRule();
        throw th;
    L11:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L9
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L9
        this._errHandler.recover(this, e);     // Catch: Throwable -> L9
        goto L15
    }

    public final Compound_operatorContext compound_operator() throws RecognitionException {
        Compound_operatorContext r5 = new Compound_operatorContext(this._ctx, getState());
        enterRule(r5, 110, 55);
        setState(1449);     // Catch: Throwable -> L13 RecognitionException -> L15
        this._errHandler.sync(this);     // Catch: Throwable -> L13 RecognitionException -> L15
        int r10 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 211, this._ctx);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r10 != 1) goto L6;
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(1444);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(139);     // Catch: Throwable -> L13 RecognitionException -> L15
    L26:
    L20:
        exitRule();
        return r5;
    L6:
        if (r10 != 2) goto L8;
        enterOuterAlt(r5, 2);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(1445);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(139);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(1446);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(31);     // Catch: Throwable -> L13 RecognitionException -> L15
        goto L26
    L8:
        if (r10 != 3) goto L10;
        enterOuterAlt(r5, 3);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(1447);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(92);     // Catch: Throwable -> L13 RecognitionException -> L15
        goto L26
    L10:
        if (r10 != 4) goto L26;
        enterOuterAlt(r5, 4);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(1448);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(70);     // Catch: Throwable -> L13 RecognitionException -> L15
    L15:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L13
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L13
        this._errHandler.recover(this, e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Conflict_clauseContext conflict_clause() throws RecognitionException {
        Conflict_clauseContext r5 = new Conflict_clauseContext(this._ctx, getState());
        enterRule(r5, 72, 36);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(976);     // Catch: Throwable -> L12 RecognitionException -> L14
        this._errHandler.sync(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (this._input.LA(1) != 109) goto L20;
        setState(973);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(109);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(974);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(50);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(975);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r10 = this._input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r10 == 27) goto L17;
        int r11 = r10 - 74;     // Catch: Throwable -> L12 RecognitionException -> L14
        if ((r11 & (-64)) == 0) goto L10;
    L11:
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L20
    L10:
        if (((1 << r11) & 10133099161584129L) == 0) goto L11;
    L17:
        if (this._input.LA(1) != (-1)) goto L19;
        this.matchedEOF = true;     // Catch: Throwable -> L12 RecognitionException -> L14
    L19:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        consume();     // Catch: Throwable -> L12 RecognitionException -> L14
    L20:
        exitRule();
        return r5;
    L14:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L12
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L12
        this._errHandler.recover(this, e);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Create_index_stmtContext create_index_stmt() throws RecognitionException {
        Create_index_stmtContext r5 = new Create_index_stmtContext(this._ctx, getState());
        enterRule(r5, 18, 9);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(294);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(52);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(296);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 140) goto L10;
        setState(295);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(140);     // Catch: Throwable -> L6 RecognitionException -> L8
    L10:
        setState(298);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(86);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(LynxErrorCode.LYNX_ERROR_CODE_COMPONENT_NOT_EXIST);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 20, this._ctx) != 1) goto L14;
        setState(299);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(82);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(300);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(104);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(LynxErrorCode.LYNX_ERROR_CODE_RESOURCE);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(72);     // Catch: Throwable -> L6 RecognitionException -> L8
    L14:
        setState(StatusLine.HTTP_TEMP_REDIRECT);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 21, this._ctx) != 1) goto L18;
        setState(304);     // Catch: Throwable -> L6 RecognitionException -> L8
        schema_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(305);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(2);     // Catch: Throwable -> L6 RecognitionException -> L8
    L18:
        setState(309);     // Catch: Throwable -> L6 RecognitionException -> L8
        index_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(310);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(109);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(311);     // Catch: Throwable -> L6 RecognitionException -> L8
        table_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(312);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(3);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(313);     // Catch: Throwable -> L6 RecognitionException -> L8
        indexed_column();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(318);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r10 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
    L20:
        if (r10 != 5) goto L22;
        setState(314);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(5);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(315);     // Catch: Throwable -> L6 RecognitionException -> L8
        indexed_column();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(320);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        r10 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L20
    L22:
        setState(321);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(4);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(324);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 148) goto L25;
        setState(322);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(148);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(323);     // Catch: Throwable -> L6 RecognitionException -> L8
        expr(0);     // Catch: Throwable -> L6 RecognitionException -> L8
    L25:
        exitRule();
        return r5;
    L6:
        th = move-exception;
        exitRule();
        throw th;
    L8:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L6
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L6
        this._errHandler.recover(this, e);     // Catch: Throwable -> L6
        goto L25
    }

    public final Create_table_stmtContext create_table_stmt() throws RecognitionException {
        Create_table_stmtContext r5 = new Create_table_stmtContext(this._ctx, getState());
        enterRule(r5, 20, 10);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(326);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(52);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(328);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r10 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r10 == 133) goto L6;
        if (r10 == 134) goto L6;
    L18:
        setState(330);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(132);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(334);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 25, this._ctx) != 1) goto L22;
        setState(331);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(82);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(332);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(104);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(333);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(72);     // Catch: Throwable -> L10 RecognitionException -> L12
    L22:
        setState(339);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 26, this._ctx) != 1) goto L26;
        setState(336);     // Catch: Throwable -> L10 RecognitionException -> L12
        schema_name();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(337);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(2);     // Catch: Throwable -> L10 RecognitionException -> L12
    L26:
        setState(341);     // Catch: Throwable -> L10 RecognitionException -> L12
        table_name();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(364);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r11 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r11 != 3) goto L29;
        setState(342);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(3);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(343);     // Catch: Throwable -> L10 RecognitionException -> L12
        column_def();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(348);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r12 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 27, this._ctx);     // Catch: Throwable -> L10 RecognitionException -> L12
    L35:
        if (r12 == 1) goto L40;
        if (r12 == 0) goto L40;
        if (r12 != 2) goto L39;
        setState(344);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(5);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(345);     // Catch: Throwable -> L10 RecognitionException -> L12
        column_def();     // Catch: Throwable -> L10 RecognitionException -> L12
    L39:
        setState(350);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        r12 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 27, this._ctx);     // Catch: Throwable -> L10 RecognitionException -> L12
    L40:
        setState(355);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r13 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
    L41:
        if (r13 != 5) goto L43;
        setState(351);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(5);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(352);     // Catch: Throwable -> L10 RecognitionException -> L12
        table_constraint();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(357);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        r13 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L41
    L43:
        setState(358);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(4);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(360);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this._input.LA(1) != 151) goto L46;
        setState(359);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(151);     // Catch: Throwable -> L10 RecognitionException -> L12
    L46:
        exitRule();
        return r5;
    L29:
        if (r11 != 35) goto L32;
        setState(362);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(35);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(363);     // Catch: Throwable -> L10 RecognitionException -> L12
        select_stmt();     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L46
    L32:
        throw new NoViableAltException(this);     // Catch: Throwable -> L10 RecognitionException -> L12
    L6:
        setState(327);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r14 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r14 == 133) goto L15;
        if (r14 == 134) goto L15;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L10 RecognitionException -> L12
    L15:
        if (this._input.LA(1) != (-1)) goto L17;
        this.matchedEOF = true;     // Catch: Throwable -> L10 RecognitionException -> L12
    L17:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        consume();     // Catch: Throwable -> L10 RecognitionException -> L12
    L10:
        th = move-exception;
        exitRule();
        throw th;
    L12:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L10
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L10
        this._errHandler.recover(this, e);     // Catch: Throwable -> L10
        goto L46
    }

    public final Create_trigger_stmtContext create_trigger_stmt() throws RecognitionException {
        Create_trigger_stmtContext r5 = new Create_trigger_stmtContext(this._ctx, getState());
        enterRule(r5, 22, 11);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(366);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(52);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(368);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r10 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r10 == 133) goto L6;
        if (r10 == 134) goto L6;
    L18:
        setState(370);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(138);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(374);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 32, this._ctx) != 1) goto L22;
        setState(371);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(82);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(372);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(104);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(373);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(72);     // Catch: Throwable -> L10 RecognitionException -> L12
    L22:
        setState(379);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 33, this._ctx) != 1) goto L26;
        setState(376);     // Catch: Throwable -> L10 RecognitionException -> L12
        schema_name();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(377);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(2);     // Catch: Throwable -> L10 RecognitionException -> L12
    L26:
        setState(381);     // Catch: Throwable -> L10 RecognitionException -> L12
        trigger_name();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(386);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r11 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r11 != 30) goto L29;
        setState(383);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(30);     // Catch: Throwable -> L10 RecognitionException -> L12
    L36:
        setState(402);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r12 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r12 != 61) goto L39;
        setState(388);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(61);     // Catch: Throwable -> L10 RecognitionException -> L12
    L52:
        setState(404);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(109);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(408);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 38, this._ctx) != 1) goto L56;
        setState(405);     // Catch: Throwable -> L10 RecognitionException -> L12
        schema_name();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(406);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(2);     // Catch: Throwable -> L10 RecognitionException -> L12
    L56:
        setState(410);     // Catch: Throwable -> L10 RecognitionException -> L12
        table_name();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(414);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this._input.LA(1) != 75) goto L59;
        setState(411);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(75);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(412);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(66);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(413);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(128);     // Catch: Throwable -> L10 RecognitionException -> L12
    L59:
        setState(418);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this._input.LA(1) != 147) goto L62;
        setState(416);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(147);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(417);     // Catch: Throwable -> L10 RecognitionException -> L12
        expr(0);     // Catch: Throwable -> L10 RecognitionException -> L12
    L62:
        setState(420);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(40);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(429);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
    L63:
        setState(425);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r13 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 41, this._ctx);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r13 == 1) goto L74;
        if (r13 != 2) goto L67;
        setState(422);     // Catch: Throwable -> L10 RecognitionException -> L12
        insert_stmt();     // Catch: Throwable -> L10 RecognitionException -> L12
    L75:
        setState(427);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(431);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r14 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r14 == 61) goto L63;
        int r15 = r14 - 90;     // Catch: Throwable -> L10 RecognitionException -> L12
        if ((r15 & (-64)) != 0) goto L81;
        if (((1 << r15) & 596728067318087681L) != 0) goto L63;
    L81:
        setState(433);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(68);     // Catch: Throwable -> L10 RecognitionException -> L12
    L82:
        exitRule();
        return r5;
    L67:
        if (r13 != 3) goto L69;
        setState(423);     // Catch: Throwable -> L10 RecognitionException -> L12
        delete_stmt();     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L75
    L69:
        if (r13 != 4) goto L75;
        setState(424);     // Catch: Throwable -> L10 RecognitionException -> L12
        select_stmt();     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L75
    L74:
        setState(StatusLine.HTTP_MISDIRECTED_REQUEST);     // Catch: Throwable -> L10 RecognitionException -> L12
        update_stmt();     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L75
    L39:
        if (r12 != 90) goto L41;
        setState(389);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(90);     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L52
    L41:
        if (r12 != 141) goto L49;
        setState(390);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(141);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(400);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this._input.LA(1) != 107) goto L52;
        setState(391);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(107);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(392);     // Catch: Throwable -> L10 RecognitionException -> L12
        column_name();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(397);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r16 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
    L46:
        if (r16 != 5) goto L52;
        setState(393);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(5);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(394);     // Catch: Throwable -> L10 RecognitionException -> L12
        column_name();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(399);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        r16 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L46
    L49:
        throw new NoViableAltException(this);     // Catch: Throwable -> L10 RecognitionException -> L12
    L29:
        if (r11 != 39) goto L31;
        setState(382);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(39);     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L36
    L31:
        if (r11 != 91) goto L36;
        setState(384);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(91);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(385);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(107);     // Catch: Throwable -> L10 RecognitionException -> L12
    L6:
        setState(367);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r17 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r17 == 133) goto L15;
        if (r17 == 134) goto L15;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L10 RecognitionException -> L12
    L15:
        if (this._input.LA(1) != (-1)) goto L17;
        this.matchedEOF = true;     // Catch: Throwable -> L10 RecognitionException -> L12
    L17:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        consume();     // Catch: Throwable -> L10 RecognitionException -> L12
    L10:
        th = move-exception;
        exitRule();
        throw th;
    L12:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L10
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L10
        this._errHandler.recover(this, e);     // Catch: Throwable -> L10
        goto L82
    }

    public final Create_view_stmtContext create_view_stmt() throws RecognitionException {
        Create_view_stmtContext r5 = new Create_view_stmtContext(this._ctx, getState());
        enterRule(r5, 24, 12);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(435);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(52);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(437);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r10 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r10 == 133) goto L6;
        if (r10 == 134) goto L6;
    L18:
        setState(439);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(145);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(443);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 44, this._ctx) != 1) goto L22;
        setState(440);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(82);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(441);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(104);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(442);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(72);     // Catch: Throwable -> L10 RecognitionException -> L12
    L22:
        setState(448);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 45, this._ctx) != 1) goto L26;
        setState(445);     // Catch: Throwable -> L10 RecognitionException -> L12
        schema_name();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(446);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(2);     // Catch: Throwable -> L10 RecognitionException -> L12
    L26:
        setState(450);     // Catch: Throwable -> L10 RecognitionException -> L12
        view_name();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(459);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 47, this._ctx) != 1) goto L33;
        setState(451);     // Catch: Throwable -> L10 RecognitionException -> L12
        column_name();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(456);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r11 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
    L31:
        if (r11 != 5) goto L33;
        setState(452);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(5);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(453);     // Catch: Throwable -> L10 RecognitionException -> L12
        column_name();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(458);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        r11 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
    L33:
        setState(461);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(35);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(462);     // Catch: Throwable -> L10 RecognitionException -> L12
        select_stmt();     // Catch: Throwable -> L10 RecognitionException -> L12
    L34:
        exitRule();
        return r5;
    L6:
        setState(436);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r12 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r12 == 133) goto L15;
        if (r12 == 134) goto L15;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L10 RecognitionException -> L12
    L15:
        if (this._input.LA(1) != (-1)) goto L17;
        this.matchedEOF = true;     // Catch: Throwable -> L10 RecognitionException -> L12
    L17:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        consume();     // Catch: Throwable -> L10 RecognitionException -> L12
    L10:
        th = move-exception;
        exitRule();
        throw th;
    L12:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L10
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L10
        this._errHandler.recover(this, e);     // Catch: Throwable -> L10
        goto L34
    }

    public final Create_virtual_table_stmtContext create_virtual_table_stmt() throws RecognitionException {
        Create_virtual_table_stmtContext r5 = new Create_virtual_table_stmtContext(this._ctx, getState());
        enterRule(r5, 26, 13);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(464);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(52);     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(465);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(146);     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(466);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(132);     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(470);     // Catch: Throwable -> L17 RecognitionException -> L19
        this._errHandler.sync(this);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 48, this._ctx) != 1) goto L7;
        setState(467);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(82);     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(468);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(104);     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(469);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(72);     // Catch: Throwable -> L17 RecognitionException -> L19
    L7:
        setState(475);     // Catch: Throwable -> L17 RecognitionException -> L19
        this._errHandler.sync(this);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 49, this._ctx) != 1) goto L11;
        setState(472);     // Catch: Throwable -> L17 RecognitionException -> L19
        schema_name();     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(473);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(2);     // Catch: Throwable -> L17 RecognitionException -> L19
    L11:
        setState(477);     // Catch: Throwable -> L17 RecognitionException -> L19
        table_name();     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(478);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(142);     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(479);     // Catch: Throwable -> L17 RecognitionException -> L19
        module_name();     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(491);     // Catch: Throwable -> L17 RecognitionException -> L19
        this._errHandler.sync(this);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (this._input.LA(1) != 3) goto L22;
        setState(480);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(3);     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(481);     // Catch: Throwable -> L17 RecognitionException -> L19
        module_argument();     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(486);     // Catch: Throwable -> L17 RecognitionException -> L19
        this._errHandler.sync(this);     // Catch: Throwable -> L17 RecognitionException -> L19
        int r10 = this._input.LA(1);     // Catch: Throwable -> L17 RecognitionException -> L19
    L15:
        if (r10 != 5) goto L21;
        setState(482);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(5);     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(483);     // Catch: Throwable -> L17 RecognitionException -> L19
        module_argument();     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(488);     // Catch: Throwable -> L17 RecognitionException -> L19
        this._errHandler.sync(this);     // Catch: Throwable -> L17 RecognitionException -> L19
        r10 = this._input.LA(1);     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L15
    L21:
        setState(489);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(4);     // Catch: Throwable -> L17 RecognitionException -> L19
    L22:
        exitRule();
        return r5;
    L17:
        th = move-exception;
        exitRule();
        throw th;
    L19:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L17
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L17
        this._errHandler.recover(this, e);     // Catch: Throwable -> L17
        goto L22
    }

    public final Delete_stmtContext delete_stmt() throws RecognitionException {
        Delete_stmtContext r5 = new Delete_stmtContext(this._ctx, getState());
        enterRule(r5, 28, 14);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(494);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 149) goto L10;
        setState(493);     // Catch: Throwable -> L6 RecognitionException -> L8
        with_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
    L10:
        setState(496);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(61);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(497);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(77);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(498);     // Catch: Throwable -> L6 RecognitionException -> L8
        qualified_table_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(LynxErrorCode.LYNX_ERROR_CODE_CANVAS);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 148) goto L13;
        setState(499);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(148);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(500);     // Catch: Throwable -> L6 RecognitionException -> L8
        expr(0);     // Catch: Throwable -> L6 RecognitionException -> L8
    L13:
        exitRule();
        return r5;
    L6:
        th = move-exception;
        exitRule();
        throw th;
    L8:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L6
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L6
        this._errHandler.recover(this, e);     // Catch: Throwable -> L6
        goto L13
    }

    public final Delete_stmt_limitedContext delete_stmt_limited() throws RecognitionException {
        Delete_stmt_limitedContext r5 = new Delete_stmt_limitedContext(this._ctx, getState());
        enterRule(r5, 30, 15);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(504);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 149) goto L10;
        setState(503);     // Catch: Throwable -> L6 RecognitionException -> L8
        with_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
    L10:
        setState(506);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(61);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(507);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(77);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(508);     // Catch: Throwable -> L6 RecognitionException -> L8
        qualified_table_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(FrameMetricsAggregator.EVERY_DURATION);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 148) goto L13;
        setState(509);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(148);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(510);     // Catch: Throwable -> L6 RecognitionException -> L8
        expr(0);     // Catch: Throwable -> L6 RecognitionException -> L8
    L13:
        setState(517);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r10 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r10 == 100) goto L16;
        if (r10 == 111) goto L16;
    L20:
        exitRule();
        return r5;
    L16:
        setState(514);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 111) goto L19;
        setState(InputDeviceCompat.SOURCE_DPAD);     // Catch: Throwable -> L6 RecognitionException -> L8
        order_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
    L19:
        setState(516);     // Catch: Throwable -> L6 RecognitionException -> L8
        limit_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
    L6:
        th = move-exception;
        exitRule();
        throw th;
    L8:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L6
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L6
        this._errHandler.recover(this, e);     // Catch: Throwable -> L6
        goto L20
    }

    public final Detach_stmtContext detach_stmt() throws RecognitionException {
        Detach_stmtContext r5 = new Detach_stmtContext(this._ctx, getState());
        enterRule(r5, 32, 16);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(519);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(63);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(521);     // Catch: Throwable -> L9 RecognitionException -> L11
        this._errHandler.sync(this);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 58, this._ctx) != 1) goto L7;
        setState(520);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(57);     // Catch: Throwable -> L9 RecognitionException -> L11
    L7:
        setState(523);     // Catch: Throwable -> L9 RecognitionException -> L11
        schema_name();     // Catch: Throwable -> L9 RecognitionException -> L11
    L8:
        exitRule();
        return r5;
    L9:
        th = move-exception;
        exitRule();
        throw th;
    L11:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L9
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L9
        this._errHandler.recover(this, e);     // Catch: Throwable -> L9
        goto L8
    }

    public final Drop_index_stmtContext drop_index_stmt() throws RecognitionException {
        Drop_index_stmtContext r5 = new Drop_index_stmtContext(this._ctx, getState());
        enterRule(r5, 34, 17);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(525);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(65);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(526);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(86);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(529);     // Catch: Throwable -> L13 RecognitionException -> L15
        this._errHandler.sync(this);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 59, this._ctx) != 1) goto L7;
        setState(527);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(82);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(528);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(72);     // Catch: Throwable -> L13 RecognitionException -> L15
    L7:
        setState(534);     // Catch: Throwable -> L13 RecognitionException -> L15
        this._errHandler.sync(this);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 60, this._ctx) != 1) goto L11;
        setState(531);     // Catch: Throwable -> L13 RecognitionException -> L15
        schema_name();     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(532);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(2);     // Catch: Throwable -> L13 RecognitionException -> L15
    L11:
        setState(536);     // Catch: Throwable -> L13 RecognitionException -> L15
        index_name();     // Catch: Throwable -> L13 RecognitionException -> L15
    L12:
        exitRule();
        return r5;
    L15:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L13
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L13
        this._errHandler.recover(this, e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Drop_table_stmtContext drop_table_stmt() throws RecognitionException {
        Drop_table_stmtContext r5 = new Drop_table_stmtContext(this._ctx, getState());
        enterRule(r5, 36, 18);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(538);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(65);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(539);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(132);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(542);     // Catch: Throwable -> L13 RecognitionException -> L15
        this._errHandler.sync(this);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 61, this._ctx) != 1) goto L7;
        setState(540);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(82);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(541);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(72);     // Catch: Throwable -> L13 RecognitionException -> L15
    L7:
        setState(547);     // Catch: Throwable -> L13 RecognitionException -> L15
        this._errHandler.sync(this);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 62, this._ctx) != 1) goto L11;
        setState(544);     // Catch: Throwable -> L13 RecognitionException -> L15
        schema_name();     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(545);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(2);     // Catch: Throwable -> L13 RecognitionException -> L15
    L11:
        setState(549);     // Catch: Throwable -> L13 RecognitionException -> L15
        table_name();     // Catch: Throwable -> L13 RecognitionException -> L15
    L12:
        exitRule();
        return r5;
    L15:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L13
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L13
        this._errHandler.recover(this, e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Drop_trigger_stmtContext drop_trigger_stmt() throws RecognitionException {
        Drop_trigger_stmtContext r5 = new Drop_trigger_stmtContext(this._ctx, getState());
        enterRule(r5, 38, 19);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(551);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(65);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(552);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(138);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(555);     // Catch: Throwable -> L13 RecognitionException -> L15
        this._errHandler.sync(this);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 63, this._ctx) != 1) goto L7;
        setState(553);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(82);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(554);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(72);     // Catch: Throwable -> L13 RecognitionException -> L15
    L7:
        setState(560);     // Catch: Throwable -> L13 RecognitionException -> L15
        this._errHandler.sync(this);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 64, this._ctx) != 1) goto L11;
        setState(557);     // Catch: Throwable -> L13 RecognitionException -> L15
        schema_name();     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(558);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(2);     // Catch: Throwable -> L13 RecognitionException -> L15
    L11:
        setState(562);     // Catch: Throwable -> L13 RecognitionException -> L15
        trigger_name();     // Catch: Throwable -> L13 RecognitionException -> L15
    L12:
        exitRule();
        return r5;
    L15:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L13
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L13
        this._errHandler.recover(this, e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Drop_view_stmtContext drop_view_stmt() throws RecognitionException {
        Drop_view_stmtContext r5 = new Drop_view_stmtContext(this._ctx, getState());
        enterRule(r5, 40, 20);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(564);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(65);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(565);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(145);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(568);     // Catch: Throwable -> L13 RecognitionException -> L15
        this._errHandler.sync(this);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 65, this._ctx) != 1) goto L7;
        setState(566);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(82);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(567);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(72);     // Catch: Throwable -> L13 RecognitionException -> L15
    L7:
        setState(573);     // Catch: Throwable -> L13 RecognitionException -> L15
        this._errHandler.sync(this);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 66, this._ctx) != 1) goto L11;
        setState(570);     // Catch: Throwable -> L13 RecognitionException -> L15
        schema_name();     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(571);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(2);     // Catch: Throwable -> L13 RecognitionException -> L15
    L11:
        setState(575);     // Catch: Throwable -> L13 RecognitionException -> L15
        view_name();     // Catch: Throwable -> L13 RecognitionException -> L15
    L12:
        exitRule();
        return r5;
    L13:
        th = move-exception;
        exitRule();
        throw th;
    L15:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L13
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L13
        this._errHandler.recover(this, e);     // Catch: Throwable -> L13
        goto L12
    }

    public final ErrorContext error() throws RecognitionException {
        ErrorContext r5 = new ErrorContext(this._ctx, getState());
        enterRule(r5, 2, 1);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(179);     // Catch: Throwable -> L6 RecognitionException -> L8
        r5.UNEXPECTED_CHAR = match(162);     // Catch: Throwable -> L6 RecognitionException -> L8
        Token r10 = r5.UNEXPECTED_CHAR;     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r10 == null) goto L10;
        String r11 = r10.getText();     // Catch: Throwable -> L6 RecognitionException -> L8
    L12:
        throw new RuntimeException("UNEXPECTED_CHAR=" + r11);     // Catch: Throwable -> L6 RecognitionException -> L8
    L10:
        r11 = null;
    L8:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L6
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L6
        this._errHandler.recover(this, e);     // Catch: Throwable -> L6
        exitRule();
        return r5;
    L6:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Error_messageContext error_message() throws RecognitionException {
        Error_messageContext r5 = new Error_messageContext(this._ctx, getState());
        enterRule(r5, 122, 61);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1480);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(157);     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final ExprContext expr() throws RecognitionException {
        return expr(0);
    }

    public final Foreign_key_clauseContext foreign_key_clause() throws RecognitionException {
        Foreign_key_clauseContext r5 = new Foreign_key_clauseContext(this._ctx, getState());
        enterRule(r5, 78, 39);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1132);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(119);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1133);     // Catch: Throwable -> L8 RecognitionException -> L10
        foreign_table();     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1145);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (this._input.LA(1) != 3) goto L13;
        setState(1134);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(3);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1135);     // Catch: Throwable -> L8 RecognitionException -> L10
        column_name();     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1140);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r10 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
    L6:
        if (r10 != 5) goto L12;
        setState(1136);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(5);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1137);     // Catch: Throwable -> L8 RecognitionException -> L10
        column_name();     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1142);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        r10 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L6
    L12:
        setState(1143);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(4);     // Catch: Throwable -> L8 RecognitionException -> L10
    L13:
        setState(1165);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r11 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
    L15:
        if (r11 == 101) goto L32;
        if (r11 == 109) goto L32;
        setState(1178);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 165, this._ctx) != 1) goto L30;
        setState(1169);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (this._input.LA(1) != 104) goto L24;
        setState(1168);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(104);     // Catch: Throwable -> L8 RecognitionException -> L10
    L24:
        setState(1171);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(59);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1176);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r12 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 164, this._ctx);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r12 == 1) goto L29;
        if (r12 != 2) goto L30;
        setState(1174);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(88);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1175);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(84);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L30
    L29:
        setState(1172);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(88);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1173);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(60);     // Catch: Throwable -> L8 RecognitionException -> L10
    L30:
        exitRule();
        return r5;
    L32:
        setState(1161);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r13 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r13 == 101) goto L58;
        if (r13 != 109) goto L57;
        setState(1147);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(109);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1148);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r14 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r14 == 61) goto L41;
        if (r14 == 141) goto L41;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L8 RecognitionException -> L10
    L44:
        setState(1157);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r15 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 160, this._ctx);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r15 == 1) goto L55;
        if (r15 == 2) goto L54;
        if (r15 == 3) goto L53;
        if (r15 == 4) goto L52;
        if (r15 != 5) goto L59;
        setState(1155);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(103);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1156);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(28);     // Catch: Throwable -> L8 RecognitionException -> L10
    L59:
        setState(1167);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        r11 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L15
    L52:
        setState(1154);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(125);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L59
    L53:
        setState(1153);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(43);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L59
    L54:
        setState(1151);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(131);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1152);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(58);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L59
    L55:
        setState(1149);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(131);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1150);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(106);     // Catch: Throwable -> L8 RecognitionException -> L10
    L41:
        if (this._input.LA(1) != (-1)) goto L43;
        this.matchedEOF = true;     // Catch: Throwable -> L8 RecognitionException -> L10
    L43:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        consume();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L44
    L57:
        throw new NoViableAltException(this);     // Catch: Throwable -> L8 RecognitionException -> L10
    L58:
        setState(1159);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(101);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1160);     // Catch: Throwable -> L8 RecognitionException -> L10
        name();     // Catch: Throwable -> L8 RecognitionException -> L10
    L8:
        th = move-exception;
        exitRule();
        throw th;
    L10:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L8
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L8
        this._errHandler.recover(this, e);     // Catch: Throwable -> L8
        goto L30
    }

    public final Foreign_tableContext foreign_table() throws RecognitionException {
        Foreign_tableContext r5 = new Foreign_tableContext(this._ctx, getState());
        enterRule(r5, 150, 75);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1519);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final Function_nameContext function_name() throws RecognitionException {
        Function_nameContext r5 = new Function_nameContext(this._ctx, getState());
        enterRule(r5, 134, 67);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1503);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public ATN getATN() {
        return _ATN;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public String getGrammarFileName() {
        return "SQLite.g4";
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    public final Index_nameContext index_name() throws RecognitionException {
        Index_nameContext r5 = new Index_nameContext(this._ctx, getState());
        enterRule(r5, 152, 76);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1521);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final Indexed_columnContext indexed_column() throws RecognitionException {
        Indexed_columnContext r5 = new Indexed_columnContext(this._ctx, getState());
        enterRule(r5, 82, 41);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(1192);     // Catch: Throwable -> L9 RecognitionException -> L11
        this._errHandler.sync(this);     // Catch: Throwable -> L9 RecognitionException -> L11
        int r10 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 167, this._ctx);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (r10 != 1) goto L6;
        setState(1190);     // Catch: Throwable -> L9 RecognitionException -> L11
        column_name();     // Catch: Throwable -> L9 RecognitionException -> L11
    L14:
        setState(1196);     // Catch: Throwable -> L9 RecognitionException -> L11
        this._errHandler.sync(this);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (this._input.LA(1) != 47) goto L17;
        setState(1194);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(47);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(1195);     // Catch: Throwable -> L9 RecognitionException -> L11
        collation_name();     // Catch: Throwable -> L9 RecognitionException -> L11
    L17:
        setState(1199);     // Catch: Throwable -> L9 RecognitionException -> L11
        this._errHandler.sync(this);     // Catch: Throwable -> L9 RecognitionException -> L11
        int r11 = this._input.LA(1);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (r11 == 36) goto L20;
        if (r11 == 62) goto L20;
    L28:
        exitRule();
        return r5;
    L20:
        setState(1198);     // Catch: Throwable -> L9 RecognitionException -> L11
        int r12 = this._input.LA(1);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (r12 == 36) goto L25;
        if (r12 == 62) goto L25;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L9 RecognitionException -> L11
    L25:
        if (this._input.LA(1) != (-1)) goto L27;
        this.matchedEOF = true;     // Catch: Throwable -> L9 RecognitionException -> L11
    L27:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L9 RecognitionException -> L11
        consume();     // Catch: Throwable -> L9 RecognitionException -> L11
        goto L28
    L6:
        if (r10 != 2) goto L14;
        setState(1191);     // Catch: Throwable -> L9 RecognitionException -> L11
        expr(0);     // Catch: Throwable -> L9 RecognitionException -> L11
    L9:
        th = move-exception;
        exitRule();
        throw th;
    L11:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L9
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L9
        this._errHandler.recover(this, e);     // Catch: Throwable -> L9
        goto L28
    }

    public final Insert_stmtContext insert_stmt() throws RecognitionException {
        Insert_stmtContext r5 = new Insert_stmtContext(this._ctx, getState());
        enterRule(r5, 42, 21);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(578);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 149) goto L10;
        setState(577);     // Catch: Throwable -> L6 RecognitionException -> L8
        with_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
    L10:
        setState(597);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        switch(((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 68, this._ctx)) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            default: goto L20;
        };     // Catch: Throwable -> L6 RecognitionException -> L8
    L13:
        setState(594);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(90);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(595);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(110);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(596);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(83);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L20
    L14:
        setState(591);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(90);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(592);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(110);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(593);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(74);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L20
    L15:
        setState(588);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(90);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(589);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(110);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(590);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(27);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L20
    L16:
        setState(585);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(90);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(586);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(110);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(587);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(127);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L20
    L17:
        setState(582);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(90);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(583);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(110);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(584);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(124);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L20
    L18:
        setState(581);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(124);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L20
    L19:
        setState(580);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(90);     // Catch: Throwable -> L6 RecognitionException -> L8
    L20:
        setState(599);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(93);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(603);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 69, this._ctx) != 1) goto L24;
        setState(600);     // Catch: Throwable -> L6 RecognitionException -> L8
        schema_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(LynxErrorCode.LYNX_ERROR_EXCEPTION);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(2);     // Catch: Throwable -> L6 RecognitionException -> L8
    L24:
        setState(605);     // Catch: Throwable -> L6 RecognitionException -> L8
        table_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(608);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 35) goto L27;
        setState(606);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(35);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(607);     // Catch: Throwable -> L6 RecognitionException -> L8
        table_alias();     // Catch: Throwable -> L6 RecognitionException -> L8
    L27:
        setState(621);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 3) goto L33;
        setState(610);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(3);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(611);     // Catch: Throwable -> L6 RecognitionException -> L8
        column_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(616);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r10 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
    L30:
        if (r10 != 5) goto L32;
        setState(612);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(5);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(613);     // Catch: Throwable -> L6 RecognitionException -> L8
        column_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(618);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        r10 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L30
    L32:
        setState(619);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(4);     // Catch: Throwable -> L6 RecognitionException -> L8
    L33:
        setState(640);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r11 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 74, this._ctx);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r11 == 1) goto L40;
        if (r11 == 2) goto L39;
        if (r11 != 3) goto L43;
        setState(638);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(58);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(639);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(144);     // Catch: Throwable -> L6 RecognitionException -> L8
    L43:
        setState(643);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 109) goto L46;
        setState(642);     // Catch: Throwable -> L6 RecognitionException -> L8
        upsert_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
    L46:
        exitRule();
        return r5;
    L39:
        setState(637);     // Catch: Throwable -> L6 RecognitionException -> L8
        select_stmt();     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L43
    L40:
        setState(623);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(144);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(624);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(3);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(625);     // Catch: Throwable -> L6 RecognitionException -> L8
        comma_separated_expr();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(626);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(4);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(634);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r12 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
    L41:
        if (r12 != 5) goto L43;
        setState(627);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(5);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(628);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(3);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(629);     // Catch: Throwable -> L6 RecognitionException -> L8
        comma_separated_expr();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(630);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(4);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(636);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        r12 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
    L6:
        th = move-exception;
        exitRule();
        throw th;
    L8:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L6
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L6
        this._errHandler.recover(this, e);     // Catch: Throwable -> L6
        goto L46
    }

    public final Join_clauseContext join_clause() throws RecognitionException {
        Join_clauseContext r5 = new Join_clauseContext(this._ctx, getState());
        enterRule(r5, 104, 52);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(1403);     // Catch: Throwable -> L17 RecognitionException -> L19
        table_or_subquery();     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(1410);     // Catch: Throwable -> L17 RecognitionException -> L19
        this._errHandler.sync(this);     // Catch: Throwable -> L17 RecognitionException -> L19
        int r10 = this._input.LA(1);     // Catch: Throwable -> L17 RecognitionException -> L19
    L5:
        if (r10 == 5) goto L15;
        if (r10 == 53) goto L15;
        int r11 = r10 - 89;
        if ((r11 & (-64)) != 0) goto L13;
        if (((1 << r11) & 8833) != 0) goto L15;
    L13:
        exitRule();
        return r5;
    L15:
        setState(1404);     // Catch: Throwable -> L17 RecognitionException -> L19
        join_operator();     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(1405);     // Catch: Throwable -> L17 RecognitionException -> L19
        table_or_subquery();     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(1406);     // Catch: Throwable -> L17 RecognitionException -> L19
        join_constraint();     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(1412);     // Catch: Throwable -> L17 RecognitionException -> L19
        this._errHandler.sync(this);     // Catch: Throwable -> L17 RecognitionException -> L19
        r10 = this._input.LA(1);     // Catch: Throwable -> L17 RecognitionException -> L19
    L17:
        th = move-exception;
        exitRule();
        throw th;
    L19:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L17
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L17
        this._errHandler.recover(this, e);     // Catch: Throwable -> L17
        goto L13
    }

    public final Join_constraintContext join_constraint() throws RecognitionException {
        Join_constraintContext r5 = new Join_constraintContext(this._ctx, getState());
        enterRule(r5, 108, 54);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1442);     // Catch: Throwable -> L12 RecognitionException -> L14
        this._errHandler.sync(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r10 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 210, this._ctx);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r10 != 1) goto L6;
        setState(1428);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(109);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1429);     // Catch: Throwable -> L12 RecognitionException -> L14
        expr(0);     // Catch: Throwable -> L12 RecognitionException -> L14
    L18:
        exitRule();
        return r5;
    L6:
        if (r10 != 2) goto L18;
        setState(1430);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(142);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1431);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(3);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1432);     // Catch: Throwable -> L12 RecognitionException -> L14
        column_name();     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1437);     // Catch: Throwable -> L12 RecognitionException -> L14
        this._errHandler.sync(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r11 = this._input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
    L10:
        if (r11 != 5) goto L16;
        setState(1433);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(5);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1434);     // Catch: Throwable -> L12 RecognitionException -> L14
        column_name();     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1439);     // Catch: Throwable -> L12 RecognitionException -> L14
        this._errHandler.sync(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        r11 = this._input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L10
    L16:
        setState(1440);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(4);     // Catch: Throwable -> L12 RecognitionException -> L14
    L14:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L12
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L12
        this._errHandler.recover(this, e);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Join_operatorContext join_operator() throws RecognitionException {
        Join_operatorContext r5 = new Join_operatorContext(this._ctx, getState());
        enterRule(r5, 106, 53);
        setState(1426);     // Catch: Throwable -> L14 RecognitionException -> L16
        this._errHandler.sync(this);     // Catch: Throwable -> L14 RecognitionException -> L16
        int r10 = this._input.LA(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r10 != 5) goto L6;
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L14 RecognitionException -> L16
        setState(1413);     // Catch: Throwable -> L14 RecognitionException -> L16
        match(5);     // Catch: Throwable -> L14 RecognitionException -> L16
    L33:
        exitRule();
        return r5;
    L6:
        if (r10 == 53) goto L18;
        if (r10 == 89) goto L18;
        if (r10 == 96) goto L18;
        if (r10 == 98) goto L18;
        if (r10 == 102) goto L18;
        throw new NoViableAltException(this);     // Catch: Throwable -> L14 RecognitionException -> L16
    L18:
        enterOuterAlt(r5, 2);     // Catch: Throwable -> L14 RecognitionException -> L16
        setState(1415);     // Catch: Throwable -> L14 RecognitionException -> L16
        this._errHandler.sync(this);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this._input.LA(1) != 102) goto L21;
        setState(1414);     // Catch: Throwable -> L14 RecognitionException -> L16
        match(102);     // Catch: Throwable -> L14 RecognitionException -> L16
    L21:
        setState(1423);     // Catch: Throwable -> L14 RecognitionException -> L16
        this._errHandler.sync(this);     // Catch: Throwable -> L14 RecognitionException -> L16
        int r11 = this._input.LA(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r11 == 53) goto L30;
        if (r11 == 89) goto L29;
        if (r11 != 98) goto L31;
        setState(1417);     // Catch: Throwable -> L14 RecognitionException -> L16
        match(98);     // Catch: Throwable -> L14 RecognitionException -> L16
        setState(1419);     // Catch: Throwable -> L14 RecognitionException -> L16
        this._errHandler.sync(this);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this._input.LA(1) != 112) goto L31;
        setState(1418);     // Catch: Throwable -> L14 RecognitionException -> L16
        match(112);     // Catch: Throwable -> L14 RecognitionException -> L16
    L31:
        setState(1425);     // Catch: Throwable -> L14 RecognitionException -> L16
        match(96);     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L33
    L29:
        setState(1421);     // Catch: Throwable -> L14 RecognitionException -> L16
        match(89);     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L31
    L30:
        setState(1422);     // Catch: Throwable -> L14 RecognitionException -> L16
        match(53);     // Catch: Throwable -> L14 RecognitionException -> L16
    L16:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L14
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L14
        this._errHandler.recover(this, e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final KeywordContext keyword() throws RecognitionException {
        KeywordContext r5 = new KeywordContext(this._ctx, getState());
        enterRule(r5, 130, 65);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L15 RecognitionException -> L17
        setState(1499);     // Catch: Throwable -> L15 RecognitionException -> L17
        int r10 = this._input.LA(1);     // Catch: Throwable -> L15 RecognitionException -> L17
        int r11 = r10 - 27;     // Catch: Throwable -> L15 RecognitionException -> L17
        if ((r11 & (-64)) == 0) goto L6;
    L7:
        int r12 = r10 - 91;     // Catch: Throwable -> L15 RecognitionException -> L17
        if ((r12 & (-64)) == 0) goto L10;
    L20:
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L15 RecognitionException -> L17
    L21:
        exitRule();
        return r5;
    L10:
        if (((1 << r12) & 1152921504606846975L) == 0) goto L20;
    L13:
        if (this._input.LA(1) != (-1)) goto L19;
        this.matchedEOF = true;     // Catch: Throwable -> L15 RecognitionException -> L17
    L19:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L15 RecognitionException -> L17
        consume();     // Catch: Throwable -> L15 RecognitionException -> L17
        goto L21
    L6:
        if ((1 << r11) != 0) goto L13;
    L15:
        th = move-exception;
        exitRule();
        throw th;
    L17:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L15
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L15
        this._errHandler.recover(this, e);     // Catch: Throwable -> L15
        goto L21
    }

    public final Limit_clauseContext limit_clause() throws RecognitionException {
        Limit_clauseContext r5 = new Limit_clauseContext(this._ctx, getState());
        enterRule(r5, 96, 48);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1309);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(100);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1310);     // Catch: Throwable -> L10 RecognitionException -> L12
        expr(0);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1313);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r10 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r10 == 5) goto L6;
        if (r10 == 108) goto L6;
    L19:
        exitRule();
        return r5;
    L6:
        setState(1311);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r11 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r11 == 5) goto L15;
        if (r11 == 108) goto L15;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L10 RecognitionException -> L12
    L18:
        setState(1312);     // Catch: Throwable -> L10 RecognitionException -> L12
        expr(0);     // Catch: Throwable -> L10 RecognitionException -> L12
    L15:
        if (this._input.LA(1) != (-1)) goto L17;
        this.matchedEOF = true;     // Catch: Throwable -> L10 RecognitionException -> L12
    L17:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        consume();     // Catch: Throwable -> L10 RecognitionException -> L12
    L12:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L10
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L10
        this._errHandler.recover(this, e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Literal_valueContext literal_value() throws RecognitionException {
        Literal_valueContext r5 = new Literal_valueContext(this._ctx, getState());
        enterRule(r5, 114, 57);
        setState(1464);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        int r10 = this._input.LA(1);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (r10 != 25) goto L6;
    L29:
        enterOuterAlt(r5, 8);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1463);     // Catch: Throwable -> L18 RecognitionException -> L20
        boolean_literal();     // Catch: Throwable -> L18 RecognitionException -> L20
    L30:
        exitRule();
        return r5;
    L6:
        if (r10 == 26) goto L29;
        if (r10 != 106) goto L10;
        enterOuterAlt(r5, 4);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1459);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(106);     // Catch: Throwable -> L18 RecognitionException -> L20
        goto L30
    L10:
        if (r10 != 155) goto L12;
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1456);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(155);     // Catch: Throwable -> L18 RecognitionException -> L20
        goto L30
    L12:
        if (r10 != 157) goto L14;
        enterOuterAlt(r5, 2);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1457);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(157);     // Catch: Throwable -> L18 RecognitionException -> L20
        goto L30
    L14:
        if (r10 == 158) goto L25;
        switch(r10) {
            case 54: goto L24;
            case 55: goto L23;
            case 56: goto L22;
            default: goto L17;
        };     // Catch: Throwable -> L18 RecognitionException -> L20
    L22:
        enterOuterAlt(r5, 7);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1462);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(56);     // Catch: Throwable -> L18 RecognitionException -> L20
        goto L30
    L23:
        enterOuterAlt(r5, 5);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1460);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(55);     // Catch: Throwable -> L18 RecognitionException -> L20
        goto L30
    L24:
        enterOuterAlt(r5, 6);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1461);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(54);     // Catch: Throwable -> L18 RecognitionException -> L20
        goto L30
    L17:
        throw new NoViableAltException(this);     // Catch: Throwable -> L18 RecognitionException -> L20
    L25:
        enterOuterAlt(r5, 3);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1458);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(158);     // Catch: Throwable -> L18 RecognitionException -> L20
    L20:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L18
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L18
        this._errHandler.recover(this, e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Module_argumentContext module_argument() throws RecognitionException {
        Module_argumentContext r5 = new Module_argumentContext(this._ctx, getState());
        enterRule(r5, 124, 62);
        setState(1484);     // Catch: Throwable -> L9 RecognitionException -> L11
        this._errHandler.sync(this);     // Catch: Throwable -> L9 RecognitionException -> L11
        int r10 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 215, this._ctx);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (r10 != 1) goto L6;
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(1482);     // Catch: Throwable -> L9 RecognitionException -> L11
        expr(0);     // Catch: Throwable -> L9 RecognitionException -> L11
    L20:
    L14:
        exitRule();
        return r5;
    L6:
        if (r10 != 2) goto L20;
        enterOuterAlt(r5, 2);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(1483);     // Catch: Throwable -> L9 RecognitionException -> L11
        column_def();     // Catch: Throwable -> L9 RecognitionException -> L11
    L11:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L9
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L9
        this._errHandler.recover(this, e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Module_nameContext module_name() throws RecognitionException {
        Module_nameContext r5 = new Module_nameContext(this._ctx, getState());
        enterRule(r5, 158, 79);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1527);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final NameContext name() throws RecognitionException {
        NameContext r5 = new NameContext(this._ctx, getState());
        enterRule(r5, 132, 66);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1501);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final New_table_nameContext new_table_name() throws RecognitionException {
        New_table_nameContext r5 = new New_table_nameContext(this._ctx, getState());
        enterRule(r5, 144, 72);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1513);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final Order_clauseContext order_clause() throws RecognitionException {
        Order_clauseContext r5 = new Order_clauseContext(this._ctx, getState());
        enterRule(r5, 92, 46);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1291);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(111);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1292);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(42);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1293);     // Catch: Throwable -> L8 RecognitionException -> L10
        ordering_term();     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1298);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r10 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
    L5:
        if (r10 != 5) goto L12;
        setState(1294);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(5);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1295);     // Catch: Throwable -> L8 RecognitionException -> L10
        ordering_term();     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(1300);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        r10 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
    L12:
        exitRule();
        return r5;
    L8:
        th = move-exception;
        exitRule();
        throw th;
    L10:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L8
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L8
        this._errHandler.recover(this, e);     // Catch: Throwable -> L8
        goto L12
    }

    public final Ordering_termContext ordering_term() throws RecognitionException {
        Ordering_termContext r5 = new Ordering_termContext(this._ctx, getState());
        enterRule(r5, 94, 47);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1301);     // Catch: Throwable -> L6 RecognitionException -> L8
        expr(0);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1304);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 47) goto L10;
        setState(1302);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(47);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1303);     // Catch: Throwable -> L6 RecognitionException -> L8
        collation_name();     // Catch: Throwable -> L6 RecognitionException -> L8
    L10:
        setState(1307);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r10 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r10 == 36) goto L13;
        if (r10 == 62) goto L13;
    L21:
        exitRule();
        return r5;
    L13:
        setState(1306);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r11 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r11 == 36) goto L18;
        if (r11 == 62) goto L18;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L6 RecognitionException -> L8
    L18:
        if (this._input.LA(1) != (-1)) goto L20;
        this.matchedEOF = true;     // Catch: Throwable -> L6 RecognitionException -> L8
    L20:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        consume();     // Catch: Throwable -> L6 RecognitionException -> L8
    L6:
        th = move-exception;
        exitRule();
        throw th;
    L8:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L6
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L6
        this._errHandler.recover(this, e);     // Catch: Throwable -> L6
        goto L21
    }

    public final ParseContext parse() throws RecognitionException {
        ParseContext r5 = new ParseContext(this._ctx, getState());
        enterRule(r5, 0, 0);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L20 RecognitionException -> L22
        setState(174);     // Catch: Throwable -> L20 RecognitionException -> L22
        this._errHandler.sync(this);     // Catch: Throwable -> L20 RecognitionException -> L22
        int r10 = this._input.LA(1);     // Catch: Throwable -> L20 RecognitionException -> L22
    L5:
        if ((r10 & (-64)) == 0) goto L7;
    L8:
        int r11 = r10 - 65;     // Catch: Throwable -> L20 RecognitionException -> L22
        if ((r11 & (-64)) == 0) goto L11;
    L12:
        int r12 = r10 - 129;     // Catch: Throwable -> L20 RecognitionException -> L22
        if ((r12 & (-64)) != 0) goto L27;
        if (((1 << r12) & 8591036419L) == 0) goto L27;
    L16:
        setState(172);     // Catch: Throwable -> L20 RecognitionException -> L22
        this._errHandler.sync(this);     // Catch: Throwable -> L20 RecognitionException -> L22
        switch(this._input.LA(1)) {
            case 1: goto L25;
            case 32: goto L25;
            case 33: goto L25;
            case 37: goto L25;
            case 40: goto L25;
            case 49: goto L25;
            case 52: goto L25;
            case 61: goto L25;
            case 63: goto L25;
            case 65: goto L25;
            case 68: goto L25;
            case 73: goto L25;
            case 90: goto L25;
            case 114: goto L25;
            case 121: goto L25;
            case 122: goto L25;
            case 124: goto L25;
            case 127: goto L25;
            case 129: goto L25;
            case 130: goto L25;
            case 141: goto L25;
            case 143: goto L25;
            case 144: goto L25;
            case 149: goto L25;
            case 162: goto L24;
            default: goto L19;
        };     // Catch: Throwable -> L20 RecognitionException -> L22
    L24:
        setState(171);     // Catch: Throwable -> L20 RecognitionException -> L22
        error();     // Catch: Throwable -> L20 RecognitionException -> L22
    L26:
        setState(176);     // Catch: Throwable -> L20 RecognitionException -> L22
        this._errHandler.sync(this);     // Catch: Throwable -> L20 RecognitionException -> L22
        r10 = this._input.LA(1);     // Catch: Throwable -> L20 RecognitionException -> L22
        goto L5
    L25:
        setState(170);     // Catch: Throwable -> L20 RecognitionException -> L22
        sql_stmt_list();     // Catch: Throwable -> L20 RecognitionException -> L22
        goto L26
    L19:
        throw new NoViableAltException(this);     // Catch: Throwable -> L20 RecognitionException -> L22
    L27:
        setState(177);     // Catch: Throwable -> L20 RecognitionException -> L22
        match(-1);     // Catch: Throwable -> L20 RecognitionException -> L22
    L28:
        exitRule();
        return r5;
    L11:
        if (((1 << r11) & 5404882502831571209L) != 0) goto L16;
    L7:
        if (((1 << r10) & (-6912461228224806910L)) != 0) goto L16;
    L20:
        th = move-exception;
        exitRule();
        throw th;
    L22:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L20
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L20
        this._errHandler.recover(this, e);     // Catch: Throwable -> L20
        goto L28
    }

    public final Pragma_nameContext pragma_name() throws RecognitionException {
        Pragma_nameContext r5 = new Pragma_nameContext(this._ctx, getState());
        enterRule(r5, 160, 80);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1529);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final Pragma_stmtContext pragma_stmt() throws RecognitionException {
        Pragma_stmtContext r5 = new Pragma_stmtContext(this._ctx, getState());
        enterRule(r5, 46, 23);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(691);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(114);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(695);     // Catch: Throwable -> L13 RecognitionException -> L15
        this._errHandler.sync(this);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 84, this._ctx) != 1) goto L7;
        setState(692);     // Catch: Throwable -> L13 RecognitionException -> L15
        schema_name();     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(693);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(2);     // Catch: Throwable -> L13 RecognitionException -> L15
    L7:
        setState(697);     // Catch: Throwable -> L13 RecognitionException -> L15
        pragma_name();     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(704);     // Catch: Throwable -> L13 RecognitionException -> L15
        this._errHandler.sync(this);     // Catch: Throwable -> L13 RecognitionException -> L15
        int r10 = this._input.LA(1);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r10 != 3) goto L10;
        setState(700);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(3);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(701);     // Catch: Throwable -> L13 RecognitionException -> L15
        pragma_value();     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(702);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(4);     // Catch: Throwable -> L13 RecognitionException -> L15
    L18:
        exitRule();
        return r5;
    L10:
        if (r10 != 6) goto L18;
        setState(698);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(6);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(699);     // Catch: Throwable -> L13 RecognitionException -> L15
        pragma_value();     // Catch: Throwable -> L13 RecognitionException -> L15
    L13:
        th = move-exception;
        exitRule();
        throw th;
    L15:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L13
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L13
        this._errHandler.recover(this, e);     // Catch: Throwable -> L13
        goto L18
    }

    public final Pragma_valueContext pragma_value() throws RecognitionException {
        Pragma_valueContext r5 = new Pragma_valueContext(this._ctx, getState());
        enterRule(r5, 98, 49);
        setState(1319);     // Catch: Throwable -> L13 RecognitionException -> L15
        this._errHandler.sync(this);     // Catch: Throwable -> L13 RecognitionException -> L15
        int r10 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 186, this._ctx);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r10 != 1) goto L6;
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(1315);     // Catch: Throwable -> L13 RecognitionException -> L15
        signed_number();     // Catch: Throwable -> L13 RecognitionException -> L15
    L26:
    L20:
        exitRule();
        return r5;
    L6:
        if (r10 != 2) goto L8;
        enterOuterAlt(r5, 2);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(1316);     // Catch: Throwable -> L13 RecognitionException -> L15
        name();     // Catch: Throwable -> L13 RecognitionException -> L15
        goto L26
    L8:
        if (r10 != 3) goto L10;
        enterOuterAlt(r5, 3);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(1317);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(157);     // Catch: Throwable -> L13 RecognitionException -> L15
        goto L26
    L10:
        if (r10 != 4) goto L26;
        enterOuterAlt(r5, 4);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(1318);     // Catch: Throwable -> L13 RecognitionException -> L15
        boolean_literal();     // Catch: Throwable -> L13 RecognitionException -> L15
    L15:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L13
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L13
        this._errHandler.recover(this, e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Qualified_table_nameContext qualified_table_name() throws RecognitionException {
        Qualified_table_nameContext r5 = new Qualified_table_nameContext(this._ctx, getState());
        enterRule(r5, 90, 45);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1277);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 179, this._ctx) != 1) goto L7;
        setState(1274);     // Catch: Throwable -> L10 RecognitionException -> L12
        schema_name();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1275);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(2);     // Catch: Throwable -> L10 RecognitionException -> L12
    L7:
        setState(1279);     // Catch: Throwable -> L10 RecognitionException -> L12
        table_name();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1282);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this._input.LA(1) != 35) goto L14;
        setState(1280);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(35);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1281);     // Catch: Throwable -> L10 RecognitionException -> L12
        table_alias();     // Catch: Throwable -> L10 RecognitionException -> L12
    L14:
        setState(1289);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r10 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r10 != 87) goto L17;
        setState(1284);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(87);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1285);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(42);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1286);     // Catch: Throwable -> L10 RecognitionException -> L12
        index_name();     // Catch: Throwable -> L10 RecognitionException -> L12
    L21:
        exitRule();
        return r5;
    L17:
        if (r10 != 104) goto L21;
        setState(1287);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(104);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1288);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(87);     // Catch: Throwable -> L10 RecognitionException -> L12
    L10:
        th = move-exception;
        exitRule();
        throw th;
    L12:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L10
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L10
        this._errHandler.recover(this, e);     // Catch: Throwable -> L10
        goto L21
    }

    public final Raise_functionContext raise_function() throws RecognitionException {
        Raise_functionContext r5 = new Raise_functionContext(this._ctx, getState());
        enterRule(r5, 80, 40);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1180);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(117);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1181);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(3);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1186);     // Catch: Throwable -> L12 RecognitionException -> L14
        this._errHandler.sync(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r10 = this._input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r10 == 27) goto L17;
        if (r10 == 74) goto L17;
        if (r10 == 83) goto L16;
        if (r10 == 127) goto L17;
        throw new NoViableAltException(this);     // Catch: Throwable -> L12 RecognitionException -> L14
    L16:
        setState(1182);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(83);     // Catch: Throwable -> L12 RecognitionException -> L14
    L27:
        setState(1188);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(4);     // Catch: Throwable -> L12 RecognitionException -> L14
    L28:
        exitRule();
        return r5;
    L17:
        setState(1183);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r11 = this._input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r11 == 27) goto L23;
        if (r11 == 74) goto L23;
        if (r11 == 127) goto L23;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L12 RecognitionException -> L14
    L26:
        setState(1184);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(5);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1185);     // Catch: Throwable -> L12 RecognitionException -> L14
        error_message();     // Catch: Throwable -> L12 RecognitionException -> L14
    L23:
        if (this._input.LA(1) != (-1)) goto L25;
        this.matchedEOF = true;     // Catch: Throwable -> L12 RecognitionException -> L14
    L25:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        consume();     // Catch: Throwable -> L12 RecognitionException -> L14
    L12:
        th = move-exception;
        exitRule();
        throw th;
    L14:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L12
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L12
        this._errHandler.recover(this, e);     // Catch: Throwable -> L12
        goto L28
    }

    public final Reindex_stmtContext reindex_stmt() throws RecognitionException {
        Reindex_stmtContext r5 = new Reindex_stmtContext(this._ctx, getState());
        enterRule(r5, 48, 24);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(706);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(121);     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(717);     // Catch: Throwable -> L17 RecognitionException -> L19
        this._errHandler.sync(this);     // Catch: Throwable -> L17 RecognitionException -> L19
        int r10 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 88, this._ctx);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r10 != 1) goto L6;
        setState(707);     // Catch: Throwable -> L17 RecognitionException -> L19
        collation_name();     // Catch: Throwable -> L17 RecognitionException -> L19
    L23:
        exitRule();
        return r5;
    L6:
        if (r10 != 2) goto L23;
        setState(711);     // Catch: Throwable -> L17 RecognitionException -> L19
        this._errHandler.sync(this);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 86, this._ctx) != 1) goto L12;
        setState(708);     // Catch: Throwable -> L17 RecognitionException -> L19
        schema_name();     // Catch: Throwable -> L17 RecognitionException -> L19
        setState(709);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(2);     // Catch: Throwable -> L17 RecognitionException -> L19
    L12:
        setState(715);     // Catch: Throwable -> L17 RecognitionException -> L19
        this._errHandler.sync(this);     // Catch: Throwable -> L17 RecognitionException -> L19
        int r11 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 87, this._ctx);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r11 == 1) goto L21;
        if (r11 != 2) goto L23;
        setState(714);     // Catch: Throwable -> L17 RecognitionException -> L19
        index_name();     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L23
    L21:
        setState(713);     // Catch: Throwable -> L17 RecognitionException -> L19
        table_name();     // Catch: Throwable -> L17 RecognitionException -> L19
    L19:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L17
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L17
        this._errHandler.recover(this, e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Release_stmtContext release_stmt() throws RecognitionException {
        Release_stmtContext r5 = new Release_stmtContext(this._ctx, getState());
        enterRule(r5, 50, 25);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(719);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(122);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(721);     // Catch: Throwable -> L9 RecognitionException -> L11
        this._errHandler.sync(this);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 89, this._ctx) != 1) goto L7;
        setState(720);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(129);     // Catch: Throwable -> L9 RecognitionException -> L11
    L7:
        setState(723);     // Catch: Throwable -> L9 RecognitionException -> L11
        savepoint_name();     // Catch: Throwable -> L9 RecognitionException -> L11
    L8:
        exitRule();
        return r5;
    L9:
        th = move-exception;
        exitRule();
        throw th;
    L11:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L9
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L9
        this._errHandler.recover(this, e);     // Catch: Throwable -> L9
        goto L8
    }

    public final Result_columnContext result_column() throws RecognitionException {
        Result_columnContext r5 = new Result_columnContext(this._ctx, getState());
        enterRule(r5, 100, 50);
        setState(1333);     // Catch: Throwable -> L19 RecognitionException -> L21
        this._errHandler.sync(this);     // Catch: Throwable -> L19 RecognitionException -> L21
        int r10 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 189, this._ctx);     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r10 != 1) goto L6;
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L19 RecognitionException -> L21
        setState(1321);     // Catch: Throwable -> L19 RecognitionException -> L21
        match(7);     // Catch: Throwable -> L19 RecognitionException -> L21
    L26:
        exitRule();
        return r5;
    L6:
        if (r10 != 2) goto L8;
        enterOuterAlt(r5, 2);     // Catch: Throwable -> L19 RecognitionException -> L21
        setState(1322);     // Catch: Throwable -> L19 RecognitionException -> L21
        table_name();     // Catch: Throwable -> L19 RecognitionException -> L21
        setState(1323);     // Catch: Throwable -> L19 RecognitionException -> L21
        match(2);     // Catch: Throwable -> L19 RecognitionException -> L21
        setState(1324);     // Catch: Throwable -> L19 RecognitionException -> L21
        match(7);     // Catch: Throwable -> L19 RecognitionException -> L21
        goto L26
    L8:
        if (r10 != 3) goto L26;
        enterOuterAlt(r5, 3);     // Catch: Throwable -> L19 RecognitionException -> L21
        setState(1326);     // Catch: Throwable -> L19 RecognitionException -> L21
        expr(0);     // Catch: Throwable -> L19 RecognitionException -> L21
        setState(1331);     // Catch: Throwable -> L19 RecognitionException -> L21
        this._errHandler.sync(this);     // Catch: Throwable -> L19 RecognitionException -> L21
        int r11 = this._input.LA(1);     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r11 != 35) goto L13;
    L16:
        setState(1328);     // Catch: Throwable -> L19 RecognitionException -> L21
        this._errHandler.sync(this);     // Catch: Throwable -> L19 RecognitionException -> L21
        if (this._input.LA(1) != 35) goto L23;
        setState(1327);     // Catch: Throwable -> L19 RecognitionException -> L21
        match(35);     // Catch: Throwable -> L19 RecognitionException -> L21
    L23:
        setState(1330);     // Catch: Throwable -> L19 RecognitionException -> L21
        column_alias();     // Catch: Throwable -> L19 RecognitionException -> L21
        goto L26
    L13:
        if (r11 == 154) goto L16;
        if (r11 != 157) goto L26;
    L21:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L19
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L19
        this._errHandler.recover(this, e);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Rollback_stmtContext rollback_stmt() throws RecognitionException {
        Rollback_stmtContext r5 = new Rollback_stmtContext(this._ctx, getState());
        enterRule(r5, 52, 26);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(725);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(127);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(730);     // Catch: Throwable -> L9 RecognitionException -> L11
        this._errHandler.sync(this);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (this._input.LA(1) != 137) goto L13;
        setState(726);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(137);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(728);     // Catch: Throwable -> L9 RecognitionException -> L11
        this._errHandler.sync(this);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 90, this._ctx) != 1) goto L13;
        setState(727);     // Catch: Throwable -> L9 RecognitionException -> L11
        transaction_name();     // Catch: Throwable -> L9 RecognitionException -> L11
    L13:
        setState(737);     // Catch: Throwable -> L9 RecognitionException -> L11
        this._errHandler.sync(this);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (this._input.LA(1) != 136) goto L20;
        setState(732);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(136);     // Catch: Throwable -> L9 RecognitionException -> L11
        setState(734);     // Catch: Throwable -> L9 RecognitionException -> L11
        this._errHandler.sync(this);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 92, this._ctx) != 1) goto L19;
        setState(733);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(129);     // Catch: Throwable -> L9 RecognitionException -> L11
    L19:
        setState(736);     // Catch: Throwable -> L9 RecognitionException -> L11
        savepoint_name();     // Catch: Throwable -> L9 RecognitionException -> L11
    L20:
        exitRule();
        return r5;
    L9:
        th = move-exception;
        exitRule();
        throw th;
    L11:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L9
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L9
        this._errHandler.recover(this, e);     // Catch: Throwable -> L9
        goto L20
    }

    public final Savepoint_nameContext savepoint_name() throws RecognitionException {
        Savepoint_nameContext r5 = new Savepoint_nameContext(this._ctx, getState());
        enterRule(r5, 162, 81);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1531);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final Savepoint_stmtContext savepoint_stmt() throws RecognitionException {
        Savepoint_stmtContext r5 = new Savepoint_stmtContext(this._ctx, getState());
        enterRule(r5, 54, 27);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(739);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(129);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(740);     // Catch: Throwable -> L5 RecognitionException -> L7
        savepoint_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final Schema_nameContext schema_name() throws RecognitionException {
        Schema_nameContext r5 = new Schema_nameContext(this._ctx, getState());
        enterRule(r5, 136, 68);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1505);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final Select_or_valuesContext select_or_values() throws RecognitionException {
        Select_or_valuesContext r5 = new Select_or_valuesContext(this._ctx, getState());
        enterRule(r5, 58, 29);
        setState(813);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r10 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r10 != 130) goto L6;
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(760);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(130);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(762);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 98, this._ctx) != 1) goto L28;
        setState(761);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r11 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r11 == 31) goto L25;
        if (r11 == 64) goto L25;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L10 RecognitionException -> L12
    L25:
        if (this._input.LA(1) != (-1)) goto L27;
        this.matchedEOF = true;     // Catch: Throwable -> L10 RecognitionException -> L12
    L27:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        consume();     // Catch: Throwable -> L10 RecognitionException -> L12
    L28:
        setState(764);     // Catch: Throwable -> L10 RecognitionException -> L12
        result_column();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(769);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r12 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
    L29:
        if (r12 != 5) goto L31;
        setState(765);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(5);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(766);     // Catch: Throwable -> L10 RecognitionException -> L12
        result_column();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(771);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        r12 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L29
    L31:
        setState(784);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this._input.LA(1) != 77) goto L41;
        setState(772);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(77);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(782);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r13 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 101, this._ctx);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r13 == 1) goto L38;
        if (r13 != 2) goto L41;
        setState(781);     // Catch: Throwable -> L10 RecognitionException -> L12
        join_clause();     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L41
    L38:
        setState(773);     // Catch: Throwable -> L10 RecognitionException -> L12
        table_or_subquery();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(778);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r14 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
    L39:
        if (r14 != 5) goto L41;
        setState(774);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(5);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(775);     // Catch: Throwable -> L10 RecognitionException -> L12
        table_or_subquery();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(780);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        r14 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
    L41:
        setState(788);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this._input.LA(1) != 148) goto L44;
        setState(786);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(148);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(787);     // Catch: Throwable -> L10 RecognitionException -> L12
        expr(0);     // Catch: Throwable -> L10 RecognitionException -> L12
    L44:
        setState(797);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this._input.LA(1) != 80) goto L49;
        setState(790);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(80);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(791);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(42);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(792);     // Catch: Throwable -> L10 RecognitionException -> L12
        comma_separated_expr();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(795);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this._input.LA(1) != 81) goto L49;
        setState(793);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(81);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(794);     // Catch: Throwable -> L10 RecognitionException -> L12
        expr(0);     // Catch: Throwable -> L10 RecognitionException -> L12
    L49:
        exitRule();
        return r5;
    L6:
        if (r10 != 144) goto L15;
        enterOuterAlt(r5, 2);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(799);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(144);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(800);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(3);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(801);     // Catch: Throwable -> L10 RecognitionException -> L12
        comma_separated_expr();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(802);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(4);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(810);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r15 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
    L8:
        if (r15 != 5) goto L49;
        setState(803);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(5);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(804);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(3);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(805);     // Catch: Throwable -> L10 RecognitionException -> L12
        comma_separated_expr();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(806);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(4);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(812);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        r15 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L8
    L15:
        throw new NoViableAltException(this);     // Catch: Throwable -> L10 RecognitionException -> L12
    L10:
        th = move-exception;
        exitRule();
        throw th;
    L12:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L10
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L10
        this._errHandler.recover(this, e);     // Catch: Throwable -> L10
        goto L49
    }

    public final Select_stmtContext select_stmt() throws RecognitionException {
        Select_stmtContext r5 = new Select_stmtContext(this._ctx, getState());
        enterRule(r5, 56, 28);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(743);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 149) goto L10;
        setState(742);     // Catch: Throwable -> L6 RecognitionException -> L8
        with_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
    L10:
        setState(745);     // Catch: Throwable -> L6 RecognitionException -> L8
        select_or_values();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(751);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r10 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
    L12:
        if (r10 == 70) goto L26;
        if (r10 == 92) goto L26;
        if (r10 == 139) goto L26;
        setState(755);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 111) goto L21;
        setState(754);     // Catch: Throwable -> L6 RecognitionException -> L8
        order_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
    L21:
        setState(758);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 100) goto L24;
        setState(757);     // Catch: Throwable -> L6 RecognitionException -> L8
        limit_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
    L24:
        exitRule();
        return r5;
    L26:
        setState(746);     // Catch: Throwable -> L6 RecognitionException -> L8
        compound_operator();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(747);     // Catch: Throwable -> L6 RecognitionException -> L8
        select_or_values();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(753);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        r10 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
    L6:
        th = move-exception;
        exitRule();
        throw th;
    L8:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L6
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L6
        this._errHandler.recover(this, e);     // Catch: Throwable -> L6
        goto L24
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public boolean sempred(RuleContext r5, int r10, int r11) {
        if (r10 == 37) goto L7;
        return true;
    L7:
        return expr_sempred((ExprContext) r5, r11);
    }

    public final Signed_numberContext signed_number() throws RecognitionException {
        Signed_numberContext r5 = new Signed_numberContext(this._ctx, getState());
        enterRule(r5, 112, 56);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1452);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r10 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r10 == 8) goto L6;
        if (r10 == 9) goto L6;
    L18:
        setState(1454);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(155);     // Catch: Throwable -> L10 RecognitionException -> L12
    L19:
        exitRule();
        return r5;
    L6:
        setState(1451);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r11 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r11 == 8) goto L15;
        if (r11 == 9) goto L15;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L10 RecognitionException -> L12
    L15:
        if (this._input.LA(1) != (-1)) goto L17;
        this.matchedEOF = true;     // Catch: Throwable -> L10 RecognitionException -> L12
    L17:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        consume();     // Catch: Throwable -> L10 RecognitionException -> L12
    L10:
        th = move-exception;
        exitRule();
        throw th;
    L12:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L10
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L10
        this._errHandler.recover(this, e);     // Catch: Throwable -> L10
        goto L19
    }

    public final Sql_stmtContext sql_stmt() throws RecognitionException {
        Sql_stmtContext r5 = new Sql_stmtContext(this._ctx, getState());
        enterRule(r5, 6, 3);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(211);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (this._input.LA(1) != 73) goto L12;
        setState(ComposerKt.referenceKey);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(73);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(209);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (this._input.LA(1) != 116) goto L12;
        setState(ComposerKt.reuseKey);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(116);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(208);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(113);     // Catch: Throwable -> L8 RecognitionException -> L10
    L12:
        setState(240);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        switch(((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 8, this._ctx)) {
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L35;
            case 8: goto L34;
            case 9: goto L33;
            case 10: goto L32;
            case 11: goto L31;
            case 12: goto L30;
            case 13: goto L29;
            case 14: goto L28;
            case 15: goto L27;
            case 16: goto L26;
            case 17: goto L25;
            case 18: goto L24;
            case 19: goto L23;
            case 20: goto L22;
            case 21: goto L21;
            case 22: goto L20;
            case 23: goto L19;
            case 24: goto L18;
            case 25: goto L17;
            case 26: goto L16;
            case 27: goto L15;
            default: goto L42;
        };     // Catch: Throwable -> L8 RecognitionException -> L10
    L15:
        setState(239);     // Catch: Throwable -> L8 RecognitionException -> L10
        vacuum_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L16:
        setState(238);     // Catch: Throwable -> L8 RecognitionException -> L10
        update_stmt_limited();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L17:
        setState(237);     // Catch: Throwable -> L8 RecognitionException -> L10
        update_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L18:
        setState(236);     // Catch: Throwable -> L8 RecognitionException -> L10
        select_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L19:
        setState(235);     // Catch: Throwable -> L8 RecognitionException -> L10
        savepoint_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L20:
        setState(234);     // Catch: Throwable -> L8 RecognitionException -> L10
        rollback_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L21:
        setState(233);     // Catch: Throwable -> L8 RecognitionException -> L10
        release_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L22:
        setState(232);     // Catch: Throwable -> L8 RecognitionException -> L10
        reindex_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L23:
        setState(231);     // Catch: Throwable -> L8 RecognitionException -> L10
        pragma_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L24:
        setState(230);     // Catch: Throwable -> L8 RecognitionException -> L10
        insert_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L25:
        setState(229);     // Catch: Throwable -> L8 RecognitionException -> L10
        drop_view_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L26:
        setState(228);     // Catch: Throwable -> L8 RecognitionException -> L10
        drop_trigger_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L27:
        setState(227);     // Catch: Throwable -> L8 RecognitionException -> L10
        drop_table_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L28:
        setState(226);     // Catch: Throwable -> L8 RecognitionException -> L10
        drop_index_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L29:
        setState(225);     // Catch: Throwable -> L8 RecognitionException -> L10
        detach_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L30:
        setState(224);     // Catch: Throwable -> L8 RecognitionException -> L10
        delete_stmt_limited();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L31:
        setState(223);     // Catch: Throwable -> L8 RecognitionException -> L10
        delete_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L32:
        setState(222);     // Catch: Throwable -> L8 RecognitionException -> L10
        create_virtual_table_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L33:
        setState(221);     // Catch: Throwable -> L8 RecognitionException -> L10
        create_view_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L34:
        setState(220);     // Catch: Throwable -> L8 RecognitionException -> L10
        create_trigger_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L35:
        setState(219);     // Catch: Throwable -> L8 RecognitionException -> L10
        create_table_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L36:
        setState(218);     // Catch: Throwable -> L8 RecognitionException -> L10
        create_index_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L37:
        setState(Constant.SDK_VERSION);     // Catch: Throwable -> L8 RecognitionException -> L10
        commit_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L38:
        setState(216);     // Catch: Throwable -> L8 RecognitionException -> L10
        begin_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L39:
        setState(215);     // Catch: Throwable -> L8 RecognitionException -> L10
        attach_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L40:
        setState(214);     // Catch: Throwable -> L8 RecognitionException -> L10
        analyze_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L42
    L41:
        setState(213);     // Catch: Throwable -> L8 RecognitionException -> L10
        alter_table_stmt();     // Catch: Throwable -> L8 RecognitionException -> L10
    L42:
        exitRule();
        return r5;
    L10:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L8
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L8
        this._errHandler.recover(this, e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Sql_stmt_listContext sql_stmt_list() throws RecognitionException {
        Sql_stmt_listContext r5 = new Sql_stmt_listContext(this._ctx, getState());
        enterRule(r5, 4, 2);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(185);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r10 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
    L4:
        if (r10 != 1) goto L10;
        setState(182);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(187);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        r10 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L4
    L10:
        setState(188);     // Catch: Throwable -> L6 RecognitionException -> L8
        sql_stmt();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(197);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r11 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 4, this._ctx);     // Catch: Throwable -> L6 RecognitionException -> L8
    L11:
        if (r11 == 2) goto L19;
        if (r11 == 0) goto L19;
        if (r11 != 1) goto L18;
        setState(190);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
    L15:
        setState(189);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(192);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) == 1) goto L15;
        setState(194);     // Catch: Throwable -> L6 RecognitionException -> L8
        sql_stmt();     // Catch: Throwable -> L6 RecognitionException -> L8
    L18:
        setState(199);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        r11 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 4, this._ctx);     // Catch: Throwable -> L6 RecognitionException -> L8
    L19:
        setState(ComposerKt.providerValuesKey);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r12 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 5, this._ctx);     // Catch: Throwable -> L6 RecognitionException -> L8
    L20:
        if (r12 == 2) goto L26;
        if (r12 == 0) goto L26;
        if (r12 != 1) goto L24;
        setState(200);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(1);     // Catch: Throwable -> L6 RecognitionException -> L8
    L24:
        setState(205);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        r12 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 5, this._ctx);     // Catch: Throwable -> L6 RecognitionException -> L8
    L26:
        exitRule();
        return r5;
    L8:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L6
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L6
        this._errHandler.recover(this, e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Table_aliasContext table_alias() throws RecognitionException {
        Table_aliasContext r5 = new Table_aliasContext(this._ctx, getState());
        enterRule(r5, 164, 82);
        setState(1539);     // Catch: Throwable -> L10 RecognitionException -> L12
        this._errHandler.sync(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r10 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r10 != 3) goto L6;
        enterOuterAlt(r5, 3);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1535);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(3);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1536);     // Catch: Throwable -> L10 RecognitionException -> L12
        table_alias();     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1537);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(4);     // Catch: Throwable -> L10 RecognitionException -> L12
    L18:
        exitRule();
        return r5;
    L6:
        if (r10 != 154) goto L8;
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1533);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(154);     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L18
    L8:
        if (r10 != 157) goto L15;
        enterOuterAlt(r5, 2);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1534);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(157);     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L18
    L15:
        throw new NoViableAltException(this);     // Catch: Throwable -> L10 RecognitionException -> L12
    L12:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L10
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L10
        this._errHandler.recover(this, e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Table_constraintContext table_constraint() throws RecognitionException {
        Table_constraintContext r5 = new Table_constraintContext(this._ctx, getState());
        enterRule(r5, 84, 42);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1203);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 51) goto L10;
        setState(LynxErrorCode.LYNX_ERROR_MAIN_FLOW);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(51);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1202);     // Catch: Throwable -> L6 RecognitionException -> L8
        name();     // Catch: Throwable -> L6 RecognitionException -> L8
    L10:
        setState(1241);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r10 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r10 != 46) goto L13;
        setState(1222);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(46);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1223);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(3);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1224);     // Catch: Throwable -> L6 RecognitionException -> L8
        expr(0);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1225);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(4);     // Catch: Throwable -> L6 RecognitionException -> L8
    L36:
        exitRule();
        return r5;
    L13:
        if (r10 != 76) goto L15;
        setState(1227);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(76);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1228);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(97);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1229);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(3);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1230);     // Catch: Throwable -> L6 RecognitionException -> L8
        column_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1235);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r11 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
    L32:
        if (r11 != 5) goto L34;
        setState(1231);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(5);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1232);     // Catch: Throwable -> L6 RecognitionException -> L8
        column_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1237);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        r11 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L32
    L34:
        setState(1238);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(4);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1239);     // Catch: Throwable -> L6 RecognitionException -> L8
        foreign_key_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L36
    L15:
        if (r10 == 115) goto L20;
        if (r10 == 140) goto L20;
        throw new NoViableAltException(this);     // Catch: Throwable -> L6 RecognitionException -> L8
    L20:
        setState(1208);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r12 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r12 == 115) goto L26;
        if (r12 != 140) goto L25;
        setState(1207);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(140);     // Catch: Throwable -> L6 RecognitionException -> L8
    L27:
        setState(1210);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(3);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1211);     // Catch: Throwable -> L6 RecognitionException -> L8
        indexed_column();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1216);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r13 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
    L28:
        if (r13 != 5) goto L30;
        setState(1212);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(5);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1213);     // Catch: Throwable -> L6 RecognitionException -> L8
        indexed_column();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1218);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        r13 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L28
    L30:
        setState(1219);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(4);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1220);     // Catch: Throwable -> L6 RecognitionException -> L8
        conflict_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L36
    L25:
        throw new NoViableAltException(this);     // Catch: Throwable -> L6 RecognitionException -> L8
    L26:
        setState(1205);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(115);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(1206);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(97);     // Catch: Throwable -> L6 RecognitionException -> L8
    L6:
        th = move-exception;
        exitRule();
        throw th;
    L8:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L6
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L6
        this._errHandler.recover(this, e);     // Catch: Throwable -> L6
        goto L36
    }

    public final Table_functionContext table_function() throws RecognitionException {
        Table_functionContext r5 = new Table_functionContext(this._ctx, getState());
        enterRule(r5, 138, 69);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1507);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final Table_nameContext table_name() throws RecognitionException {
        Table_nameContext r5 = new Table_nameContext(this._ctx, getState());
        enterRule(r5, 140, 70);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1509);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final Table_or_index_nameContext table_or_index_name() throws RecognitionException {
        Table_or_index_nameContext r5 = new Table_or_index_nameContext(this._ctx, getState());
        enterRule(r5, 142, 71);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1511);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final Table_or_subqueryContext table_or_subquery() throws RecognitionException {
        Table_or_subqueryContext r5 = new Table_or_subqueryContext(this._ctx, getState());
        enterRule(r5, 102, 51);
        setState(1401);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        int r10 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, ComposerKt.providerValuesKey, this._ctx);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (r10 != 1) goto L6;
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1338);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 190, this._ctx) != 1) goto L64;
        setState(1335);     // Catch: Throwable -> L18 RecognitionException -> L20
        schema_name();     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1336);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(2);     // Catch: Throwable -> L18 RecognitionException -> L20
    L64:
        setState(1340);     // Catch: Throwable -> L18 RecognitionException -> L20
        table_name();     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1345);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        int r11 = this._input.LA(1);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (r11 == 3) goto L69;
        if (r11 == 35) goto L69;
        if (r11 == 154) goto L69;
        if (r11 == 157) goto L69;
    L73:
        setState(1352);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        int r12 = this._input.LA(1);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (r12 != 87) goto L76;
        setState(1347);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(87);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1348);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(42);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1349);     // Catch: Throwable -> L18 RecognitionException -> L20
        index_name();     // Catch: Throwable -> L18 RecognitionException -> L20
    L80:
        exitRule();
        return r5;
    L76:
        if (r12 != 104) goto L80;
        setState(1350);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(104);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1351);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(87);     // Catch: Throwable -> L18 RecognitionException -> L20
    L69:
        setState(1342);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (this._input.LA(1) != 35) goto L72;
        setState(1341);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(35);     // Catch: Throwable -> L18 RecognitionException -> L20
    L72:
        setState(1344);     // Catch: Throwable -> L18 RecognitionException -> L20
        table_alias();     // Catch: Throwable -> L18 RecognitionException -> L20
        goto L73
    L6:
        if (r10 == 2) goto L32;
        if (r10 == 3) goto L23;
        if (r10 != 4) goto L80;
        enterOuterAlt(r5, 4);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1392);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(3);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1393);     // Catch: Throwable -> L18 RecognitionException -> L20
        select_stmt();     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1394);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(4);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1399);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        int r13 = this._input.LA(1);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (r13 == 3) goto L15;
        if (r13 == 35) goto L15;
        if (r13 == 154) goto L15;
        if (r13 != 157) goto L80;
    L15:
        setState(1396);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (this._input.LA(1) != 35) goto L22;
        setState(1395);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(35);     // Catch: Throwable -> L18 RecognitionException -> L20
    L22:
        setState(1398);     // Catch: Throwable -> L18 RecognitionException -> L20
        table_alias();     // Catch: Throwable -> L18 RecognitionException -> L20
        goto L80
    L23:
        enterOuterAlt(r5, 3);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1378);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(3);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1388);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        int r14 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 200, this._ctx);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (r14 == 1) goto L28;
        if (r14 != 2) goto L31;
        setState(1387);     // Catch: Throwable -> L18 RecognitionException -> L20
        join_clause();     // Catch: Throwable -> L18 RecognitionException -> L20
    L31:
        setState(1390);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(4);     // Catch: Throwable -> L18 RecognitionException -> L20
        goto L80
    L28:
        setState(1379);     // Catch: Throwable -> L18 RecognitionException -> L20
        table_or_subquery();     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1384);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        int r15 = this._input.LA(1);     // Catch: Throwable -> L18 RecognitionException -> L20
    L29:
        if (r15 != 5) goto L31;
        setState(1380);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(5);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1381);     // Catch: Throwable -> L18 RecognitionException -> L20
        table_or_subquery();     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1386);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        r15 = this._input.LA(1);     // Catch: Throwable -> L18 RecognitionException -> L20
        goto L29
    L32:
        enterOuterAlt(r5, 2);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1357);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 194, this._ctx) != 1) goto L36;
        setState(1354);     // Catch: Throwable -> L18 RecognitionException -> L20
        schema_name();     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1355);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(2);     // Catch: Throwable -> L18 RecognitionException -> L20
    L36:
        setState(1359);     // Catch: Throwable -> L18 RecognitionException -> L20
        table_function();     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1360);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(3);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1369);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        int r16 = this._input.LA(1);     // Catch: Throwable -> L18 RecognitionException -> L20
        if ((r16 & (-64)) == 0) goto L39;
    L40:
        int r17 = r16 - 64;     // Catch: Throwable -> L18 RecognitionException -> L20
        if ((r17 & (-64)) == 0) goto L43;
    L44:
        int r18 = r16 - 128;     // Catch: Throwable -> L18 RecognitionException -> L20
        if ((r18 & (-64)) == 0) goto L47;
    L51:
        setState(1371);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(4);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1376);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        int r19 = this._input.LA(1);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (r19 == 3) goto L56;
        if (r19 == 35) goto L56;
        if (r19 == 154) goto L56;
        if (r19 != 157) goto L80;
    L56:
        setState(1373);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (this._input.LA(1) != 35) goto L59;
        setState(1372);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(35);     // Catch: Throwable -> L18 RecognitionException -> L20
    L59:
        setState(1375);     // Catch: Throwable -> L18 RecognitionException -> L20
        table_alias();     // Catch: Throwable -> L18 RecognitionException -> L20
        goto L80
    L47:
        if (((1 << r18) & 2088763391) == 0) goto L51;
    L48:
        setState(1361);     // Catch: Throwable -> L18 RecognitionException -> L20
        expr(0);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1366);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        int r20 = this._input.LA(1);     // Catch: Throwable -> L18 RecognitionException -> L20
    L49:
        if (r20 != 5) goto L51;
        setState(1362);     // Catch: Throwable -> L18 RecognitionException -> L20
        match(5);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1363);     // Catch: Throwable -> L18 RecognitionException -> L20
        expr(0);     // Catch: Throwable -> L18 RecognitionException -> L20
        setState(1368);     // Catch: Throwable -> L18 RecognitionException -> L20
        this._errHandler.sync(this);     // Catch: Throwable -> L18 RecognitionException -> L20
        r20 = this._input.LA(1);     // Catch: Throwable -> L18 RecognitionException -> L20
        goto L49
    L43:
        if ((1 << r17) != 0) goto L48;
    L39:
        if (((1 << r16) & (-33552632)) != 0) goto L48;
    L18:
        th = move-exception;
        exitRule();
        throw th;
    L20:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L18
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L18
        this._errHandler.recover(this, e);     // Catch: Throwable -> L18
        goto L80
    }

    public final Transaction_nameContext transaction_name() throws RecognitionException {
        Transaction_nameContext r5 = new Transaction_nameContext(this._ctx, getState());
        enterRule(r5, 166, 83);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1541);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final Trigger_nameContext trigger_name() throws RecognitionException {
        Trigger_nameContext r5 = new Trigger_nameContext(this._ctx, getState());
        enterRule(r5, 154, 77);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1523);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final Type_nameContext type_name() throws RecognitionException {
        Type_nameContext r5 = new Type_nameContext(this._ctx, getState());
        enterRule(r5, 68, 34);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(918);     // Catch: Throwable -> L13 RecognitionException -> L15
        this._errHandler.sync(this);     // Catch: Throwable -> L13 RecognitionException -> L15
        int r10 = 2;
    L4:
        if (r10 != 2) goto L20;
        setState(917);     // Catch: Throwable -> L13 RecognitionException -> L15
        name();     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(920);     // Catch: Throwable -> L13 RecognitionException -> L15
        this._errHandler.sync(this);     // Catch: Throwable -> L13 RecognitionException -> L15
        r10 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 125, this._ctx);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r10 == 1) goto L8;
        if (r10 != 0) goto L4;
    L8:
        setState(932);     // Catch: Throwable -> L13 RecognitionException -> L15
        this._errHandler.sync(this);     // Catch: Throwable -> L13 RecognitionException -> L15
        int r11 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 126, this._ctx);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r11 == 1) goto L17;
        if (r11 != 2) goto L18;
        setState(926);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(3);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(927);     // Catch: Throwable -> L13 RecognitionException -> L15
        signed_number();     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(928);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(5);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(929);     // Catch: Throwable -> L13 RecognitionException -> L15
        signed_number();     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(930);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(4);     // Catch: Throwable -> L13 RecognitionException -> L15
    L18:
        exitRule();
        return r5;
    L17:
        setState(922);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(3);     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(923);     // Catch: Throwable -> L13 RecognitionException -> L15
        signed_number();     // Catch: Throwable -> L13 RecognitionException -> L15
        setState(924);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(4);     // Catch: Throwable -> L13 RecognitionException -> L15
        goto L18
    L20:
        throw new NoViableAltException(this);     // Catch: Throwable -> L13 RecognitionException -> L15
    L15:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L13
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L13
        this._errHandler.recover(this, e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Unary_operatorContext unary_operator() throws RecognitionException {
        Unary_operatorContext r5 = new Unary_operatorContext(this._ctx, getState());
        enterRule(r5, 118, 59);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L10 RecognitionException -> L12
        setState(1468);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r10 = this._input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if ((r10 & (-64)) != 0) goto L8;
        if (((1 << r10) & 1792) == 0) goto L8;
    L15:
        if (this._input.LA(1) != (-1)) goto L17;
        this.matchedEOF = true;     // Catch: Throwable -> L10 RecognitionException -> L12
    L17:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L10 RecognitionException -> L12
        consume();     // Catch: Throwable -> L10 RecognitionException -> L12
    L18:
        exitRule();
        return r5;
    L8:
        if (r10 == 104) goto L15;
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L10 RecognitionException -> L12
    L12:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L10
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L10
        this._errHandler.recover(this, e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Update_stmtContext update_stmt() throws RecognitionException {
        Update_stmtContext r5 = new Update_stmtContext(this._ctx, getState());
        enterRule(r5, 60, 30);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(816);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 149) goto L10;
        setState(815);     // Catch: Throwable -> L6 RecognitionException -> L8
        with_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
    L10:
        setState(818);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(141);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(829);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r10 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 109, this._ctx);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r10 == 1) goto L23;
        if (r10 != 2) goto L14;
        setState(821);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(110);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(822);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(27);     // Catch: Throwable -> L6 RecognitionException -> L8
    L24:
        setState(831);     // Catch: Throwable -> L6 RecognitionException -> L8
        qualified_table_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(832);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(131);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(835);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r11 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 110, this._ctx);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r11 == 1) goto L29;
        if (r11 != 2) goto L30;
        setState(834);     // Catch: Throwable -> L6 RecognitionException -> L8
        column_name_list();     // Catch: Throwable -> L6 RecognitionException -> L8
    L30:
        setState(837);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(6);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(838);     // Catch: Throwable -> L6 RecognitionException -> L8
        expr(0);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(849);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r12 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
    L31:
        if (r12 != 5) goto L39;
        setState(839);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(5);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(842);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r13 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 111, this._ctx);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r13 == 1) goto L37;
        if (r13 != 2) goto L38;
        setState(841);     // Catch: Throwable -> L6 RecognitionException -> L8
        column_name_list();     // Catch: Throwable -> L6 RecognitionException -> L8
    L38:
        setState(844);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(6);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(845);     // Catch: Throwable -> L6 RecognitionException -> L8
        expr(0);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(851);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        r12 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L31
    L37:
        setState(840);     // Catch: Throwable -> L6 RecognitionException -> L8
        column_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L38
    L39:
        setState(854);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 148) goto L42;
        setState(852);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(148);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(853);     // Catch: Throwable -> L6 RecognitionException -> L8
        expr(0);     // Catch: Throwable -> L6 RecognitionException -> L8
    L42:
        exitRule();
        return r5;
    L29:
        setState(833);     // Catch: Throwable -> L6 RecognitionException -> L8
        column_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L30
    L14:
        if (r10 != 3) goto L16;
        setState(823);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(110);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(824);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(124);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L24
    L16:
        if (r10 == 4) goto L20;
        if (r10 != 5) goto L24;
        setState(827);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(110);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(828);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(83);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L24
    L20:
        setState(825);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(110);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(826);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(74);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L24
    L23:
        setState(819);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(110);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(820);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(127);     // Catch: Throwable -> L6 RecognitionException -> L8
    L6:
        th = move-exception;
        exitRule();
        throw th;
    L8:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L6
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L6
        this._errHandler.recover(this, e);     // Catch: Throwable -> L6
        goto L42
    }

    public final Update_stmt_limitedContext update_stmt_limited() throws RecognitionException {
        Update_stmt_limitedContext r5 = new Update_stmt_limitedContext(this._ctx, getState());
        enterRule(r5, 62, 31);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(857);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 149) goto L10;
        setState(856);     // Catch: Throwable -> L6 RecognitionException -> L8
        with_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
    L10:
        setState(859);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(141);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(870);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r10 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 115, this._ctx);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r10 == 1) goto L23;
        if (r10 != 2) goto L14;
        setState(862);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(110);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(863);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(27);     // Catch: Throwable -> L6 RecognitionException -> L8
    L24:
        setState(872);     // Catch: Throwable -> L6 RecognitionException -> L8
        qualified_table_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(873);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(131);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(876);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r11 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 116, this._ctx);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r11 == 1) goto L29;
        if (r11 != 2) goto L30;
        setState(875);     // Catch: Throwable -> L6 RecognitionException -> L8
        column_name_list();     // Catch: Throwable -> L6 RecognitionException -> L8
    L30:
        setState(878);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(6);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(879);     // Catch: Throwable -> L6 RecognitionException -> L8
        expr(0);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(890);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r12 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
    L31:
        if (r12 != 5) goto L39;
        setState(880);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(5);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(883);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r13 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 117, this._ctx);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r13 == 1) goto L37;
        if (r13 != 2) goto L38;
        setState(882);     // Catch: Throwable -> L6 RecognitionException -> L8
        column_name_list();     // Catch: Throwable -> L6 RecognitionException -> L8
    L38:
        setState(885);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(6);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(886);     // Catch: Throwable -> L6 RecognitionException -> L8
        expr(0);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(892);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        r12 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L31
    L37:
        setState(881);     // Catch: Throwable -> L6 RecognitionException -> L8
        column_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L38
    L39:
        setState(895);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 148) goto L42;
        setState(893);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(148);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(894);     // Catch: Throwable -> L6 RecognitionException -> L8
        expr(0);     // Catch: Throwable -> L6 RecognitionException -> L8
    L42:
        setState(LynxErrorCode.LYNX_ERROR_CODE_MODULE_FUNC_NOT_EXIST);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r14 = this._input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r14 == 100) goto L45;
        if (r14 == 111) goto L45;
    L49:
        exitRule();
        return r5;
    L45:
        setState(898);     // Catch: Throwable -> L6 RecognitionException -> L8
        this._errHandler.sync(this);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this._input.LA(1) != 111) goto L48;
        setState(897);     // Catch: Throwable -> L6 RecognitionException -> L8
        order_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
    L48:
        setState(LynxErrorCode.LYNX_ERROR_CODE_MODULE_NOT_EXIST);     // Catch: Throwable -> L6 RecognitionException -> L8
        limit_clause();     // Catch: Throwable -> L6 RecognitionException -> L8
    L29:
        setState(874);     // Catch: Throwable -> L6 RecognitionException -> L8
        column_name();     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L30
    L14:
        if (r10 != 3) goto L16;
        setState(864);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(110);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(865);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(124);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L24
    L16:
        if (r10 == 4) goto L20;
        if (r10 != 5) goto L24;
        setState(868);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(110);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(869);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(83);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L24
    L20:
        setState(866);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(110);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(867);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(74);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L24
    L23:
        setState(860);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(110);     // Catch: Throwable -> L6 RecognitionException -> L8
        setState(861);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(127);     // Catch: Throwable -> L6 RecognitionException -> L8
    L6:
        th = move-exception;
        exitRule();
        throw th;
    L8:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L6
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L6
        this._errHandler.recover(this, e);     // Catch: Throwable -> L6
        goto L49
    }

    public final Upsert_clauseContext upsert_clause() throws RecognitionException {
        Upsert_clauseContext r5 = new Upsert_clauseContext(this._ctx, getState());
        enterRule(r5, 44, 22);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(645);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(109);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(646);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(50);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(661);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (this._input.LA(1) != 3) goto L15;
        setState(647);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(3);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(648);     // Catch: Throwable -> L8 RecognitionException -> L10
        indexed_column();     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(653);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r10 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
    L6:
        if (r10 != 5) goto L12;
        setState(649);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(5);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(650);     // Catch: Throwable -> L8 RecognitionException -> L10
        indexed_column();     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(655);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        r10 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L6
    L12:
        setState(656);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(4);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(659);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (this._input.LA(1) != 148) goto L15;
        setState(657);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(148);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(658);     // Catch: Throwable -> L8 RecognitionException -> L10
        expr(0);     // Catch: Throwable -> L8 RecognitionException -> L10
    L15:
        setState(689);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r11 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r11 != 152) goto L18;
        setState(663);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(152);     // Catch: Throwable -> L8 RecognitionException -> L10
    L40:
        exitRule();
        return r5;
    L18:
        if (r11 != 153) goto L38;
        setState(664);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(153);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(665);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(131);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(668);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r12 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 79, this._ctx);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r12 == 1) goto L24;
        if (r12 != 2) goto L25;
        setState(667);     // Catch: Throwable -> L8 RecognitionException -> L10
        column_name_list();     // Catch: Throwable -> L8 RecognitionException -> L10
    L25:
        setState(670);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(6);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(671);     // Catch: Throwable -> L8 RecognitionException -> L10
        expr(0);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(682);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r13 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
    L26:
        if (r13 != 5) goto L34;
        setState(672);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(5);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(675);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        int r14 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 80, this._ctx);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r14 == 1) goto L32;
        if (r14 != 2) goto L33;
        setState(674);     // Catch: Throwable -> L8 RecognitionException -> L10
        column_name_list();     // Catch: Throwable -> L8 RecognitionException -> L10
    L33:
        setState(677);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(6);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(678);     // Catch: Throwable -> L8 RecognitionException -> L10
        expr(0);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(684);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        r13 = this._input.LA(1);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L26
    L32:
        setState(673);     // Catch: Throwable -> L8 RecognitionException -> L10
        column_name();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L33
    L34:
        setState(687);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (this._input.LA(1) != 148) goto L40;
        setState(685);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(148);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(686);     // Catch: Throwable -> L8 RecognitionException -> L10
        expr(0);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L40
    L24:
        setState(666);     // Catch: Throwable -> L8 RecognitionException -> L10
        column_name();     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L25
    L38:
        throw new NoViableAltException(this);     // Catch: Throwable -> L8 RecognitionException -> L10
    L10:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L8
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L8
        this._errHandler.recover(this, e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final Vacuum_stmtContext vacuum_stmt() throws RecognitionException {
        Vacuum_stmtContext r5 = new Vacuum_stmtContext(this._ctx, getState());
        enterRule(r5, 64, 32);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(LynxErrorCode.LYNX_ERROR_CODE_MODULE_FUNC_WRONG_ARG_TYPE);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(143);     // Catch: Throwable -> L8 RecognitionException -> L10
        setState(LynxErrorCode.LYNX_ERROR_CODE_MODULE_BUSINESS_ERROR);     // Catch: Throwable -> L8 RecognitionException -> L10
        this._errHandler.sync(this);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 122, this._ctx) != 1) goto L7;
        setState(LynxErrorCode.LYNX_ERROR_CODE_MODULE_FUNC_CALL_EXCEPTION);     // Catch: Throwable -> L8 RecognitionException -> L10
        schema_name();     // Catch: Throwable -> L8 RecognitionException -> L10
    L7:
        exitRule();
        return r5;
    L10:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L8
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L8
        this._errHandler.recover(this, e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        exitRule();
        throw th;
    }

    public final View_nameContext view_name() throws RecognitionException {
        View_nameContext r5 = new View_nameContext(this._ctx, getState());
        enterRule(r5, 156, 78);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L5 RecognitionException -> L7
        setState(1525);     // Catch: Throwable -> L5 RecognitionException -> L7
        any_name();     // Catch: Throwable -> L5 RecognitionException -> L7
    L4:
        exitRule();
        return r5;
    L5:
        th = move-exception;
        exitRule();
        throw th;
    L7:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L5
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L5
        this._errHandler.recover(this, e);     // Catch: Throwable -> L5
        goto L4
    }

    public final With_clauseContext with_clause() throws RecognitionException {
        With_clauseContext r5 = new With_clauseContext(this._ctx, getState());
        enterRule(r5, 86, 43);
        enterOuterAlt(r5, 1);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1243);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(149);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1245);     // Catch: Throwable -> L12 RecognitionException -> L14
        this._errHandler.sync(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 175, this._ctx) != 1) goto L7;
        setState(1244);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(118);     // Catch: Throwable -> L12 RecognitionException -> L14
    L7:
        setState(1247);     // Catch: Throwable -> L12 RecognitionException -> L14
        common_table_expression();     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1252);     // Catch: Throwable -> L12 RecognitionException -> L14
        this._errHandler.sync(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r10 = this._input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
    L9:
        if (r10 != 5) goto L16;
        setState(1248);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(5);     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1249);     // Catch: Throwable -> L12 RecognitionException -> L14
        common_table_expression();     // Catch: Throwable -> L12 RecognitionException -> L14
        setState(1254);     // Catch: Throwable -> L12 RecognitionException -> L14
        this._errHandler.sync(this);     // Catch: Throwable -> L12 RecognitionException -> L14
        r10 = this._input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
    L16:
        exitRule();
        return r5;
    L12:
        th = move-exception;
        exitRule();
        throw th;
    L14:
        e = move-exception;
        r5.exception = e;     // Catch: Throwable -> L12
        this._errHandler.reportError(this, e);     // Catch: Throwable -> L12
        this._errHandler.recover(this, e);     // Catch: Throwable -> L12
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private ExprContext expr(int r25) throws RecognitionException {
        ParserRuleContext r5 = this._ctx;
        int r10 = getState();
        ExprContext r11 = new ExprContext(this._ctx, r10);
        enterRecursionRule(r11, 74, 37, r25);
        ?? r12 = 1;
        enterOuterAlt(r11, 1);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(1047);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        int r13 = 3;
        int r14 = 0;
        switch(((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 143, this._ctx)) {
            case 1: goto L56;
            case 2: goto L55;
            case 3: goto L46;
            case 4: goto L45;
            case 5: goto L32;
            case 6: goto L31;
            case 7: goto L30;
            case 8: goto L22;
            case 9: goto L11;
            case 10: goto L6;
            default: goto L57;
        };     // Catch: Throwable -> L7 RecognitionException -> L9
    L6:
        setState(1046);     // Catch: Throwable -> L7 RecognitionException -> L9
        raise_function();     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L57
    L11:
        setState(1027);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(44);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(1029);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 140, this._ctx) != 1) goto L15;
        setState(1028);     // Catch: Throwable -> L7 RecognitionException -> L9
        expr(0);     // Catch: Throwable -> L7 RecognitionException -> L9
    L15:
        setState(1036);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._input.LA(1);     // Catch: Throwable -> L7 RecognitionException -> L9
    L16:
        setState(1031);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(147);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(1032);     // Catch: Throwable -> L7 RecognitionException -> L9
        expr(0);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(1033);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(135);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(1034);     // Catch: Throwable -> L7 RecognitionException -> L9
        expr(0);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(1038);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        if (this._input.LA(1) == 147) goto L16;
        setState(1042);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        if (this._input.LA(1) != 67) goto L21;
        setState(1040);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(67);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(1041);     // Catch: Throwable -> L7 RecognitionException -> L9
        expr(0);     // Catch: Throwable -> L7 RecognitionException -> L9
    L21:
        setState(1044);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(68);     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L57
    L22:
        setState(PointerIconCompat.TYPE_GRABBING);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        int r15 = this._input.LA(1);     // Catch: Throwable -> L7 RecognitionException -> L9
        if (r15 == 72) goto L25;
        if (r15 == 104) goto L25;
    L29:
        setState(1023);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(3);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(1024);     // Catch: Throwable -> L7 RecognitionException -> L9
        select_stmt();     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(InputDeviceCompat.SOURCE_GAMEPAD);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(4);     // Catch: Throwable -> L7 RecognitionException -> L9
    L25:
        setState(PointerIconCompat.TYPE_ZOOM_IN);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        if (this._input.LA(1) != 104) goto L28;
        setState(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(104);     // Catch: Throwable -> L7 RecognitionException -> L9
    L28:
        setState(PointerIconCompat.TYPE_GRAB);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(72);     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L29
    L30:
        setState(PointerIconCompat.TYPE_ALIAS);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(45);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(PointerIconCompat.TYPE_COPY);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(3);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(PointerIconCompat.TYPE_NO_DROP);     // Catch: Throwable -> L7 RecognitionException -> L9
        expr(0);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(PointerIconCompat.TYPE_ALL_SCROLL);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(35);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW);     // Catch: Throwable -> L7 RecognitionException -> L9
        type_name();     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(4);     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L57
    L31:
        setState(PointerIconCompat.TYPE_CELL);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(3);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(PointerIconCompat.TYPE_CROSSHAIR);     // Catch: Throwable -> L7 RecognitionException -> L9
        comma_separated_expr();     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(PointerIconCompat.TYPE_TEXT);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(4);     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L57
    L32:
        setState(995);     // Catch: Throwable -> L7 RecognitionException -> L9
        function_name();     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(996);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(3);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(PointerIconCompat.TYPE_HAND);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        int r16 = this._input.LA(1);     // Catch: Throwable -> L7 RecognitionException -> L9
        if (r16 == 3) goto L39;
        switch(r16) {
            case 7: goto L38;
            case 8: goto L39;
            case 9: goto L39;
            case 10: goto L39;
            default: goto L35;
        };     // Catch: Throwable -> L7 RecognitionException -> L9
    L35:
        switch(r16) {
            case 25: goto L39;
            case 26: goto L39;
            case 27: goto L39;
            case 28: goto L39;
            case 29: goto L39;
            case 30: goto L39;
            case 31: goto L39;
            case 32: goto L39;
            case 33: goto L39;
            case 34: goto L39;
            case 35: goto L39;
            case 36: goto L39;
            case 37: goto L39;
            case 38: goto L39;
            case 39: goto L39;
            case 40: goto L39;
            case 41: goto L39;
            case 42: goto L39;
            case 43: goto L39;
            case 44: goto L39;
            case 45: goto L39;
            case 46: goto L39;
            case 47: goto L39;
            case 48: goto L39;
            case 49: goto L39;
            case 50: goto L39;
            case 51: goto L39;
            case 52: goto L39;
            case 53: goto L39;
            case 54: goto L39;
            case 55: goto L39;
            case 56: goto L39;
            case 57: goto L39;
            case 58: goto L39;
            case 59: goto L39;
            case 60: goto L39;
            case 61: goto L39;
            case 62: goto L39;
            case 63: goto L39;
            case 64: goto L39;
            case 65: goto L39;
            case 66: goto L39;
            case 67: goto L39;
            case 68: goto L39;
            case 69: goto L39;
            case 70: goto L39;
            case 71: goto L39;
            case 72: goto L39;
            case 73: goto L39;
            case 74: goto L39;
            case 75: goto L39;
            case 76: goto L39;
            case 77: goto L39;
            case 78: goto L39;
            case 79: goto L39;
            case 80: goto L39;
            case 81: goto L39;
            case 82: goto L39;
            case 83: goto L39;
            case 84: goto L39;
            case 85: goto L39;
            case 86: goto L39;
            case 87: goto L39;
            case 88: goto L39;
            case 89: goto L39;
            case 90: goto L39;
            case 91: goto L39;
            case 92: goto L39;
            case 93: goto L39;
            case 94: goto L39;
            case 95: goto L39;
            case 96: goto L39;
            case 97: goto L39;
            case 98: goto L39;
            case 99: goto L39;
            case 100: goto L39;
            case 101: goto L39;
            case 102: goto L39;
            case 103: goto L39;
            case 104: goto L39;
            case 105: goto L39;
            case 106: goto L39;
            case 107: goto L39;
            case 108: goto L39;
            case 109: goto L39;
            case 110: goto L39;
            case 111: goto L39;
            case 112: goto L39;
            case 113: goto L39;
            case 114: goto L39;
            case 115: goto L39;
            case 116: goto L39;
            case 117: goto L39;
            case 118: goto L39;
            case 119: goto L39;
            case 120: goto L39;
            case 121: goto L39;
            case 122: goto L39;
            case 123: goto L39;
            case 124: goto L39;
            case 125: goto L39;
            case 126: goto L39;
            case 127: goto L39;
            case 128: goto L39;
            case 129: goto L39;
            case 130: goto L39;
            case 131: goto L39;
            case 132: goto L39;
            case 133: goto L39;
            case 134: goto L39;
            case 135: goto L39;
            case 136: goto L39;
            case 137: goto L39;
            case 138: goto L39;
            case 139: goto L39;
            case 140: goto L39;
            case 141: goto L39;
            case 142: goto L39;
            case 143: goto L39;
            case 144: goto L39;
            case 145: goto L39;
            case 146: goto L39;
            case 147: goto L39;
            case 148: goto L39;
            case 149: goto L39;
            case 150: goto L39;
            default: goto L36;
        };     // Catch: Throwable -> L7 RecognitionException -> L9
    L36:
        switch(r16) {
            case 154: goto L39;
            case 155: goto L39;
            case 156: goto L39;
            case 157: goto L39;
            case 158: goto L39;
            default: goto L44;
        };     // Catch: Throwable -> L7 RecognitionException -> L9
    L44:
        setState(PointerIconCompat.TYPE_WAIT);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(4);     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L57
    L38:
        setState(1001);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(7);     // Catch: Throwable -> L7 RecognitionException -> L9
    L39:
        setState(998);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 136, this._ctx) != 1) goto L43;
        setState(997);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(64);     // Catch: Throwable -> L7 RecognitionException -> L9
    L43:
        setState(1000);     // Catch: Throwable -> L7 RecognitionException -> L9
        comma_separated_expr();     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L44
    L45:
        setState(992);     // Catch: Throwable -> L7 RecognitionException -> L9
        unary_operator();     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(993);     // Catch: Throwable -> L7 RecognitionException -> L9
        expr(14);     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L57
    L46:
        setState(989);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 135, this._ctx) != 1) goto L54;
        setState(984);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 134, this._ctx) == 1) goto L52;
        int r17 = 2;
    L53:
        setState(986);     // Catch: Throwable -> L7 RecognitionException -> L9
        table_name();     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(987);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(r17);     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L54
    L52:
        setState(981);     // Catch: Throwable -> L7 RecognitionException -> L9
        schema_name();     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(982);     // Catch: Throwable -> L7 RecognitionException -> L9
        r17 = 2;
        match(2);     // Catch: Throwable -> L7 RecognitionException -> L9
    L54:
        setState(991);     // Catch: Throwable -> L7 RecognitionException -> L9
        column_name();     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L57
    L55:
        setState(980);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(156);     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L57
    L56:
        setState(979);     // Catch: Throwable -> L7 RecognitionException -> L9
        literal_value();     // Catch: Throwable -> L7 RecognitionException -> L9
    L57:
        this._ctx.stop = this._input.LT(-1);     // Catch: Throwable -> L7 RecognitionException -> L9
        setState(1121);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        int r18 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 156, this._ctx);     // Catch: Throwable -> L7 RecognitionException -> L9
        int r19 = 2;
    L58:
        if (r18 == r19) goto L200;
        if (r18 == 0) goto L200;
        if (r18 != r12) goto L66;
        if (this._parseListeners == null) goto L64;
        triggerExitRuleEvent();     // Catch: Throwable -> L7 RecognitionException -> L9
    L64:
        setState(1119);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        switch(((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 155, this._ctx)) {
            case 1: goto L189;
            case 2: goto L177;
            case 3: goto L166;
            case 4: goto L158;
            case 5: goto L134;
            case 6: goto L117;
            case 7: goto L67;
            default: goto L66;
        };     // Catch: Throwable -> L7 RecognitionException -> L9
    L67:
        ExprContext r20 = new ExprContext(r5, r10);     // Catch: Throwable -> L7 RecognitionException -> L9
        pushNewRecursionContext(r20, 74, 37);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1088);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (precpred(this._ctx, 4) == false) goto L116;
        setState(1090);     // Catch: Throwable -> L7 RecognitionException -> L74
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (this._input.LA(r12) != 104) goto L76;
        setState(1089);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(104);     // Catch: Throwable -> L7 RecognitionException -> L74
    L76:
        setState(1092);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(85);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1117);     // Catch: Throwable -> L7 RecognitionException -> L74
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L74
        int r21 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 154, this._ctx);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (r21 != r12) goto L79;
        setState(1093);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(r13);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1096);     // Catch: Throwable -> L7 RecognitionException -> L74
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L74
        int r22 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 150, this._ctx);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (r22 == r12) goto L111;
        r19 = 2;
        if (r22 != 2) goto L112;
        setState(1095);     // Catch: Throwable -> L7 RecognitionException -> L74
        comma_separated_expr();     // Catch: Throwable -> L7 RecognitionException -> L74
    L112:
        setState(1098);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(4);     // Catch: Throwable -> L7 RecognitionException -> L74
    L113:
        r11 = r20;
    L198:
        setState(1123);     // Catch: Throwable -> L7 RecognitionException -> L9
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L9
        r18 = ((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 156, this._ctx);     // Catch: Throwable -> L7 RecognitionException -> L9
        r13 = 3;
        r14 = 0;
        r12 = 1;
        goto L58
    L111:
        r19 = 2;
        setState(1094);     // Catch: Throwable -> L7 RecognitionException -> L74
        select_stmt();     // Catch: Throwable -> L7 RecognitionException -> L74
        goto L112
    L79:
        if (r21 == 2) goto L100;
        if (r21 == r13) goto L82;
    L81:
        r19 = 2;
        goto L113
    L82:
        setState(1108);     // Catch: Throwable -> L7 RecognitionException -> L74
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 152, this._ctx) != r12) goto L86;
        setState(1105);     // Catch: Throwable -> L7 RecognitionException -> L74
        schema_name();     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1106);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(2);     // Catch: Throwable -> L7 RecognitionException -> L74
    L86:
        setState(1110);     // Catch: Throwable -> L7 RecognitionException -> L74
        table_function();     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1111);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(r13);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1113);     // Catch: Throwable -> L7 RecognitionException -> L74
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L74
        int r23 = this._input.LA(r12);     // Catch: Throwable -> L7 RecognitionException -> L74
        if ((r23 & (-64)) == 0) goto L89;
    L90:
        int r24 = r23 - 64;     // Catch: Throwable -> L7 RecognitionException -> L74
        if ((r24 & (-64)) == 0) goto L93;
    L94:
        int r26 = r23 - 128;     // Catch: Throwable -> L7 RecognitionException -> L74
        if ((r26 & (-64)) == 0) goto L97;
    L99:
        setState(1115);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(4);     // Catch: Throwable -> L7 RecognitionException -> L74
        goto L81
    L97:
        if (((1 << r26) & 2088763391) == 0) goto L99;
    L98:
        setState(1112);     // Catch: Throwable -> L7 RecognitionException -> L74
        comma_separated_expr();     // Catch: Throwable -> L7 RecognitionException -> L74
        goto L99
    L93:
        if ((1 << r24) != 0) goto L98;
    L89:
        if (((1 << r23) & (-33552632)) != 0) goto L98;
    L100:
        setState(1102);     // Catch: Throwable -> L7 RecognitionException -> L74
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 151, this._ctx) != r12) goto L104;
        setState(1099);     // Catch: Throwable -> L7 RecognitionException -> L74
        schema_name();     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1100);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(2);     // Catch: Throwable -> L7 RecognitionException -> L74
    L104:
        setState(1104);     // Catch: Throwable -> L7 RecognitionException -> L74
        table_name();     // Catch: Throwable -> L7 RecognitionException -> L74
        goto L81
    L116:
        throw new FailedPredicateException(this, "precpred(_ctx, 4)");     // Catch: Throwable -> L7 RecognitionException -> L74
    L74:
        e = move-exception;
        RecognitionException r27 = e;
        r11 = r20;
    L201:
        r11.exception = r27;     // Catch: Throwable -> L7
        this._errHandler.reportError(this, r27);     // Catch: Throwable -> L7
        this._errHandler.recover(this, r27);     // Catch: Throwable -> L7
        goto L200
    L117:
        r19 = 2;
        r20 = new ExprContext(r5, r10);     // Catch: Throwable -> L7 RecognitionException -> L9
        pushNewRecursionContext(r20, 74, 37);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1081);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (precpred(this._ctx, 7) == false) goto L133;
        setState(1086);     // Catch: Throwable -> L7 RecognitionException -> L74
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L74
        int r28 = this._input.LA(r12);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (r28 == 95) goto L131;
        if (r28 != 104) goto L126;
        setState(1084);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(104);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1085);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(106);     // Catch: Throwable -> L7 RecognitionException -> L74
        goto L113
    L126:
        if (r28 != 105) goto L129;
        setState(1083);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(105);     // Catch: Throwable -> L7 RecognitionException -> L74
        goto L113
    L129:
        throw new NoViableAltException(this);     // Catch: Throwable -> L7 RecognitionException -> L74
    L131:
        setState(1082);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(95);     // Catch: Throwable -> L7 RecognitionException -> L74
        goto L113
    L133:
        throw new FailedPredicateException(this, "precpred(_ctx, 7)");     // Catch: Throwable -> L7 RecognitionException -> L74
    L134:
        r19 = 2;
        r20 = new ExprContext(r5, r10);     // Catch: Throwable -> L7 RecognitionException -> L9
        pushNewRecursionContext(r20, 74, 37);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1071);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (precpred(this._ctx, 8) == false) goto L157;
        setState(1073);     // Catch: Throwable -> L7 RecognitionException -> L74
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (this._input.LA(r12) != 104) goto L142;
        setState(1072);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(104);     // Catch: Throwable -> L7 RecognitionException -> L74
    L142:
        setState(1075);     // Catch: Throwable -> L7 RecognitionException -> L74
        int r29 = this._input.LA(r12) - 79;     // Catch: Throwable -> L7 RecognitionException -> L74
        if ((r29 & (-64)) == 0) goto L145;
    L151:
        this._errHandler.recoverInline(this);     // Catch: Throwable -> L7 RecognitionException -> L74
    L152:
        setState(1076);     // Catch: Throwable -> L7 RecognitionException -> L74
        expr(r14);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1079);     // Catch: Throwable -> L7 RecognitionException -> L74
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 147, this._ctx) != r12) goto L113;
        setState(1077);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(69);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1078);     // Catch: Throwable -> L7 RecognitionException -> L74
        expr(r14);     // Catch: Throwable -> L7 RecognitionException -> L74
        goto L113
    L145:
        if (((1 << r29) & 2199028498433L) == 0) goto L151;
        if (this._input.LA(r12) != (-1)) goto L150;
        this.matchedEOF = r12;     // Catch: Throwable -> L7 RecognitionException -> L74
    L150:
        this._errHandler.reportMatch(this);     // Catch: Throwable -> L7 RecognitionException -> L74
        consume();     // Catch: Throwable -> L7 RecognitionException -> L74
        goto L152
    L157:
        throw new FailedPredicateException(this, "precpred(_ctx, 8)");     // Catch: Throwable -> L7 RecognitionException -> L74
    L158:
        r19 = 2;
        r20 = new ExprContext(r5, r10);     // Catch: Throwable -> L7 RecognitionException -> L9
        pushNewRecursionContext(r20, 74, 37);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1068);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (precpred(this._ctx, 9) == false) goto L165;
        setState(1069);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(47);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1070);     // Catch: Throwable -> L7 RecognitionException -> L74
        collation_name();     // Catch: Throwable -> L7 RecognitionException -> L74
        goto L113
    L165:
        throw new FailedPredicateException(this, "precpred(_ctx, 9)");     // Catch: Throwable -> L7 RecognitionException -> L74
    L166:
        r19 = 2;
        r20 = new ExprContext(r5, r10);     // Catch: Throwable -> L7 RecognitionException -> L9
        pushNewRecursionContext(r20, 74, 37);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1059);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (precpred(this._ctx, 5) == false) goto L176;
        setState(1061);     // Catch: Throwable -> L7 RecognitionException -> L74
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (this._input.LA(r12) != 104) goto L174;
        setState(1060);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(104);     // Catch: Throwable -> L7 RecognitionException -> L74
    L174:
        setState(1063);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(41);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1064);     // Catch: Throwable -> L7 RecognitionException -> L74
        expr(r14);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1065);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(34);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1066);     // Catch: Throwable -> L7 RecognitionException -> L74
        expr(6);     // Catch: Throwable -> L7 RecognitionException -> L74
        goto L113
    L176:
        throw new FailedPredicateException(this, "precpred(_ctx, 5)");     // Catch: Throwable -> L7 RecognitionException -> L74
    L177:
        r19 = 2;
        r20 = new ExprContext(r5, r10);     // Catch: Throwable -> L7 RecognitionException -> L9
        pushNewRecursionContext(r20, 74, 37);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1053);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (precpred(this._ctx, 6) == false) goto L188;
        setState(1054);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(94);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1056);     // Catch: Throwable -> L7 RecognitionException -> L74
        this._errHandler.sync(this);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (((ParserATNSimulator) getInterpreter()).adaptivePredict(this._input, 144, this._ctx) != r12) goto L186;
        setState(1055);     // Catch: Throwable -> L7 RecognitionException -> L74
        match(104);     // Catch: Throwable -> L7 RecognitionException -> L74
    L186:
        setState(1058);     // Catch: Throwable -> L7 RecognitionException -> L74
        expr(7);     // Catch: Throwable -> L7 RecognitionException -> L74
        goto L113
    L188:
        throw new FailedPredicateException(this, "precpred(_ctx, 6)");     // Catch: Throwable -> L7 RecognitionException -> L74
    L189:
        r19 = 2;
        ExprContext r30 = new ExprContext(r5, r10);     // Catch: Throwable -> L7 RecognitionException -> L9
        pushNewRecursionContext(r30, 74, 37);     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1049);     // Catch: Throwable -> L7 RecognitionException -> L74
        if (precpred(this._ctx, 13) == false) goto L196;
        setState(1050);     // Catch: Throwable -> L7 RecognitionException -> L74
        binary_operator();     // Catch: Throwable -> L7 RecognitionException -> L74
        setState(1051);     // Catch: Throwable -> L7 RecognitionException -> L74
        expr(14);     // Catch: Throwable -> L7 RecognitionException -> L74
        r11 = r30;
        goto L198
    L196:
        throw new FailedPredicateException(this, "precpred(_ctx, 13)");     // Catch: Throwable -> L7 RecognitionException -> L74
    L66:
        r19 = 2;
    L200:
        unrollRecursionContexts(r5);
        return r11;
    L9:
        e = move-exception;
        r27 = e;
    L7:
        th = move-exception;
        unrollRecursionContexts(r5);
        throw th;
    }
}
