package com.bytedance.ies.xelement.viewpager.childitem;

import al.a;
import android.content.Context;
import android.view.View;
import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.z;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xe.i;
import ye.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/childitem/LynxViewpagerItem;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lye/f;", "", "tag", "", "setTag", "(Ljava/lang/String;)V", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxViewpagerItem extends UIGroup<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f6549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6550c;

    public LynxViewpagerItem(b0 r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        return new f(r5, this);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r5) {
        super.setEvents(r5);
        if (r5 == null) goto L6;
        this.f6550c = r5.containsKey("attach");
        return;
    }

    @c0(name = "tag")
    public final void setTag(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        this.f6548a = r5;
        a r10 = this.f6549b;
        if (r10 == null) goto L10;
        Intrinsics.checkNotNullParameter(r5, "tag");
        i r11 = ((BaseLynxViewPager) r10.f314b).j();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "newTag");
        ArrayList r12 = r11.f23117i;
        LynxTabBarView r13 = r11.f23114b;
        int r14 = r10.f313a;
        if (r13 == null) goto L8;
        r14 = r14 - 1;
    L8:
        r12.set(r14, r5);
        r11.d.notifyDataSetChanged();
        r11.e();
        return;
    }

    public LynxViewpagerItem(b0 r5, z r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
    }
}
