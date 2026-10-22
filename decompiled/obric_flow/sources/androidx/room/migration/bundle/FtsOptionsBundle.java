package androidx.room.migration.bundle;

import androidx.annotation.RestrictTo;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0013¢\u0006\u0002\u0010\u0002BW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0000H\u0016R\u0016\u0010\u0007\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\r\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u001b"}, d2 = {"Landroidx/room/migration/bundle/FtsOptionsBundle;", "Landroidx/room/migration/bundle/SchemaEquality;", "()V", "tokenizer", "", "tokenizerArgs", "", "contentTable", "languageIdColumnName", "matchInfo", "notIndexedColumns", "prefixSizes", "", "preferredOrder", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getContentTable", "()Ljava/lang/String;", "getLanguageIdColumnName", "getMatchInfo", "getNotIndexedColumns", "()Ljava/util/List;", "getPreferredOrder", "getPrefixSizes", "getTokenizerArgs", "isSchemaEqual", "", "other", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FtsOptionsBundle implements SchemaEquality<FtsOptionsBundle> {

    @SerializedName("contentTable")
    private final String contentTable;

    @SerializedName("languageIdColumnName")
    private final String languageIdColumnName;

    @SerializedName("matchInfo")
    private final String matchInfo;

    @SerializedName("notIndexedColumns")
    private final List<String> notIndexedColumns;

    @SerializedName("preferredOrder")
    private final String preferredOrder;

    @SerializedName("prefixSizes")
    private final List<Integer> prefixSizes;

    @SerializedName("tokenizer")
    private final String tokenizer;

    @SerializedName("tokenizerArgs")
    private final List<String> tokenizerArgs;

    public FtsOptionsBundle(String r5, List<String> r10, String r11, String r12, String r13, List<String> r14, List<Integer> r15, String r16) {
        Intrinsics.checkNotNullParameter(r5, "tokenizer");
        Intrinsics.checkNotNullParameter(r10, "tokenizerArgs");
        Intrinsics.checkNotNullParameter(r11, "contentTable");
        Intrinsics.checkNotNullParameter(r12, "languageIdColumnName");
        Intrinsics.checkNotNullParameter(r13, "matchInfo");
        Intrinsics.checkNotNullParameter(r14, "notIndexedColumns");
        Intrinsics.checkNotNullParameter(r15, "prefixSizes");
        Intrinsics.checkNotNullParameter(r16, "preferredOrder");
        this.tokenizer = r5;
        this.tokenizerArgs = r10;
        this.contentTable = r11;
        this.languageIdColumnName = r12;
        this.matchInfo = r13;
        this.notIndexedColumns = r14;
        this.prefixSizes = r15;
        this.preferredOrder = r16;
    }

    public String getContentTable() {
        return this.contentTable;
    }

    public String getLanguageIdColumnName() {
        return this.languageIdColumnName;
    }

    public String getMatchInfo() {
        return this.matchInfo;
    }

    public List<String> getNotIndexedColumns() {
        return this.notIndexedColumns;
    }

    public String getPreferredOrder() {
        return this.preferredOrder;
    }

    public List<Integer> getPrefixSizes() {
        return this.prefixSizes;
    }

    public List<String> getTokenizerArgs() {
        return this.tokenizerArgs;
    }

    @Override // androidx.room.migration.bundle.SchemaEquality
    public /* bridge */ /* synthetic */ boolean isSchemaEqual(FtsOptionsBundle r5) {
        return isSchemaEqual2(r5);
    }

    /* JADX INFO: renamed from: isSchemaEqual, reason: avoid collision after fix types in other method */
    public boolean isSchemaEqual2(FtsOptionsBundle r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if (Intrinsics.areEqual(this.tokenizer, r5.tokenizer) == true) goto L5;
    L19:
        return false;
    L5:
        if (Intrinsics.areEqual(getTokenizerArgs(), r5.getTokenizerArgs()) == false) goto L19;
        if (Intrinsics.areEqual(getContentTable(), r5.getContentTable()) == false) goto L19;
        if (Intrinsics.areEqual(getLanguageIdColumnName(), r5.getLanguageIdColumnName()) == false) goto L19;
        if (Intrinsics.areEqual(getMatchInfo(), r5.getMatchInfo()) == false) goto L19;
        if (Intrinsics.areEqual(getNotIndexedColumns(), r5.getNotIndexedColumns()) == false) goto L19;
        if (Intrinsics.areEqual(getPrefixSizes(), r5.getPrefixSizes()) == false) goto L19;
        if (Intrinsics.areEqual(getPreferredOrder(), r5.getPreferredOrder()) == false) goto L19;
        return true;
    }

    @Deprecated(message = "Marked deprecated to avoid usage in the codebase")
    private FtsOptionsBundle() {
        this("", CollectionsKt.emptyList(), "", "", "", CollectionsKt.emptyList(), CollectionsKt.emptyList(), "");
    }
}
