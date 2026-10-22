package androidx.room.jarjarred.kotlinx.metadata;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmDeclarationContainer;", "", "functions", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunction;", "getFunctions", "()Ljava/util/List;", "properties", "Landroidx/room/jarjarred/kotlinx/metadata/KmProperty;", "getProperties", "typeAliases", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAlias;", "getTypeAliases", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface KmDeclarationContainer {
    List<KmFunction> getFunctions();

    List<KmProperty> getProperties();

    List<KmTypeAlias> getTypeAliases();
}
