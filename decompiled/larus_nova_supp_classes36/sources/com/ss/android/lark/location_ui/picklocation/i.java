package com.ss.android.lark.location_ui.picklocation;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i extends BasePresenter<b, c, c.a> {

    public class a implements c.a {
        public final /* synthetic */ i a;

        @Override // com.ss.android.lark.location_ui.picklocation.c.a
        public final boolean isAdminGpsEnabled() {
            return ((b) this.a.getModel()).isAdminGpsEnabled();
        }

        public a(i r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.location_ui.picklocation.c.a
        public final List v5(boolean r4) {
            List r0 = kqb.e.a().getJSONArray("location_content", POIInfo.class);
            if (CollectionUtils.isEmpty(r0) == true) goto L5;
            Iterator r1 = r0.iterator();
        L8:
            if (r1.hasNext() == false) goto L13;
            if (((POIInfo) r1.next()).getIsSelfDefine() == false) goto L8;
            if (r4 == false) goto L8;
            r1.remove();
            goto L8
        L13:
            return r0;
        L5:
            return new ArrayList();
        }

        @Override // com.ss.android.lark.location_ui.picklocation.c.a
        public final void E2(double r2, double r4) {
            ((b) this.a.getModel()).q0(r2, r4);
        }

        @Override // com.ss.android.lark.location_ui.picklocation.c.a
        public final void J3(Context r1, Bitmap r2, q r3) {
            ((b) this.a.getModel()).W6(r2, r3);
        }

        @Override // com.ss.android.lark.location_ui.picklocation.c.a
        public final void U4(Context r2, POIInfo r3, boolean r4) {
            if (r4 == true) goto L4;
        L6:
            List r5 = v5(r4);
            if (r5.contains(r3) == false) goto L9;
            return;
        L9:
            ListProtector.add(r5, 0, r3);
            if (r5.size() <= 10) goto L12;
            r5 = r5.subList(0, 10);
        L12:
            int r6 = kqb.e.a;
            Intrinsics.checkNotNullParameter(r5, LocationHitPoint$ResultType.LIST);
            kqb.e.a().putJSONArray("location_content", r5);
            return;
        L4:
            if (r3.getIsSelfDefine() == false) goto L6;
        }

        @Override // com.ss.android.lark.location_ui.picklocation.c.a
        public final void q(Context r2, POIInfo r3, k.a r4) {
            ((b) this.a.getModel()).q(r2, r3, r4);
        }

        @Override // com.ss.android.lark.location_ui.picklocation.c.a
        public final void S0(Context r2, Token r3, Scene r4, LocationView.d r5) {
            ((b) this.a.getModel()).q7(r2, r3, r4, r5);
        }

        @Override // com.ss.android.lark.location_ui.picklocation.c.a
        public final void i6(Context r2, String r3, Scene r4, LocationView.c.a r5) {
            ((b) this.a.getModel()).E5(r2, r3, r4, r5);
        }

        @Override // com.ss.android.lark.location_ui.picklocation.c.a
        public final void w6(Context r2, Scene r3, LocationView.i r4, int r5) {
            ((b) this.a.getModel()).W5(r2, r3, r4, r5);
        }

        @Override // com.ss.android.lark.location_ui.picklocation.c.a
        public final void s5(Context r11, double r12, double r14, Scene r16, LocationView.a r17) {
            ((b) this.a.getModel()).l5(r11, r12, r14, r16, r17);
        }
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new a(this);
    }

    public i(e r1, LocationView r2) {
        super(r1, r2);
    }
}
