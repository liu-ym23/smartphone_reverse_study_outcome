package androidx.room.vo;

import androidx.room.migration.bundle.FtsOptionsBundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 22\u00020\u0001:\u00012BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u000fHÆ\u0003Jm\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010(\u001a\u00020)J\u0013\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\b\u0010-\u001a\u00020\u0003H\u0016J\t\u0010.\u001a\u00020\rHÖ\u0001J\u0006\u0010/\u001a\u000200J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018¨\u00063"}, d2 = {"Landroidx/room/vo/FtsOptions;", "Landroidx/room/vo/HasSchemaIdentity;", "tokenizer", "", "tokenizerArgs", "", "contentEntity", "Landroidx/room/vo/Entity;", "languageIdColumnName", "matchInfo", "Landroidx/room/FtsOptions$MatchInfo;", "notIndexedColumns", "prefixSizes", "", "preferredOrder", "Landroidx/room/FtsOptions$Order;", "(Ljava/lang/String;Ljava/util/List;Landroidx/room/vo/Entity;Ljava/lang/String;Landroidx/room/FtsOptions$MatchInfo;Ljava/util/List;Ljava/util/List;Landroidx/room/FtsOptions$Order;)V", "getContentEntity", "()Landroidx/room/vo/Entity;", "getLanguageIdColumnName", "()Ljava/lang/String;", "getMatchInfo", "()Landroidx/room/FtsOptions$MatchInfo;", "getNotIndexedColumns", "()Ljava/util/List;", "getPreferredOrder", "()Landroidx/room/FtsOptions$Order;", "getPrefixSizes", "getTokenizer", "getTokenizerArgs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "databaseDefinition", "includeTokenizer", "", "equals", "other", "", "getIdKey", "hashCode", "toBundle", "Landroidx/room/migration/bundle/FtsOptionsBundle;", "toString", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FtsOptions implements HasSchemaIdentity {
    public static final Companion Companion = null;
    private static final List<String> defaultTokenizers = null;
    private final Entity contentEntity;
    private final String languageIdColumnName;
    private final androidx.room.FtsOptions.MatchInfo matchInfo;
    private final List<String> notIndexedColumns;
    private final androidx.room.FtsOptions.Order preferredOrder;
    private final List<Integer> prefixSizes;
    private final String tokenizer;
    private final List<String> tokenizerArgs;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/room/vo/FtsOptions$Companion;", "", "()V", "defaultTokenizers", "", "", "getDefaultTokenizers", "()Ljava/util/List;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final List<String> getDefaultTokenizers() {
            return FtsOptions.access$getDefaultTokenizers$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        defaultTokenizers = CollectionsKt.listOf(new String[]{androidx.room.FtsOptions.TOKENIZER_SIMPLE, androidx.room.FtsOptions.TOKENIZER_PORTER, androidx.room.FtsOptions.TOKENIZER_UNICODE61});
    }

    public FtsOptions(String r5, List<String> r10, Entity r11, String r12, androidx.room.FtsOptions.MatchInfo r13, List<String> r14, List<Integer> r15, androidx.room.FtsOptions.Order r16) {
        Intrinsics.checkNotNullParameter(r5, "tokenizer");
        Intrinsics.checkNotNullParameter(r10, "tokenizerArgs");
        Intrinsics.checkNotNullParameter(r12, "languageIdColumnName");
        Intrinsics.checkNotNullParameter(r13, "matchInfo");
        Intrinsics.checkNotNullParameter(r14, "notIndexedColumns");
        Intrinsics.checkNotNullParameter(r15, "prefixSizes");
        Intrinsics.checkNotNullParameter(r16, "preferredOrder");
        this.tokenizer = r5;
        this.tokenizerArgs = r10;
        this.contentEntity = r11;
        this.languageIdColumnName = r12;
        this.matchInfo = r13;
        this.notIndexedColumns = r14;
        this.prefixSizes = r15;
        this.preferredOrder = r16;
    }

    public static final /* synthetic */ List access$getDefaultTokenizers$cp() {
        return defaultTokenizers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FtsOptions copy$default(FtsOptions r10, String r11, List r12, Entity r13, String r14, androidx.room.FtsOptions.MatchInfo r15, List r16, List r17, androidx.room.FtsOptions.Order r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        String r5 = r10.tokenizer;
    L7:
        if ((r19 & 2) == 0) goto L9;
        List r20 = r10.tokenizerArgs;
    L11:
        if ((r19 & 4) == 0) goto L13;
        Entity r21 = r10.contentEntity;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r22 = r10.languageIdColumnName;
    L19:
        if ((r19 & 16) == 0) goto L21;
        androidx.room.FtsOptions.MatchInfo r23 = r10.matchInfo;
    L23:
        if ((r19 & 32) == 0) goto L25;
        List r24 = r10.notIndexedColumns;
    L27:
        if ((r19 & 64) == 0) goto L29;
        List r25 = r10.prefixSizes;
    L31:
        if ((r19 & 128) == 0) goto L33;
        androidx.room.FtsOptions.Order r26 = r10.preferredOrder;
    L35:
        return r10.copy(r5, r20, r21, r22, r23, r24, r25, r26);
    L33:
        r26 = r18;
        goto L35
    L29:
        r25 = r17;
        goto L31
    L25:
        r24 = r16;
        goto L27
    L21:
        r23 = r15;
        goto L23
    L17:
        r22 = r14;
        goto L19
    L13:
        r21 = r13;
        goto L15
    L9:
        r20 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    public static /* synthetic */ List databaseDefinition$default(FtsOptions r5, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = true;
    L6:
        return r5.databaseDefinition(r10);
    }

    public final String component1() {
        return this.tokenizer;
    }

    public final List<String> component2() {
        return this.tokenizerArgs;
    }

    public final Entity component3() {
        return this.contentEntity;
    }

    public final String component4() {
        return this.languageIdColumnName;
    }

    public final androidx.room.FtsOptions.MatchInfo component5() {
        return this.matchInfo;
    }

    public final List<String> component6() {
        return this.notIndexedColumns;
    }

    public final List<Integer> component7() {
        return this.prefixSizes;
    }

    public final androidx.room.FtsOptions.Order component8() {
        return this.preferredOrder;
    }

    public final FtsOptions copy(String r11, List<String> r12, Entity r13, String r14, androidx.room.FtsOptions.MatchInfo r15, List<String> r16, List<Integer> r17, androidx.room.FtsOptions.Order r18) {
        Intrinsics.checkNotNullParameter(r11, "tokenizer");
        Intrinsics.checkNotNullParameter(r12, "tokenizerArgs");
        Intrinsics.checkNotNullParameter(r14, "languageIdColumnName");
        Intrinsics.checkNotNullParameter(r15, "matchInfo");
        Intrinsics.checkNotNullParameter(r16, "notIndexedColumns");
        Intrinsics.checkNotNullParameter(r17, "prefixSizes");
        Intrinsics.checkNotNullParameter(r18, "preferredOrder");
        return new FtsOptions(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public final List<String> databaseDefinition(boolean r14) {
        ArrayList r5 = new ArrayList();
        if (r14 == true) goto L5;
    L13:
        Entity r15 = this.contentEntity;
        if (r15 == null) goto L17;
        r5.add("content=`" + r15.getTableName() + "`");
    L17:
        if (this.languageIdColumnName.length() <= 0) goto L19;
        r5.add("languageid=`" + this.languageIdColumnName + "`");
    L19:
        androidx.room.FtsOptions.MatchInfo r16 = this.matchInfo;
        if (r16 == androidx.room.FtsOptions.MatchInfo.FTS4) goto L22;
        r5.add("matchinfo=" + r16.name().toLowerCase(Locale.US));
    L22:
        Iterator<T> r17 = this.notIndexedColumns.iterator();
    L24:
        if (r17.hasNext() == false) goto L27;
        r5.add("notindexed=`" + ((String) r17.next()) + "`");
        goto L24
    L27:
        if (this.prefixSizes.isEmpty() == true) goto L29;
        r5.add("prefix=`" + CollectionsKt.q(this.prefixSizes, ",", null, null, 0, null, FtsOptions$databaseDefinition$1$2.INSTANCE, 30) + "`");
    L29:
        androidx.room.FtsOptions.Order r13 = this.preferredOrder;
        if (r13 == androidx.room.FtsOptions.Order.ASC) goto L32;
        r5.add("order=" + r13);
    L32:
        return r5;
    L5:
        if (Intrinsics.areEqual(this.tokenizer, androidx.room.FtsOptions.TOKENIZER_SIMPLE) == true) goto L7;
    L8:
        List r18 = CollectionsKt.listOf("tokenize=" + this.tokenizer);
        List<String> r10 = this.tokenizerArgs;
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r12 = r10.iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        r11.add("`" + ((String) r12.next()) + "`");
        goto L10
    L12:
        r5.add(CollectionsKt.q(CollectionsKt.plus(r18, r11), " ", null, null, 0, null, null, 62));
        goto L13
    L7:
        if (this.tokenizerArgs.isEmpty() == true) goto L13;
        goto L8
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FtsOptions) == true) goto L8;
        return false;
    L8:
        FtsOptions r10 = (FtsOptions) r5;
        if (Intrinsics.areEqual(this.tokenizer, r10.tokenizer) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tokenizerArgs, r10.tokenizerArgs) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.contentEntity, r10.contentEntity) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.languageIdColumnName, r10.languageIdColumnName) == true) goto L21;
        return false;
    L21:
        if (this.matchInfo == r10.matchInfo) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.notIndexedColumns, r10.notIndexedColumns) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.prefixSizes, r10.prefixSizes) == true) goto L30;
        return false;
    L30:
        if (this.preferredOrder == r10.preferredOrder) goto L32;
        return false;
    L32:
        return true;
    }

    public final Entity getContentEntity() {
        return this.contentEntity;
    }

    @Override // androidx.room.vo.HasSchemaIdentity
    public String getIdKey() {
        SchemaIdentityKey r5 = new SchemaIdentityKey();
        r5.append(this.tokenizer);
        r5.append(CollectionsKt.q(this.tokenizerArgs, null, null, null, 0, null, null, 63));
        Entity r10 = this.contentEntity;
        if (r10 == null) goto L6;
        String r11 = r10.getTableName();
        if (r11 == null) goto L6;
    L7:
        r5.append(r11);
        r5.append(this.languageIdColumnName);
        r5.append(this.matchInfo.name());
        r5.append(CollectionsKt.q(this.notIndexedColumns, null, null, null, 0, null, null, 63));
        r5.append(CollectionsKt.q(this.prefixSizes, null, null, null, 0, null, AnonymousClass1.INSTANCE, 31));
        r5.append(this.preferredOrder.name());
        return r5.hash();
    L6:
        r11 = "";
        goto L7
    }

    public final String getLanguageIdColumnName() {
        return this.languageIdColumnName;
    }

    public final androidx.room.FtsOptions.MatchInfo getMatchInfo() {
        return this.matchInfo;
    }

    public final List<String> getNotIndexedColumns() {
        return this.notIndexedColumns;
    }

    public final androidx.room.FtsOptions.Order getPreferredOrder() {
        return this.preferredOrder;
    }

    public final List<Integer> getPrefixSizes() {
        return this.prefixSizes;
    }

    public final String getTokenizer() {
        return this.tokenizer;
    }

    public final List<String> getTokenizerArgs() {
        return this.tokenizerArgs;
    }

    public int hashCode() {
        int r5 = this.tokenizer.hashCode() * 31;
        int r10 = androidx.constraintlayout.motion.widget.a.f(this.tokenizerArgs, r5, 31);
        Entity r11 = this.contentEntity;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = androidx.constraintlayout.motion.widget.a.c((r10 + r12) * 31, 31, this.languageIdColumnName);
        int r14 = (this.matchInfo.hashCode() + r13) * 31;
        int r15 = androidx.constraintlayout.motion.widget.a.f(this.notIndexedColumns, r14, 31);
        int r16 = androidx.constraintlayout.motion.widget.a.f(this.prefixSizes, r15, 31);
        return this.preferredOrder.hashCode() + r16;
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final FtsOptionsBundle toBundle() {
        String r5 = this.tokenizer;
        List<String> r10 = this.tokenizerArgs;
        Entity r11 = this.contentEntity;
        if (r11 == null) goto L8;
        String r12 = r11.getTableName();
        if (r12 == null) goto L8;
    L7:
        String r13 = r12;
        return new FtsOptionsBundle(r5, r10, r13, this.languageIdColumnName, this.matchInfo.name(), this.notIndexedColumns, this.prefixSizes, this.preferredOrder.name());
    L8:
        r12 = "";
        goto L7
    }

    public String toString() {
        return "FtsOptions(tokenizer=" + this.tokenizer + ", tokenizerArgs=" + this.tokenizerArgs + ", contentEntity=" + this.contentEntity + ", languageIdColumnName=" + this.languageIdColumnName + ", matchInfo=" + this.matchInfo + ", notIndexedColumns=" + this.notIndexedColumns + ", prefixSizes=" + this.prefixSizes + ", preferredOrder=" + this.preferredOrder + ")";
    }
}
