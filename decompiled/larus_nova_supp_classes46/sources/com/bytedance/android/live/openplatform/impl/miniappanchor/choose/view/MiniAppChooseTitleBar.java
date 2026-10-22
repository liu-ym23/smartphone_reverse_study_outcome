package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.model.MemoryStatus;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.MiniAppChooseTalentSettingUtil;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.widget.MiniAppChooseSettingDialog;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.popup.LiveRepelPopupRegion;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0016B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fB\u001b\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000e\u0010\u0012B#\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u000e\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\t0\u0004J\u0014\u0010\u000b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/view/MiniAppChooseTitleBar;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/android/live/openplatform/api/model/MemoryStatus;", "getCurrentMemoryStatus", "Lkotlin/Function0;", "", "listener", "setCloseBtnOnClickListener", "setHelpBtnOnClickListener", "", "setHelpBtnOnLongClickListener", "setSearchBtnOnClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppChooseTitleBar extends RelativeLayout {
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;
    public Map<Integer, View> a;
    public final SharedPrefHelper b;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.invoke();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.invoke();
        }
    }

    public static final class d implements View.OnLongClickListener {
        public final /* synthetic */ Function0 a;

        public d(Function0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r1) {
            return ((Boolean) this.a.invoke()).booleanValue();
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public e(Function0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.invoke();
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ MiniAppChooseTitleBar a;

        public f(MiniAppChooseTitleBar r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            FragmentActivity r5 = this.a.getContext();
            if (r5 == null) goto L17;
            FragmentManager r6 = r5.getSupportFragmentManager();
            if (MiniAppChooseTalentSettingUtil.b() == false) goto L9;
            boolean r1 = true;
            if (this.a.a(2131388030).getSelectedTabPosition() != 1) goto L9;
        L10:
            int r0 = MiniAppChooseSettingDialog.h;
            MemoryStatus r2 = MiniAppChooseTitleBar.b(this.a);
            Intrinsics.checkNotNullParameter(r2, "memoryStatus");
            MiniAppChooseSettingDialog r3 = new MiniAppChooseSettingDialog();
            r3.f = r2;
            r3.g = r1;
            LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "MiniAppChooseSettingDialog", r7);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r3, r7) == true) goto L21;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
        L14:
            r3.show(r6, "MiniAppChooseSettingDialog");
            return;
        L21:
            return;
        L9:
            r1 = false;
            goto L10
        L17:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    static {
        String r0 = "";
        StringBuilder r1 = new StringBuilder("miniapp_auto_open_memory_uid_key:");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        IUserService r3 = k.f(IUserService.class);     // Catch: Throwable -> L12
        if (r3 == null) goto L9;
        com.bytedance.android.livesdk.user.f r4 = r3.user();     // Catch: Throwable -> L12
        if (r4 == null) goto L9;
        String r5 = r4.n();     // Catch: Throwable -> L12
        if (r5 == null) goto L9;
    L10:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r6) == false) goto L17;
        r6 = "";
    L17:
        r1.append((String) r6);
        c = r1.toString();
        IHostContext r7 = k.f(IHostContext.class);
        if (r7 == null) goto L21;
        String r8 = r7.getServerDeviceId();
        if (r8 == null) goto L21;
    L22:
        d = "miniapp_close_memory_did_key:".concat(r8);
        IHostContext r9 = k.f(IHostContext.class);
        if (r9 == null) goto L28;
        String r10 = r9.getServerDeviceId();
        if (r10 == null) goto L28;
        r0 = r10;
    L28:
        e = "miniapp_talent_tip_show_did_key:".concat(r0);
        return;
    L21:
        r8 = "";
    L9:
        r5 = "";
    L12:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    private final MemoryStatus getCurrentMemoryStatus() {
        IOpenPlatformAnchorService r0 = (IOpenPlatformAnchorService) k.f(IOpenPlatformAnchorService.class);
        if (r0 == null) goto L7;
        MemoryStatus r1 = r0.getMemoryStatus();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new MemoryStatus(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public MiniAppChooseTitleBar(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ MemoryStatus b(MiniAppChooseTitleBar r0) {
        return r0.getCurrentMemoryStatus();
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void c(String r7) {
        Intrinsics.checkNotNullParameter(r7, "text");
        Context r0 = getContext();
        if (r0 == null) goto L17;
        pp0.b r1 = new pp0.b();
        Intrinsics.checkNotNullParameter(r0, "context");
        View r3 = LayoutInflater.from(r0).inflate(2131566943, null);
        r1.a = (TextView) r3.findViewById(2131382780);
        r1.b = r3.findViewById(2131382771);
        int r4 = yo2.f.x;
        LiveRepelPopupRegion r5 = LiveRepelPopupRegion.PREVIEW_FULL;
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r5, "region");
        yo2.f r2 = new yo2.f(r0);
        ((yo2.d) r2).l = true;
        ((yo2.d) r2).d = r3;
        boolean r6 = false;
        ((yo2.d) r2).e = 0;
        r2.a();
        r1.c = r2;
        Intrinsics.checkNotNullParameter(r7, "content");
        TextView r8 = r1.a;
        if (r8 == null) goto L7;
        r8.setText(r7);
    L7:
        View r9 = a(2131385974);
        Intrinsics.checkNotNullParameter(r9, "view");
        yo2.f r10 = r1.c;
        if (r10 == null) goto L10;
        r6 = r10.h();
    L10:
        if (r6 == false) goto L13;
        return;
    L13:
        if (UIUtils.isViewVisible(r9) == false) goto L19;
        r9.post(new pp0.a(r1, r9));
        r1.d.start();
        return;
    L19:
        return;
    }

    public final void d(boolean r5) {
        if (r5 == true) goto L6;
        ((ImageView) a(2131385974)).setVisibility(8);
        return;
    L6:
        ((ImageView) a(2131385974)).setVisibility(0);
        if (getCurrentMemoryStatus().a != 2) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L14;
        SharedPrefHelper r7 = this.b;
        String r2 = c;
        int r8 = r7.h(r2, 0);
        if (r8 != 0) goto L17;
        c(s1.B(2131920380));
        this.b.m(r2, Integer.valueOf(r8 + 1));
    L17:
        ((ImageView) a(2131385974)).setOnClickListener(new f(this));
        return;
    L14:
        SharedPrefHelper r9 = this.b;
        String r3 = d;
        int r10 = r9.h(r3, 0);
        if (r10 != 0) goto L17;
        c(s1.B(2131920381));
        this.b.m(r3, Integer.valueOf(r10 + 1));
        goto L17
    L9:
        r6 = false;
        goto L10
    }

    public final void setCloseBtnOnClickListener(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ImageView) a(2131366984)).setOnClickListener(new b(r3));
    }

    public final void setHelpBtnOnClickListener(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ImageView) a(2131374328)).setOnClickListener(new c(r3));
    }

    public final void setHelpBtnOnLongClickListener(Function0<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ImageView) a(2131374328)).setOnLongClickListener(new d(r3));
    }

    public final void setSearchBtnOnClickListener(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ImageView) a(2131385343)).setOnClickListener(new e(r3));
    }

    public MiniAppChooseTitleBar(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public MiniAppChooseTitleBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.b = SharedPrefHelper.b(s1.getContext());
        LayoutInflater.from(r2).inflate(2131566948, this);
    }
}
