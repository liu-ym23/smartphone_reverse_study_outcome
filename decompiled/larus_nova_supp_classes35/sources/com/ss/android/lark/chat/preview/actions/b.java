package com.ss.android.lark.chat.preview.actions;

import android.content.Context;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.chat.entity.preview.GetAction;
import com.ss.android.lark.chat.entity.preview.LarkCommandAction;
import com.ss.android.lark.chat.entity.preview.OpenUrlAction;
import com.ss.android.lark.chat.entity.preview.PostAction;
import com.ss.android.lark.chat.entity.preview.ShowDialogAction;
import com.ss.android.lark.chat.entity.preview.ShowToastAction;
import com.ss.android.lark.chat.entity.preview.SwitchStateAction;
import com.ss.android.lark.export.entity.preview.BaseAction;
import com.ss.android.lark.export.entity.preview.Parameters;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlPreviewAction;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import vcb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class b {
    public static final /* synthetic */ int h = 0;
    public final UrlPreviewAction a;
    public final String b;
    public final UrlPreviewBody c;
    public final d d;
    public final Map<String, UrlPreviewAction> e;
    public final URLPreviewParams f;
    public final Lazy g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.preview.actions.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0106b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[ShowToastAction.ToastType.values().length];
            r0[ShowToastAction.ToastType.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L46:
            r0[ShowToastAction.ToastType.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L60:
            r0[ShowToastAction.ToastType.WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L48:
            r0[ShowToastAction.ToastType.INFO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L10:
            a = r0;
            int[] r1 = new int[ShowDialogAction.DialogButtonType.values().length];
            r1[ShowDialogAction.DialogButtonType.DANGER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L50:
            r1[ShowDialogAction.DialogButtonType.PRIMARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L13:
            b = r1;
            int[] r2 = new int[UrlPreviewAction.Method.values().length];
            r2[UrlPreviewAction.Method.OPEN_URL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L40:
            r2[UrlPreviewAction.Method.LARK_COMMAND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L52:
            r2[UrlPreviewAction.Method.GET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L38:
            r2[UrlPreviewAction.Method.POST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L56:
            r2[UrlPreviewAction.Method.SWITCH_STATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L42:
            r2[UrlPreviewAction.Method.SHOW_TOAST.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L44:
            r2[UrlPreviewAction.Method.SHOW_DIALOG.ordinal()] = 7;     // Catch: NoSuchFieldError -> L35
        L21:
            c = r2;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.ss.android.lark.chat.preview.actions.ActionImpl$onActionTriggered$1] */
    public void a(final int r11) {
        UrlPreviewAction r0 = this.a;
        if (r0 == null) goto L128;
        String r1 = this.b;
        if (r11 > 10) goto L146;
        boolean r3 = true;
        Parameters r4 = null;
        switch(C0106b.c[r0.getMethod().ordinal()]) {
            case 1: goto L93;
            case 2: goto L79;
            case 3: goto L79;
            case 4: goto L79;
            case 5: goto L74;
            case 6: goto L58;
            case 7: goto L10;
            default: goto L9;
        };
    L9:
        Log.i("ActionImpl", "action method:" + r0.getMethod());
        return;
    L10:
        BaseAction r2 = r0.getAction();
        if ((r2 instanceof ShowDialogAction) == false) goto L130;
        ShowDialogAction r5 = (ShowDialogAction) r2;
        ShowDialogAction.DialogItem r6 = r5.getTitle();
        if (r6 == null) goto L17;
        Integer r7 = r6.getNumberOfLines();
        if (r7 == null) goto L17;
        int r8 = r7.intValue();
    L18:
        if (r8 <= 0) goto L24;
        if (r6 == null) goto L23;
        Integer r9 = r6.getNumberOfLines();
        if (r9 == null) goto L23;
        int r10 = r9.intValue();
    L25:
        ShowDialogAction.DialogItem r12 = r5.getContent();
        ArrayList<ShowDialogAction.a> r13 = r5.getButtons();
        UDDialogBuilder r14 = new UDDialogBuilder(this.d.getContext()).actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL);
        String r15 = BuildConfig.FLAVOR;
        if (r6 == null) goto L29;
        String r16 = r6.getText();
        if (r16 == null) goto L29;
    L30:
        UDDialogBuilder r17 = r14.title(r16).titleBold(true).titleLineCount(r10);
        if (r12 == null) goto L36;
        String r18 = r12.getText();
        if (r18 == null) goto L36;
        r15 = r18;
    L36:
        UDDialogBuilder r19 = r17.message(r15);
        if (r13 == null) goto L51;
        Iterator<T> r20 = r13.iterator();
    L40:
        if (r20.hasNext() == false) goto L51;
        ShowDialogAction.a r21 = (ShowDialogAction.a) r20.next();
        ShowDialogAction.DialogButtonType r22 = r21.getType();
        if (r22 != null) goto L44;
        int r23 = -1;
    L45:
        if (r23 == 1) goto L49;
        if (r23 == 2) goto L48;
        UDBaseDialogBuilder.ActionBuilder r24 = new UDBaseDialogBuilder.ActionBuilder().textColor(UDColorUtils.getColor(this.d.getContext(), 2131106622)).actionResId(2131391777);
    L50:
        r24.text(r21.a).onClickListener(new c(r21, this, r11));
        r19.addActionButton(r24);
        goto L40
    L48:
        r24 = new UDBaseDialogBuilder.ActionBuilder().textColor(UDColorUtils.getColor(this.d.getContext(), 2131105548)).actionResId(2131391778);
        goto L50
    L49:
        r24 = new UDBaseDialogBuilder.ActionBuilder().textColor(UDColorUtils.getColor(this.d.getContext(), 2131102093)).actionResId(2131391779);
        goto L50
    L44:
        r23 = C0106b.b[r22.ordinal()];
    L51:
        if (r13 == null) goto L53;
        int r110 = r13.size();
    L54:
        if (r110 <= 2) goto L56;
        UDDialogBuilder r111 = r19.actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL);
    L57:
        r19.cancelOnTouchOutside(false).show();
        return;
    L56:
        UDDialogBuilder r112 = r19.actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL);
        goto L57
    L53:
        r110 = 0;
    L29:
        r16 = BuildConfig.FLAVOR;
    L23:
        r10 = 0;
        goto L25
    L24:
        r10 = Integer.MAX_VALUE;
    L17:
        r8 = 0;
        goto L18
    L130:
        return;
    L58:
        BaseAction r113 = r0.getAction();
        if ((r113 instanceof ShowToastAction) == false) goto L132;
        ShowToastAction r114 = (ShowToastAction) r113;
        int r25 = C0106b.a[r114.getType().ordinal()];
        if (r25 == 1) goto L72;
        if (r25 != 2) goto L64;
        int r26 = 2131255144;
    L73:
        UDToast.a r27 = UDToast.build(this.d.getContext());
        r27.g(r114.getContent());
        r27.d(r26);
        r27.b.d = r114.getDuration();
        r27.h();
        return;
    L64:
        if (r25 != 3) goto L66;
        r26 = 2131256189;
        goto L73
    L66:
        if (r25 != 4) goto L69;
        r26 = 2131254921;
        goto L73
    L69:
        throw new NoWhenBranchMatchedException();
    L72:
        r26 = 2131256306;
        goto L73
    L132:
        return;
    L74:
        BaseAction r115 = r0.getAction();
        if ((r115 instanceof SwitchStateAction) == false) goto L134;
        vcb.a r28 = (vcb.a) new WeakReference(this.d.c).get();
        if (r28 == null) goto L135;
        r28.a(this.f.a, ((SwitchStateAction) r115).getNextStateId());
        return;
    L135:
        return;
    L134:
        return;
    L79:
        BaseAction r29 = r0.getAction();
        if ((r29 instanceof LarkCommandAction) == false) goto L83;
        r4 = ((LarkCommandAction) r29).getParameters();
    L88:
        g6b.a.InterfaceC0223a r30 = (g6b.a.InterfaceC0223a) this.g.getValue();
        if (r30 == null) goto L137;
        com.ss.android.lark.officesdk.integrator.im.a r31 = r30.a();
        if (r31 == null) goto L138;
        r31.b(r4, r1, new ActionImpl$onActionTriggered$1(this, r11));
        return;
    L138:
        return;
    L137:
        return;
    L83:
        if ((r29 instanceof GetAction) == false) goto L86;
        r4 = ((GetAction) r29).getParameters();
        goto L88
    L86:
        if ((r29 instanceof PostAction) == false) goto L88;
        r4 = ((PostAction) r29).getParameters();
        goto L88
    L93:
        BaseAction r116 = r0.getAction();
        if ((r116 instanceof OpenUrlAction) == false) goto L140;
        OpenUrlAction r117 = (OpenUrlAction) r116;
        Url r32 = r117.getOpenUrl();
        if (r32 == null) goto L98;
        String r33 = r32.getAndroidUrl();
    L99:
        if (r33 != null) goto L101;
    L104:
        if (r3 == false) goto L114;
        g6b.a.InterfaceC0223a r34 = (g6b.a.InterfaceC0223a) this.g.getValue();
        if (r34 == null) goto L141;
        com.ss.android.lark.officesdk.integrator.im.a r35 = r34.a();
        if (r35 == null) goto L142;
        Context r36 = this.d.getContext();
        Url r118 = r117.getOpenUrl();
        if (r118 == null) goto L112;
        String r119 = r118.getUrl();
    L113:
        r35.a(r36, r119, null);
        return;
    L112:
        r119 = null;
        goto L113
    L142:
        return;
    L141:
        return;
    L114:
        g6b.a.InterfaceC0223a r37 = (g6b.a.InterfaceC0223a) this.g.getValue();
        if (r37 == null) goto L144;
        com.ss.android.lark.officesdk.integrator.im.a r38 = r37.a();
        if (r38 == null) goto L145;
        Context r39 = this.d.getContext();
        Url r120 = r117.getOpenUrl();
        if (r120 == null) goto L121;
        String r121 = r120.getAndroidUrl();
    L122:
        r38.a(r39, r121, null);
        return;
    L121:
        r121 = null;
        goto L122
    L145:
        return;
    L144:
        return;
    L101:
        if (r33.length() == 0) goto L104;
        r3 = false;
        goto L104
    L98:
        r33 = null;
        goto L99
    L140:
        return;
    L146:
        return;
    }

    public b(UrlPreviewAction r2, String r3, UrlPreviewBody r4, d r5, Map r6) {
        Intrinsics.checkNotNullParameter(r5, "dependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r5.d;
        this.g = LazyKt.lazy(ActionImpl$sChatPreviewDependency$2.INSTANCE);
    }
}
