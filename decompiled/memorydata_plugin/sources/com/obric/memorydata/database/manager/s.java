package com.obric.memorydata.database.manager;

import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR&\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/manager/SemanticMigrationTaxonomy;", "", "<init>", "()V", "modelSubtypesByType", "", "", "", "getModelSubtypesByType", "()Ljava/util/Map;", "subtypeRemap", "", "Lkotlin/Triple;", "finalSubtypeValues", "getFinalSubtypeValues", "()Ljava/util/Set;", "strippedTagPathSql", "getStrippedTagPathSql", "()Ljava/lang/String;", "strippedTagPathSql$delegate", "Lkotlin/Lazy;", "normalizedTagPathSql", "getNormalizedTagPathSql", "normalizedTagPathSql$delegate", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f9596a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Set<String>> f9597b = null;
    private static final List<Triple<String, String, String>> c = null;
    private static final Set<String> d = null;
    private static final Lazy e = null;
    private static final Lazy f = null;

    static {
        f9596a = new s();
        Map<String, Set<String>> r1 = MapsKt.mapOf(new Pair[]{TuplesKt.to("userinfo", SetsKt.setOf(new String[]{"基础信息", "地点信息", "职业信息", "常用号码"})), TuplesKt.to("preference", SetsKt.setOf(new String[]{"音乐", "影视", "阅读", "游戏", "运动", "户外", "旅行", "艺术", "科技", "学习成长", "社交娱乐", "宠物", "口味", "外卖", "餐厅就餐", "打车", "长途出行", "购物", "住宿", "工作方式", "沟通方式", "作息", "就医", "内容消费", "创作风格", "对话与交流", "设备操作"})), TuplesKt.to("relationship", SetsKt.setOf(new String[]{"家庭", "工作", "学校", "朋友", "宠物"}))});
        f9597b = r1;
        c = CollectionsKt.listOf(new Triple[]{new Triple("interests", "生活", "住宿"), new Triple("preference", "住宿", "住宿"), new Triple("interests", "兴趣", "内容消费"), new Triple("interests", "城市生活", "内容消费"), new Triple("interests", "生活兴趣", "内容消费"), new Triple("interests", "生活资讯", "内容消费"), new Triple("preference", "内容消费", "内容消费"), new Triple("preference", "生活资讯", "内容消费"), new Triple("preference", "资讯关注", "内容消费"), new Triple("interests", "美食", "口味"), new Triple("preference", "口味", "口味"), new Triple("interests", "传统文化", "学习成长"), new Triple("interests", "学习成长", "学习成长"), new Triple("interests", "生活健康", "学习成长"), new Triple("interests", "财经投资", "学习成长"), new Triple("interests", "资讯关注", "学习成长"), new Triple("preference", "学习成长", "学习成长"), new Triple("preference", "生活服务", "学习成长"), new Triple("interests", "健康", "就医"), new Triple("preference", "生活方式", "就医"), new Triple("preference", "沟通方式", "沟通方式"), new Triple("preference", "社交", "沟通方式"), new Triple("interests", "娱乐", "社交娱乐"), new Triple("interests", "社交娱乐", "社交娱乐"), new Triple("preference", "社交娱乐", "社交娱乐"), new Triple("preference", "工具使用", "设备操作"), new Triple("preference", "生活习惯", "设备操作"), new Triple("preference", "设备操作", "设备操作"), new Triple("preference", "选择", "设备操作"), new Triple("preference", "投资", "购物"), new Triple("preference", "支付", "购物"), new Triple("preference", "日常行为", "购物"), new Triple("preference", "消费", "购物"), new Triple("preference", "购物", "购物"), new Triple("preference", "出行", "长途出行"), new Triple("preference", "通勤", "长途出行"), new Triple("preference", "长途出行", "长途出行"), new Triple("preference", "工作方式", "工作方式"), new Triple("preference", "作息", "作息"), new Triple("preference", "外卖", "外卖"), new Triple("interests", "宠物", "宠物"), new Triple("interests", "影视", "影视"), new Triple("interests", "户外", "户外"), new Triple("interests", "旅行", "旅行"), new Triple("interests", "游戏", "游戏"), new Triple("interests", "科技", "科技"), new Triple("interests", "艺术", "艺术"), new Triple("interests", "运动", "运动"), new Triple("interests", "阅读", "阅读"), new Triple("interests", "音乐", "音乐")});
        d = SetsKt.plus(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.flatten((Iterable) ZeusTransformUtils.preCheckCast(r1.values(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")), IRecommendSettings.ProfileTag.OTHER);
        e = LazyKt.lazy($$Lambda$s$SxK_eKPxZxTENtF9mhAbbMv9HHQ.INSTANCE);
        f = LazyKt.lazy($$Lambda$s$NwOueHj22T74oLnMC1Z63KrRgJo.INSTANCE);
    }

    private s() {
    }

    private static final CharSequence a(Triple r5) {
        Intrinsics.checkNotNullParameter(r5, "<destruct>");
        return (CharSequence) ZeusTransformUtils.preCheckCast("WHEN semantic_type = '" + ((String) ZeusTransformUtils.preCheckCast(r5.component1(), String.class, "com.obric.memorydata.plugin")) + "' AND " + f9596a.b() + " = '" + ((String) ZeusTransformUtils.preCheckCast(r5.component2(), String.class, "com.obric.memorydata.plugin")) + "' THEN '" + ((String) ZeusTransformUtils.preCheckCast(r5.component3(), String.class, "com.obric.memorydata.plugin")) + '\'', CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final String d() {
        String r0 = "CASE WHEN TRIM(CASE WHEN INSTR(tag_path, ',') > 0 THEN SUBSTR(tag_path, 1, INSTR(tag_path, ',') - 1) ELSE tag_path END) LIKE '%偏好' THEN SUBSTR(TRIM(CASE WHEN INSTR(tag_path, ',') > 0 THEN SUBSTR(tag_path, 1, INSTR(tag_path, ',') - 1) ELSE tag_path END), 1, LENGTH(TRIM(CASE WHEN INSTR(tag_path, ',') > 0 THEN SUBSTR(tag_path, 1, INSTR(tag_path, ',') - 1) ELSE tag_path END)) - 2) WHEN TRIM(CASE WHEN INSTR(tag_path, ',') > 0 THEN SUBSTR(tag_path, 1, INSTR(tag_path, ',') - 1) ELSE tag_path END) LIKE '%爱好' THEN SUBSTR(TRIM(CASE WHEN INSTR(tag_path, ',') > 0 THEN SUBSTR(tag_path, 1, INSTR(tag_path, ',') - 1) ELSE tag_path END), 1, LENGTH(TRIM(CASE WHEN INSTR(tag_path, ',') > 0 THEN SUBSTR(tag_path, 1, INSTR(tag_path, ',') - 1) ELSE tag_path END)) - 2) WHEN TRIM(CASE WHEN INSTR(tag_path, ',') > 0 THEN SUBSTR(tag_path, 1, INSTR(tag_path, ',') - 1) ELSE tag_path END) LIKE '%关系' THEN SUBSTR(TRIM(CASE WHEN INSTR(tag_path, ',') > 0 THEN SUBSTR(tag_path, 1, INSTR(tag_path, ',') - 1) ELSE tag_path END), 1, LENGTH(TRIM(CASE WHEN INSTR(tag_path, ',') > 0 THEN SUBSTR(tag_path, 1, INSTR(tag_path, ',') - 1) ELSE tag_path END)) - 2) ELSE TRIM(CASE WHEN INSTR(tag_path, ',') > 0 THEN SUBSTR(tag_path, 1, INSTR(tag_path, ',') - 1) ELSE tag_path END) END";
        return "CASE WHEN " + r0 + " = '' THEN '其他' WHEN semantic_type = 'relationship' AND " + r0 + " = '同事' THEN '工作' ELSE " + r0 + " END";
    }

    private static final String e() {
        String r0 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$s$qfMVuX_BU8cBgUWU7uDcAzu8_CI.INSTANCE, 30, null);
        StringBuilder r1 = new StringBuilder().append("CASE WHEN product_type = 1003 OR user_edit = 1 THEN ");
        s r2 = f9596a;
        return r1.append(r2.b()).append(" WHEN semantic_type IN ('relationship', 'userinfo') THEN ").append(r2.b()).append(' ').append(r0).append(" WHEN semantic_type IN ('interests', 'preference') THEN ").append(r2.b()).append(" ELSE tag_path END").toString();
    }

    public static /* synthetic */ String lambda$NwOueHj22T74oLnMC1Z63KrRgJo() {
        return e();
    }

    public static /* synthetic */ String lambda$SxK_eKPxZxTENtF9mhAbbMv9HHQ() {
        return d();
    }

    public static /* synthetic */ CharSequence lambda$qfMVuX_BU8cBgUWU7uDcAzu8_CI(Triple r0) {
        return a(r0);
    }

    public final Set<String> a() {
        return d;
    }

    public final String b() {
        return (String) ZeusTransformUtils.preCheckCast(e.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public final String c() {
        return (String) ZeusTransformUtils.preCheckCast(f.getValue(), String.class, "com.obric.memorydata.plugin");
    }
}
