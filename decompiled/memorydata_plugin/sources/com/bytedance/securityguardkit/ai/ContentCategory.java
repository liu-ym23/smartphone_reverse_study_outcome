package com.bytedance.securityguardkit.ai;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/securityguardkit/ai/ContentCategory;", "", EventBody.KEY_VALUE, "", "categoryName", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCategoryName", "()Ljava/lang/String;", "getValue", "()I", "SECURITY", "ABUSE", "DISCRIMINATE", "PORNOGRAPHY", "DRUGS", "CRIMINAL", "REACTIONARY", "LEADER", "LEADER_POSITIVE", "REACTIONARY_POSITIVE", "Companion", "SecurityGuardKit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum ContentCategory extends Enum<ContentCategory> {
    private static final /* synthetic */ ContentCategory[] $VALUES = null;
    public static final ContentCategory ABUSE = null;
    public static final ContentCategory CRIMINAL = null;
    public static final a Companion = null;
    public static final ContentCategory DISCRIMINATE = null;
    public static final ContentCategory DRUGS = null;
    public static final ContentCategory LEADER = null;
    public static final ContentCategory LEADER_POSITIVE = null;
    public static final ContentCategory PORNOGRAPHY = null;
    public static final ContentCategory REACTIONARY = null;
    public static final ContentCategory REACTIONARY_POSITIVE = null;
    public static final ContentCategory SECURITY = null;
    private static final Map<Integer, ContentCategory> valueToCategory = null;
    private final String categoryName;
    private final int value;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/securityguardkit/ai/ContentCategory$Companion;", "", "()V", "valueToCategory", "", "", "Lcom/bytedance/securityguardkit/ai/ContentCategory;", "fromValue", EventBody.KEY_VALUE, "SecurityGuardKit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final ContentCategory a(int r2) {
            return (ContentCategory) ZeusTransformUtils.preCheckCast(ContentCategory.access$getValueToCategory$cp().get(Integer.valueOf(r2)), ContentCategory.class, "com.obric.memorydata.plugin");
        }
    }

    private static final /* synthetic */ ContentCategory[] $values() {
        return new ContentCategory[]{SECURITY, ABUSE, DISCRIMINATE, PORNOGRAPHY, DRUGS, CRIMINAL, REACTIONARY, LEADER, LEADER_POSITIVE, REACTIONARY_POSITIVE};
    }

    static {
        int r2 = 0;
        SECURITY = new ContentCategory("SECURITY", 0, 0, "security");
        ABUSE = new ContentCategory("ABUSE", 1, 1, "abuse");
        DISCRIMINATE = new ContentCategory("DISCRIMINATE", 2, 2, "discriminate");
        PORNOGRAPHY = new ContentCategory("PORNOGRAPHY", 3, 3, "pornography");
        DRUGS = new ContentCategory("DRUGS", 4, 4, "drugs");
        CRIMINAL = new ContentCategory("CRIMINAL", 5, 5, "criminal");
        REACTIONARY = new ContentCategory("REACTIONARY", 6, 6, "reactionary");
        LEADER = new ContentCategory("LEADER", 7, 7, "leader");
        LEADER_POSITIVE = new ContentCategory("LEADER_POSITIVE", 8, 8, "leader_positive");
        REACTIONARY_POSITIVE = new ContentCategory("REACTIONARY_POSITIVE", 9, 9, "reactionary_positive");
        $VALUES = $values();
        Companion = new a(null);
        ContentCategory[] r0 = values();
        Map<Integer, ContentCategory> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r0.length), 16)), Map.class, "com.obric.memorydata.plugin");
        int r3 = r0.length;
    L3:
        if (r2 >= r3) goto L5;
        ContentCategory r4 = r0[r2];
        r1.put(Integer.valueOf(r4.value), r4);
        r2 = r2 + 1;
        goto L3
    L5:
        valueToCategory = r1;
    }

    private ContentCategory(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.value = r3;
        this.categoryName = r4;
    }

    public static final /* synthetic */ Map access$getValueToCategory$cp() {
        return valueToCategory;
    }

    @JvmStatic
    public static final ContentCategory fromValue(int r1) {
        return Companion.a(r1);
    }

    public static ContentCategory valueOf(String r2) {
        return (ContentCategory) ZeusTransformUtils.preCheckCast(Enum.valueOf(ContentCategory.class, r2), ContentCategory.class, "com.obric.memorydata.plugin");
    }

    public static ContentCategory[] values() {
        return (ContentCategory[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ContentCategory[].class, "com.obric.memorydata.plugin");
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final int getValue() {
        return this.value;
    }
}
