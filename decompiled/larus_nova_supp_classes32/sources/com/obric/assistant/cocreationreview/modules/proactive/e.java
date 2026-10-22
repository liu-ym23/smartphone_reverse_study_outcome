package com.obric.assistant.cocreationreview.modules.proactive;

import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.l5;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final l5 a = null;

    static {
        a = new l5(ModuleKey.PROACTIVE_AGENT, "主动智能", "主动智能", 2131235872, -14979842, "主动智能：在关键时刻提醒并给下一步建议", CollectionsKt.listOf(new String[]{"推送频率合适", "当前场景适合", "推送时机合适", "任务状态判断准确", "参考信息准确", "符合个人偏好", "价值高，能直接帮助到我", "其他"}), CollectionsKt.listOf(new String[]{"频繁推送", "当前场景不适合", "过早/过晚推送", "任务已完成 / 取消了仍然推送", "参考信息有误", "不符合个人偏好", "价值不高，不能直接帮助到我", "其他"}), "建议写清：触发信号、建议内容、实际用户场景、期望的提醒时机或执行方式。", false, 3584);
    }
}
