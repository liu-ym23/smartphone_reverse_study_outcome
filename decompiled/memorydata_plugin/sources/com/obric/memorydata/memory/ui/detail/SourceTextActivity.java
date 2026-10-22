package com.obric.memorydata.memory.ui.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.databinding.ActivitySourceTextBinding;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.utils.ba;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/SourceTextActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/ActivitySourceTextBinding;", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SourceTextActivity extends BaseMemoryActivity {
    private static final String ARG_TEXT = "arg_text";
    public static final a Companion = null;
    private static final String TAG = "SourceTextActivity";
    private ActivitySourceTextBinding binding;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/SourceTextActivity$Companion;", "", "<init>", "()V", "ARG_TEXT", "", "TAG", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3, String r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            Intent r5 = new Intent(r2, SourceTextActivity.class);
            r5.putExtra(SourceTextActivity.ARG_TEXT, r4);
            ZeusTransformUtils.startActivity(r2, r5, "com.obric.memorydata.plugin");
        }
    }

    static {
        Companion = new a(null);
    }

    public SourceTextActivity() {
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        int r0 = ba.c();
        boolean r1 = isLocked();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onBackPressed taskId=" + getTaskId() + ", numActivities=" + r0 + ", locked=" + r1, false, 4, null);
        if (r1 == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onBackPressed: locked → exitApp", false, 4, null);
        exitApp();
        return;
    L6:
        super.onBackPressed();
        com.obric.memorydata.ui.h.f13009a.c((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
        finish();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r9) {
        com.obric.memorydata.ui.h.f13009a.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
        prepareSystemBar();
        ActivitySourceTextBinding r10 = ActivitySourceTextBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r10, "inflate(...)");
        this.binding = r10;
        ActivitySourceTextBinding r2 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r10.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivitySourceTextBinding r11 = this.binding;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L8:
        OScrollView r12 = r11.sourceTextContainer;
        Intrinsics.checkNotNullExpressionValue(r12, "sourceTextContainer");
        com.obric.memorydata.ui.g.a((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        ActivitySourceTextBinding r13 = this.binding;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L11:
        OFloatingTitleBar r14 = r13.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r14, "viewTitle");
        ActivitySourceTextBinding r5 = this.binding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L14:
        View r6 = (View) ZeusTransformUtils.preCheckCast(r5.sourceTextContainer, View.class, "com.obric.memorydata.plugin");
        int r7 = MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        ActivitySourceTextBinding r8 = this.binding;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L17:
        setupTitleBarBackAction(r14, r6, r7, r8.cutOff);
        ActivitySourceTextBinding r15 = this.binding;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L20:
        OFloatingTitleBar r16 = r15.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r16, "viewTitle");
        registerFloatingTitleBar(r16);
        Intent r17 = getIntent();
        if (r17 == null) goto L24;
        String r18 = r17.getStringExtra(ARG_TEXT);
        if (r18 == null) goto L24;
    L25:
        ActivitySourceTextBinding r3 = this.binding;
        if (r3 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L28:
        OTextView r4 = r3.tvSourceFullText;
        Intrinsics.checkNotNullExpressionValue(r4, "tvSourceFullText");
        com.obric.memorydata.memory.ui.m.a((TextView) ZeusTransformUtils.preCheckCast(r4, TextView.class, "com.obric.memorydata.plugin"), null, 1, null);
        ActivitySourceTextBinding r19 = this.binding;
        if (r19 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L32:
        r2.tvSourceFullText.setText((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L31:
        r2 = r19;
    L24:
        r18 = "";
        goto L25
    }
}
