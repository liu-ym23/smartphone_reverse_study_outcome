package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.ExpressionService")
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J4\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\u000fH&J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H&J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000fH&J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0006H&J$\u0010\u0019\u001a\u00020\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IExpressionService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "isPortrait", BuildConfig.FLAVOR, "parentViewWidth", "Lcom/bytedance/android/livesdk/interactivity/api/expression/k;", "listener", "Landroid/view/View;", "createEmojiSelectPanel", "parentViewHeight", "Lcom/bytedance/android/livesdk/interactivity/api/expression/i;", "param", "Lcom/bytedance/android/livesdk/interactivity/api/expression/j;", "createNewEmojiSelectPanel", "Lcom/bytedance/android/livesdk/interactivity/api/expression/a;", "expressionPanelConfig", "createExpressionPanelV3", "commentSendDelegate", "Lcom/bytedance/android/livesdk/interactivity/api/expression/b;", "createSimpleExpressionPanelV3", "textEmojiSizeInPx", "Lcom/bytedance/android/live/core/widget/GradientEditText;", "createEmojiEditText", "Lcom/bytedance/android/livesdk/interactivity/api/expression/c;", "mentionParam", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExpressionService extends IService {
    GradientEditText createEmojiEditText(Context r1, int r2);

    GradientEditText createEmojiEditText(Context r1, int r2, com.bytedance.android.livesdk.interactivity.api.expression.c r3);

    View createEmojiSelectPanel(Context r1, boolean r2, int r3, com.bytedance.android.livesdk.interactivity.api.expression.k r4);

    View createExpressionPanelV3(Context r1, com.bytedance.android.livesdk.interactivity.api.expression.a r2);

    View createNewEmojiSelectPanel(Context r1, boolean r2, int r3, com.bytedance.android.livesdk.interactivity.api.expression.i r4, com.bytedance.android.livesdk.interactivity.api.expression.j r5);

    com.bytedance.android.livesdk.interactivity.api.expression.b createSimpleExpressionPanelV3(Context r1, boolean r2, com.bytedance.android.livesdk.interactivity.api.expression.j r3);
}
