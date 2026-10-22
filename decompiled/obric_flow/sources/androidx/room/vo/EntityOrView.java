package androidx.room.vo;

import androidx.room.compiler.codegen.XTypeName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/room/vo/EntityOrView;", "Landroidx/room/vo/HasFields;", "tableName", "", "getTableName", "()Ljava/lang/String;", "typeName", "Landroidx/room/compiler/codegen/XTypeName;", "getTypeName", "()Landroidx/room/compiler/codegen/XTypeName;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface EntityOrView extends HasFields {
    String getTableName();

    XTypeName getTypeName();
}
