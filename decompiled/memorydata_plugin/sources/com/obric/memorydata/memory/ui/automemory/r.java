package com.obric.memorydata.memory.ui.automemory;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.memory.ui.settings.MemorySettingsActivity;
import com.obric.memorydata.plugin.R;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"showAutoMemorySettingsMenu", "", "activity", "Landroid/app/Activity;", "anchor", "Landroid/view/View;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class r {
    private static final Unit a(Ref.ObjectRef r1, Activity r2, View r3, int r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        com.obric.oui.popover.v2.a r6 = (com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(r1.element, com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L5;
        r6.dismiss();
    L5:
        MemorySettingsActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [T, com.obric.oui.popover.v2.a] */
    public static final void a(Activity r18, View r19) {
        final Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r18, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "activity");
        Intrinsics.checkNotNullParameter(r19, "anchor");
        OPopoverEntranceMenuView.Builder r2 = new OPopoverEntranceMenuView.Builder((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin"));
        final Ref.ObjectRef r4 = new Ref.ObjectRef();
        OPopoverEntranceMenuView.Builder.a(r2, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.memory_menu_setting_icon, "drawable", "memory_menu_setting_icon")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(r0.getString(ZeusTransformUtils.mapRes(R.string.memory_list_setting_menu_text, TypedValues.Custom.S_STRING, "memory_list_setting_menu_text")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$r$qqej1WmEHjS3LRYJ5X4TZLsT0kI(r4, r0), 182, null);
        r2.b();
        OPopoverEntranceMenuView r3 = r2.c();
        ?? r1 = ((com.obric.oui.popover.v2.a.C0765a) ZeusTransformUtils.preCheckCast(new com.obric.oui.popover.v2.a.C0765a((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin")).a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")), com.obric.oui.popover.v2.a.C0765a.class, "com.obric.memorydata.plugin")).F();
        com.obric.oui.popover.v2.e.a(com.obric.oui.popover.v2.e.f14366a, r1, r19, 5, false, 0, false, 0, 0, 248, null);
        r4.element = r1;
    }

    public static /* synthetic */ Unit lambda$qqej1WmEHjS3LRYJ5X4TZLsT0kI(Ref.ObjectRef r0, Activity r1, View r2, int r3) {
        return a(r0, r1, r2, r3);
    }
}
