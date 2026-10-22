package androidx.room.parser;

import androidx.room.jarjarred.org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/* JADX INFO: loaded from: classes.dex */
public class SQLiteBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements SQLiteVisitor<T> {
    public SQLiteBaseVisitor() {
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitAlter_table_stmt(SQLiteParser.Alter_table_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitAnalyze_stmt(SQLiteParser.Analyze_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitAny_name(SQLiteParser.Any_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitAttach_stmt(SQLiteParser.Attach_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitBegin_stmt(SQLiteParser.Begin_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitBinary_operator(SQLiteParser.Binary_operatorContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitBoolean_literal(SQLiteParser.Boolean_literalContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitCollation_name(SQLiteParser.Collation_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitColumn_alias(SQLiteParser.Column_aliasContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitColumn_constraint(SQLiteParser.Column_constraintContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitColumn_def(SQLiteParser.Column_defContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitColumn_name(SQLiteParser.Column_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitColumn_name_list(SQLiteParser.Column_name_listContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitComma_separated_expr(SQLiteParser.Comma_separated_exprContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitCommit_stmt(SQLiteParser.Commit_stmtContext r5) {
        return visitChildren(r5);
    }

    public T visitCommon_table_expression(SQLiteParser.Common_table_expressionContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitCompound_operator(SQLiteParser.Compound_operatorContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitConflict_clause(SQLiteParser.Conflict_clauseContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitCreate_index_stmt(SQLiteParser.Create_index_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitCreate_table_stmt(SQLiteParser.Create_table_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitCreate_trigger_stmt(SQLiteParser.Create_trigger_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitCreate_view_stmt(SQLiteParser.Create_view_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitCreate_virtual_table_stmt(SQLiteParser.Create_virtual_table_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitDelete_stmt(SQLiteParser.Delete_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitDelete_stmt_limited(SQLiteParser.Delete_stmt_limitedContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitDetach_stmt(SQLiteParser.Detach_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitDrop_index_stmt(SQLiteParser.Drop_index_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitDrop_table_stmt(SQLiteParser.Drop_table_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitDrop_trigger_stmt(SQLiteParser.Drop_trigger_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitDrop_view_stmt(SQLiteParser.Drop_view_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitError(SQLiteParser.ErrorContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitError_message(SQLiteParser.Error_messageContext r5) {
        return visitChildren(r5);
    }

    public T visitExpr(SQLiteParser.ExprContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitForeign_key_clause(SQLiteParser.Foreign_key_clauseContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitForeign_table(SQLiteParser.Foreign_tableContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitFunction_name(SQLiteParser.Function_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitIndex_name(SQLiteParser.Index_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitIndexed_column(SQLiteParser.Indexed_columnContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitInsert_stmt(SQLiteParser.Insert_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitJoin_clause(SQLiteParser.Join_clauseContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitJoin_constraint(SQLiteParser.Join_constraintContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitJoin_operator(SQLiteParser.Join_operatorContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitKeyword(SQLiteParser.KeywordContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitLimit_clause(SQLiteParser.Limit_clauseContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitLiteral_value(SQLiteParser.Literal_valueContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitModule_argument(SQLiteParser.Module_argumentContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitModule_name(SQLiteParser.Module_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitName(SQLiteParser.NameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitNew_table_name(SQLiteParser.New_table_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitOrder_clause(SQLiteParser.Order_clauseContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitOrdering_term(SQLiteParser.Ordering_termContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitParse(SQLiteParser.ParseContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitPragma_name(SQLiteParser.Pragma_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitPragma_stmt(SQLiteParser.Pragma_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitPragma_value(SQLiteParser.Pragma_valueContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitQualified_table_name(SQLiteParser.Qualified_table_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitRaise_function(SQLiteParser.Raise_functionContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitReindex_stmt(SQLiteParser.Reindex_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitRelease_stmt(SQLiteParser.Release_stmtContext r5) {
        return visitChildren(r5);
    }

    public T visitResult_column(SQLiteParser.Result_columnContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitRollback_stmt(SQLiteParser.Rollback_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitSavepoint_name(SQLiteParser.Savepoint_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitSavepoint_stmt(SQLiteParser.Savepoint_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitSchema_name(SQLiteParser.Schema_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitSelect_or_values(SQLiteParser.Select_or_valuesContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitSelect_stmt(SQLiteParser.Select_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitSigned_number(SQLiteParser.Signed_numberContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitSql_stmt(SQLiteParser.Sql_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitSql_stmt_list(SQLiteParser.Sql_stmt_listContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitTable_alias(SQLiteParser.Table_aliasContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitTable_constraint(SQLiteParser.Table_constraintContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitTable_function(SQLiteParser.Table_functionContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitTable_name(SQLiteParser.Table_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitTable_or_index_name(SQLiteParser.Table_or_index_nameContext r5) {
        return visitChildren(r5);
    }

    public T visitTable_or_subquery(SQLiteParser.Table_or_subqueryContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitTransaction_name(SQLiteParser.Transaction_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitTrigger_name(SQLiteParser.Trigger_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitType_name(SQLiteParser.Type_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitUnary_operator(SQLiteParser.Unary_operatorContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitUpdate_stmt(SQLiteParser.Update_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitUpdate_stmt_limited(SQLiteParser.Update_stmt_limitedContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitUpsert_clause(SQLiteParser.Upsert_clauseContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitVacuum_stmt(SQLiteParser.Vacuum_stmtContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitView_name(SQLiteParser.View_nameContext r5) {
        return visitChildren(r5);
    }

    @Override // androidx.room.parser.SQLiteVisitor
    public T visitWith_clause(SQLiteParser.With_clauseContext r5) {
        return visitChildren(r5);
    }
}
