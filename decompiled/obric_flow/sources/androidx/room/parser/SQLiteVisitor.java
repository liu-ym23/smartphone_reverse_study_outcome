package androidx.room.parser;

import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeVisitor;

/* JADX INFO: loaded from: classes.dex */
public interface SQLiteVisitor<T> extends ParseTreeVisitor<T> {
    T visitAlter_table_stmt(SQLiteParser.Alter_table_stmtContext r5);

    T visitAnalyze_stmt(SQLiteParser.Analyze_stmtContext r5);

    T visitAny_name(SQLiteParser.Any_nameContext r5);

    T visitAttach_stmt(SQLiteParser.Attach_stmtContext r5);

    T visitBegin_stmt(SQLiteParser.Begin_stmtContext r5);

    T visitBinary_operator(SQLiteParser.Binary_operatorContext r5);

    T visitBoolean_literal(SQLiteParser.Boolean_literalContext r5);

    T visitCollation_name(SQLiteParser.Collation_nameContext r5);

    T visitColumn_alias(SQLiteParser.Column_aliasContext r5);

    T visitColumn_constraint(SQLiteParser.Column_constraintContext r5);

    T visitColumn_def(SQLiteParser.Column_defContext r5);

    T visitColumn_name(SQLiteParser.Column_nameContext r5);

    T visitColumn_name_list(SQLiteParser.Column_name_listContext r5);

    T visitComma_separated_expr(SQLiteParser.Comma_separated_exprContext r5);

    T visitCommit_stmt(SQLiteParser.Commit_stmtContext r5);

    T visitCommon_table_expression(SQLiteParser.Common_table_expressionContext r5);

    T visitCompound_operator(SQLiteParser.Compound_operatorContext r5);

    T visitConflict_clause(SQLiteParser.Conflict_clauseContext r5);

    T visitCreate_index_stmt(SQLiteParser.Create_index_stmtContext r5);

    T visitCreate_table_stmt(SQLiteParser.Create_table_stmtContext r5);

    T visitCreate_trigger_stmt(SQLiteParser.Create_trigger_stmtContext r5);

    T visitCreate_view_stmt(SQLiteParser.Create_view_stmtContext r5);

    T visitCreate_virtual_table_stmt(SQLiteParser.Create_virtual_table_stmtContext r5);

    T visitDelete_stmt(SQLiteParser.Delete_stmtContext r5);

    T visitDelete_stmt_limited(SQLiteParser.Delete_stmt_limitedContext r5);

    T visitDetach_stmt(SQLiteParser.Detach_stmtContext r5);

    T visitDrop_index_stmt(SQLiteParser.Drop_index_stmtContext r5);

    T visitDrop_table_stmt(SQLiteParser.Drop_table_stmtContext r5);

    T visitDrop_trigger_stmt(SQLiteParser.Drop_trigger_stmtContext r5);

    T visitDrop_view_stmt(SQLiteParser.Drop_view_stmtContext r5);

    T visitError(SQLiteParser.ErrorContext r5);

    T visitError_message(SQLiteParser.Error_messageContext r5);

    T visitExpr(SQLiteParser.ExprContext r5);

    T visitForeign_key_clause(SQLiteParser.Foreign_key_clauseContext r5);

    T visitForeign_table(SQLiteParser.Foreign_tableContext r5);

    T visitFunction_name(SQLiteParser.Function_nameContext r5);

    T visitIndex_name(SQLiteParser.Index_nameContext r5);

    T visitIndexed_column(SQLiteParser.Indexed_columnContext r5);

    T visitInsert_stmt(SQLiteParser.Insert_stmtContext r5);

    T visitJoin_clause(SQLiteParser.Join_clauseContext r5);

    T visitJoin_constraint(SQLiteParser.Join_constraintContext r5);

    T visitJoin_operator(SQLiteParser.Join_operatorContext r5);

    T visitKeyword(SQLiteParser.KeywordContext r5);

    T visitLimit_clause(SQLiteParser.Limit_clauseContext r5);

    T visitLiteral_value(SQLiteParser.Literal_valueContext r5);

    T visitModule_argument(SQLiteParser.Module_argumentContext r5);

    T visitModule_name(SQLiteParser.Module_nameContext r5);

    T visitName(SQLiteParser.NameContext r5);

    T visitNew_table_name(SQLiteParser.New_table_nameContext r5);

    T visitOrder_clause(SQLiteParser.Order_clauseContext r5);

    T visitOrdering_term(SQLiteParser.Ordering_termContext r5);

    T visitParse(SQLiteParser.ParseContext r5);

    T visitPragma_name(SQLiteParser.Pragma_nameContext r5);

    T visitPragma_stmt(SQLiteParser.Pragma_stmtContext r5);

    T visitPragma_value(SQLiteParser.Pragma_valueContext r5);

    T visitQualified_table_name(SQLiteParser.Qualified_table_nameContext r5);

    T visitRaise_function(SQLiteParser.Raise_functionContext r5);

    T visitReindex_stmt(SQLiteParser.Reindex_stmtContext r5);

    T visitRelease_stmt(SQLiteParser.Release_stmtContext r5);

    T visitResult_column(SQLiteParser.Result_columnContext r5);

    T visitRollback_stmt(SQLiteParser.Rollback_stmtContext r5);

    T visitSavepoint_name(SQLiteParser.Savepoint_nameContext r5);

    T visitSavepoint_stmt(SQLiteParser.Savepoint_stmtContext r5);

    T visitSchema_name(SQLiteParser.Schema_nameContext r5);

    T visitSelect_or_values(SQLiteParser.Select_or_valuesContext r5);

    T visitSelect_stmt(SQLiteParser.Select_stmtContext r5);

    T visitSigned_number(SQLiteParser.Signed_numberContext r5);

    T visitSql_stmt(SQLiteParser.Sql_stmtContext r5);

    T visitSql_stmt_list(SQLiteParser.Sql_stmt_listContext r5);

    T visitTable_alias(SQLiteParser.Table_aliasContext r5);

    T visitTable_constraint(SQLiteParser.Table_constraintContext r5);

    T visitTable_function(SQLiteParser.Table_functionContext r5);

    T visitTable_name(SQLiteParser.Table_nameContext r5);

    T visitTable_or_index_name(SQLiteParser.Table_or_index_nameContext r5);

    T visitTable_or_subquery(SQLiteParser.Table_or_subqueryContext r5);

    T visitTransaction_name(SQLiteParser.Transaction_nameContext r5);

    T visitTrigger_name(SQLiteParser.Trigger_nameContext r5);

    T visitType_name(SQLiteParser.Type_nameContext r5);

    T visitUnary_operator(SQLiteParser.Unary_operatorContext r5);

    T visitUpdate_stmt(SQLiteParser.Update_stmtContext r5);

    T visitUpdate_stmt_limited(SQLiteParser.Update_stmt_limitedContext r5);

    T visitUpsert_clause(SQLiteParser.Upsert_clauseContext r5);

    T visitVacuum_stmt(SQLiteParser.Vacuum_stmtContext r5);

    T visitView_name(SQLiteParser.View_nameContext r5);

    T visitWith_clause(SQLiteParser.With_clauseContext r5);
}
