package com.obric.aiproactive.ui.preference;

import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInterviewContent;", "", "<init>", "()V", "pages", "", "Lcom/obric/aiproactive/ui/preference/GuidedPreferencePage;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f6771a = null;

    static {
        f6771a = new g();
    }

    private g() {
    }

    public final List<o> a() {
        return CollectionsKt.listOf(new o[]{new o("你希望豆包成为哪种角色？", "豆包想先了解你喜欢的相处方式", GuidedPreferenceSelectionMode.MULTIPLE, CollectionsKt.listOf(new m[]{new m("q1_work", "效率助手", "少寒暄，直接帮我抓重点、拆步骤、推进下一步", "希望豆包作为效率助手：少寒暄，直接帮我抓重点、拆步骤、推进下一步", null, false, false, 112, null), new m("q1_meeting", "靠谱参谋", "分析利弊和风险，给出清晰建议，不急着替我决定", "希望豆包作为靠谱参谋：分析利弊和风险，给出清晰建议，不急着替我决定", null, false, false, 112, null), new m("q1_people", "生活管家", "帮我留意日常安排和琐事，减少我要操心的细节", "希望豆包作为生活管家：帮我留意日常安排和琐事，减少我要操心的细节", null, false, false, 112, null), new m("q1_daily", "贴心伙伴", "语气更温和，多一点理解和陪伴，接住我的情绪", "希望豆包作为贴心伙伴：语气更温和，多一点理解和陪伴，接住我的情绪", null, false, false, 112, null), new m("q1_commitment", "灵感搭子", "发散更多想法，给我提供不同角度和新点子", "希望豆包作为灵感搭子：发散更多想法，给我提供不同角度和新点子", null, false, false, 112, null), new m("q1_other", IRecommendSettings.ProfileTag.OTHER, null, null, null, true, true, 28, null)})), new o("你希望豆包主动提醒或帮忙的频率是怎样的？", "豆包希望提供真正的帮助，而不是打扰", GuidedPreferenceSelectionMode.SINGLE, CollectionsKt.listOf(new m[]{new m("q2_important", "只提醒最重要的事情", null, "只提醒最重要的事情", null, false, false, 116, null), new m("q2_anything", "有事情都可以告诉我", null, "有事情都可以告诉我", null, false, false, 116, null), new m("q2_weekday", "只在工作日提醒我", null, "只在工作日提醒我", null, false, false, 116, null), new m("q2_other", IRecommendSettings.ProfileTag.OTHER, null, null, null, true, true, 28, null)})), new o("你最近有哪些小目标？想到啥都可以跟我说！", "持续做好一件事不容易，豆包也想出点力", GuidedPreferenceSelectionMode.MULTIPLE, CollectionsKt.listOf(new m[]{new m("q3_work", "在工作上，我想…", null, null, "在工作上，我想", true, false, 76, null), new m("q3_health", "在健康上，我想…", null, null, "在健康上，我想", true, false, 76, null), new m("q3_body", "在身材上，我想…", null, null, "在身材上，我想", true, false, 76, null), new m("q3_wealth", "在财富上，我想…", null, null, "在财富上，我想", true, false, 76, null), new m("q3_growth", "在成长上，我想…", null, null, "在成长上，我想", true, false, 76, null), new m("q3_other", IRecommendSettings.ProfileTag.OTHER, null, null, null, true, true, 28, null)}))});
    }
}
