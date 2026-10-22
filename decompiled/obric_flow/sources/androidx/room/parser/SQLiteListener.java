package androidx.room.parser;

import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeListener;

/* JADX INFO: loaded from: classes.dex */
public interface SQLiteListener extends ParseTreeListener {
    void enterAlter_table_stmt(SQLiteParser.Alter_table_stmtContext r5);

    void enterAnalyze_stmt(SQLiteParser.Analyze_stmtContext r5);

    void enterAny_name(SQLiteParser.Any_nameContext r5);

    void enterAttach_stmt(SQLiteParser.Attach_stmtContext r5);

    void enterBegin_stmt(SQLiteParser.Begin_stmtContext r5);

    void enterBinary_operator(SQLiteParser.Binary_operatorContext r5);

    void enterBoolean_literal(SQLiteParser.Boolean_literalContext r5);

    void enterCollation_name(SQLiteParser.Collation_nameContext r5);

    void enterColumn_alias(SQLiteParser.Column_aliasContext r5);

    void enterColumn_constraint(SQLiteParser.Column_constraintContext r5);

    void enterColumn_def(SQLiteParser.Column_defContext r5);

    void enterColumn_name(SQLiteParser.Column_nameContext r5);

    void enterColumn_name_list(SQLiteParser.Column_name_listContext r5);

    void enterComma_separated_expr(SQLiteParser.Comma_separated_exprContext r5);

    void enterCommit_stmt(SQLiteParser.Commit_stmtContext r5);

    void enterCommon_table_expression(SQLiteParser.Common_table_expressionContext r5);

    void enterCompound_operator(SQLiteParser.Compound_operatorContext r5);

    void enterConflict_clause(SQLiteParser.Conflict_clauseContext r5);

    void enterCreate_index_stmt(SQLiteParser.Create_index_stmtContext r5);

    void enterCreate_table_stmt(SQLiteParser.Create_table_stmtContext r5);

    void enterCreate_trigger_stmt(SQLiteParser.Create_trigger_stmtContext r5);

    void enterCreate_view_stmt(SQLiteParser.Create_view_stmtContext r5);

    void enterCreate_virtual_table_stmt(SQLiteParser.Create_virtual_table_stmtContext r5);

    void enterDelete_stmt(SQLiteParser.Delete_stmtContext r5);

    void enterDelete_stmt_limited(SQLiteParser.Delete_stmt_limitedContext r5);

    void enterDetach_stmt(SQLiteParser.Detach_stmtContext r5);

    void enterDrop_index_stmt(SQLiteParser.Drop_index_stmtContext r5);

    void enterDrop_table_stmt(SQLiteParser.Drop_table_stmtContext r5);

    void enterDrop_trigger_stmt(SQLiteParser.Drop_trigger_stmtContext r5);

    void enterDrop_view_stmt(SQLiteParser.Drop_view_stmtContext r5);

    void enterError(SQLiteParser.ErrorContext r5);

    void enterError_message(SQLiteParser.Error_messageContext r5);

    void enterExpr(SQLiteParser.ExprContext r5);

    void enterForeign_key_clause(SQLiteParser.Foreign_key_clauseContext r5);

    void enterForeign_table(SQLiteParser.Foreign_tableContext r5);

    void enterFunction_name(SQLiteParser.Function_nameContext r5);

    void enterIndex_name(SQLiteParser.Index_nameContext r5);

    void enterIndexed_column(SQLiteParser.Indexed_columnContext r5);

    void enterInsert_stmt(SQLiteParser.Insert_stmtContext r5);

    void enterJoin_clause(SQLiteParser.Join_clauseContext r5);

    void enterJoin_constraint(SQLiteParser.Join_constraintContext r5);

    void enterJoin_operator(SQLiteParser.Join_operatorContext r5);

    void enterKeyword(SQLiteParser.KeywordContext r5);

    void enterLimit_clause(SQLiteParser.Limit_clauseContext r5);

    void enterLiteral_value(SQLiteParser.Literal_valueContext r5);

    void enterModule_argument(SQLiteParser.Module_argumentContext r5);

    void enterModule_name(SQLiteParser.Module_nameContext r5);

    void enterName(SQLiteParser.NameContext r5);

    void enterNew_table_name(SQLiteParser.New_table_nameContext r5);

    void enterOrder_clause(SQLiteParser.Order_clauseContext r5);

    void enterOrdering_term(SQLiteParser.Ordering_termContext r5);

    void enterParse(SQLiteParser.ParseContext r5);

    void enterPragma_name(SQLiteParser.Pragma_nameContext r5);

    void enterPragma_stmt(SQLiteParser.Pragma_stmtContext r5);

    void enterPragma_value(SQLiteParser.Pragma_valueContext r5);

    void enterQualified_table_name(SQLiteParser.Qualified_table_nameContext r5);

    void enterRaise_function(SQLiteParser.Raise_functionContext r5);

    void enterReindex_stmt(SQLiteParser.Reindex_stmtContext r5);

    void enterRelease_stmt(SQLiteParser.Release_stmtContext r5);

    void enterResult_column(SQLiteParser.Result_columnContext r5);

    void enterRollback_stmt(SQLiteParser.Rollback_stmtContext r5);

    void enterSavepoint_name(SQLiteParser.Savepoint_nameContext r5);

    void enterSavepoint_stmt(SQLiteParser.Savepoint_stmtContext r5);

    void enterSchema_name(SQLiteParser.Schema_nameContext r5);

    void enterSelect_or_values(SQLiteParser.Select_or_valuesContext r5);

    void enterSelect_stmt(SQLiteParser.Select_stmtContext r5);

    void enterSigned_number(SQLiteParser.Signed_numberContext r5);

    void enterSql_stmt(SQLiteParser.Sql_stmtContext r5);

    void enterSql_stmt_list(SQLiteParser.Sql_stmt_listContext r5);

    void enterTable_alias(SQLiteParser.Table_aliasContext r5);

    void enterTable_constraint(SQLiteParser.Table_constraintContext r5);

    void enterTable_function(SQLiteParser.Table_functionContext r5);

    void enterTable_name(SQLiteParser.Table_nameContext r5);

    void enterTable_or_index_name(SQLiteParser.Table_or_index_nameContext r5);

    void enterTable_or_subquery(SQLiteParser.Table_or_subqueryContext r5);

    void enterTransaction_name(SQLiteParser.Transaction_nameContext r5);

    void enterTrigger_name(SQLiteParser.Trigger_nameContext r5);

    void enterType_name(SQLiteParser.Type_nameContext r5);

    void enterUnary_operator(SQLiteParser.Unary_operatorContext r5);

    void enterUpdate_stmt(SQLiteParser.Update_stmtContext r5);

    void enterUpdate_stmt_limited(SQLiteParser.Update_stmt_limitedContext r5);

    void enterUpsert_clause(SQLiteParser.Upsert_clauseContext r5);

    void enterVacuum_stmt(SQLiteParser.Vacuum_stmtContext r5);

    void enterView_name(SQLiteParser.View_nameContext r5);

    void enterWith_clause(SQLiteParser.With_clauseContext r5);

    void exitAlter_table_stmt(SQLiteParser.Alter_table_stmtContext r5);

    void exitAnalyze_stmt(SQLiteParser.Analyze_stmtContext r5);

    void exitAny_name(SQLiteParser.Any_nameContext r5);

    void exitAttach_stmt(SQLiteParser.Attach_stmtContext r5);

    void exitBegin_stmt(SQLiteParser.Begin_stmtContext r5);

    void exitBinary_operator(SQLiteParser.Binary_operatorContext r5);

    void exitBoolean_literal(SQLiteParser.Boolean_literalContext r5);

    void exitCollation_name(SQLiteParser.Collation_nameContext r5);

    void exitColumn_alias(SQLiteParser.Column_aliasContext r5);

    void exitColumn_constraint(SQLiteParser.Column_constraintContext r5);

    void exitColumn_def(SQLiteParser.Column_defContext r5);

    void exitColumn_name(SQLiteParser.Column_nameContext r5);

    void exitColumn_name_list(SQLiteParser.Column_name_listContext r5);

    void exitComma_separated_expr(SQLiteParser.Comma_separated_exprContext r5);

    void exitCommit_stmt(SQLiteParser.Commit_stmtContext r5);

    void exitCommon_table_expression(SQLiteParser.Common_table_expressionContext r5);

    void exitCompound_operator(SQLiteParser.Compound_operatorContext r5);

    void exitConflict_clause(SQLiteParser.Conflict_clauseContext r5);

    void exitCreate_index_stmt(SQLiteParser.Create_index_stmtContext r5);

    void exitCreate_table_stmt(SQLiteParser.Create_table_stmtContext r5);

    void exitCreate_trigger_stmt(SQLiteParser.Create_trigger_stmtContext r5);

    void exitCreate_view_stmt(SQLiteParser.Create_view_stmtContext r5);

    void exitCreate_virtual_table_stmt(SQLiteParser.Create_virtual_table_stmtContext r5);

    void exitDelete_stmt(SQLiteParser.Delete_stmtContext r5);

    void exitDelete_stmt_limited(SQLiteParser.Delete_stmt_limitedContext r5);

    void exitDetach_stmt(SQLiteParser.Detach_stmtContext r5);

    void exitDrop_index_stmt(SQLiteParser.Drop_index_stmtContext r5);

    void exitDrop_table_stmt(SQLiteParser.Drop_table_stmtContext r5);

    void exitDrop_trigger_stmt(SQLiteParser.Drop_trigger_stmtContext r5);

    void exitDrop_view_stmt(SQLiteParser.Drop_view_stmtContext r5);

    void exitError(SQLiteParser.ErrorContext r5);

    void exitError_message(SQLiteParser.Error_messageContext r5);

    void exitExpr(SQLiteParser.ExprContext r5);

    void exitForeign_key_clause(SQLiteParser.Foreign_key_clauseContext r5);

    void exitForeign_table(SQLiteParser.Foreign_tableContext r5);

    void exitFunction_name(SQLiteParser.Function_nameContext r5);

    void exitIndex_name(SQLiteParser.Index_nameContext r5);

    void exitIndexed_column(SQLiteParser.Indexed_columnContext r5);

    void exitInsert_stmt(SQLiteParser.Insert_stmtContext r5);

    void exitJoin_clause(SQLiteParser.Join_clauseContext r5);

    void exitJoin_constraint(SQLiteParser.Join_constraintContext r5);

    void exitJoin_operator(SQLiteParser.Join_operatorContext r5);

    void exitKeyword(SQLiteParser.KeywordContext r5);

    void exitLimit_clause(SQLiteParser.Limit_clauseContext r5);

    void exitLiteral_value(SQLiteParser.Literal_valueContext r5);

    void exitModule_argument(SQLiteParser.Module_argumentContext r5);

    void exitModule_name(SQLiteParser.Module_nameContext r5);

    void exitName(SQLiteParser.NameContext r5);

    void exitNew_table_name(SQLiteParser.New_table_nameContext r5);

    void exitOrder_clause(SQLiteParser.Order_clauseContext r5);

    void exitOrdering_term(SQLiteParser.Ordering_termContext r5);

    void exitParse(SQLiteParser.ParseContext r5);

    void exitPragma_name(SQLiteParser.Pragma_nameContext r5);

    void exitPragma_stmt(SQLiteParser.Pragma_stmtContext r5);

    void exitPragma_value(SQLiteParser.Pragma_valueContext r5);

    void exitQualified_table_name(SQLiteParser.Qualified_table_nameContext r5);

    void exitRaise_function(SQLiteParser.Raise_functionContext r5);

    void exitReindex_stmt(SQLiteParser.Reindex_stmtContext r5);

    void exitRelease_stmt(SQLiteParser.Release_stmtContext r5);

    void exitResult_column(SQLiteParser.Result_columnContext r5);

    void exitRollback_stmt(SQLiteParser.Rollback_stmtContext r5);

    void exitSavepoint_name(SQLiteParser.Savepoint_nameContext r5);

    void exitSavepoint_stmt(SQLiteParser.Savepoint_stmtContext r5);

    void exitSchema_name(SQLiteParser.Schema_nameContext r5);

    void exitSelect_or_values(SQLiteParser.Select_or_valuesContext r5);

    void exitSelect_stmt(SQLiteParser.Select_stmtContext r5);

    void exitSigned_number(SQLiteParser.Signed_numberContext r5);

    void exitSql_stmt(SQLiteParser.Sql_stmtContext r5);

    void exitSql_stmt_list(SQLiteParser.Sql_stmt_listContext r5);

    void exitTable_alias(SQLiteParser.Table_aliasContext r5);

    void exitTable_constraint(SQLiteParser.Table_constraintContext r5);

    void exitTable_function(SQLiteParser.Table_functionContext r5);

    void exitTable_name(SQLiteParser.Table_nameContext r5);

    void exitTable_or_index_name(SQLiteParser.Table_or_index_nameContext r5);

    void exitTable_or_subquery(SQLiteParser.Table_or_subqueryContext r5);

    void exitTransaction_name(SQLiteParser.Transaction_nameContext r5);

    void exitTrigger_name(SQLiteParser.Trigger_nameContext r5);

    void exitType_name(SQLiteParser.Type_nameContext r5);

    void exitUnary_operator(SQLiteParser.Unary_operatorContext r5);

    void exitUpdate_stmt(SQLiteParser.Update_stmtContext r5);

    void exitUpdate_stmt_limited(SQLiteParser.Update_stmt_limitedContext r5);

    void exitUpsert_clause(SQLiteParser.Upsert_clauseContext r5);

    void exitVacuum_stmt(SQLiteParser.Vacuum_stmtContext r5);

    void exitView_name(SQLiteParser.View_nameContext r5);

    void exitWith_clause(SQLiteParser.With_clauseContext r5);
}
