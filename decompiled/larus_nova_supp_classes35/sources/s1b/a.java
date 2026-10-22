package s1b;

import android.app.Application;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.LruCache;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.LarkUriUtil;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$FileInfo;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$FilePickerCloseResult;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogAction;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogAlignActions;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogCloseOptions;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogShowOptions;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ToastShowOptions;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ToastShowResult;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$XToastType;
import com.ss.android.lark.chameleonv2.lkapi.widget.panel.h;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends z0b.a implements sa5.a {
    public final Map<String, WeakReference<UDDialog>> a;
    public WeakReference<com.ss.android.lark.chameleonv2.lkapi.widget.picker.a> b;
    public WeakReference<com.ss.android.lark.chameleonv2.lkapi.widget.picker.b> c;

    /* JADX INFO: renamed from: s1b.a$a, reason: collision with other inner class name */
    public final class C0296a extends AbsChameleonHandler<IWidget$Internal$ConfirmDialogCloseOptions> {
        public final String a;
        public final /* synthetic */ a b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public C0296a(a r1) {
            this.b = r1;
            this.a = LKAPIModules.Internal.Widget.CloseConfirmDialog.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(IWidget$Internal$ConfirmDialogCloseOptions r2, Callback r3) {
            IWidget$Internal$ConfirmDialogCloseOptions r4 = r2;
            Intrinsics.checkNotNullParameter(r4, "req");
            Intrinsics.checkNotNullParameter(r3, "callback");
            Map<String, WeakReference<UDDialog>> r0 = this.b.a;
            LinkedHashMap r1 = (LinkedHashMap) r0;
            WeakReference r5 = (WeakReference) r1.get(r4.getId());
            if (r5 == null) goto L7;
            UDDialog r6 = (UDDialog) r5.get();
            if (r6 == null) goto L7;
            r6.cancel();
        L7:
            r3.success(null);
        }
    }

    public static final class b {
    }

    public final class c extends AbsChameleonHandler<IWidget$Internal$ConfirmDialogShowOptions> {
        public final String a;
        public final /* synthetic */ a b;

        /* JADX INFO: renamed from: s1b.a$c$a, reason: collision with other inner class name */
        public /* synthetic */ class C0297a {
            public static final /* synthetic */ int[] a = null;
            public static final /* synthetic */ int[] b = null;

            static {
                int[] r0 = new int[IWidget$Internal$ConfirmDialogAlignActions.values().length];
                r0[IWidget$Internal$ConfirmDialogAlignActions.Vertical.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[IWidget$Internal$ConfirmDialogAlignActions.Horizontal.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L6:
                a = r0;
                int[] r1 = new int[UDBaseDialogBuilder.ActionBottomOrientation.values().length];
                r1[UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
            L25:
                r1[UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
            L21:
                r1[UDBaseDialogBuilder.ActionBottomOrientation.AUTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
            L10:
                b = r1;
            }
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public c(a r1) {
            this.b = r1;
            this.a = LKAPIModules.Internal.Widget.ShowConfirmDialog.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(IWidget$Internal$ConfirmDialogShowOptions r13, Callback r14) {
            IWidget$Internal$ConfirmDialogShowOptions r15 = r13;
            Intrinsics.checkNotNullParameter(r15, "req");
            Intrinsics.checkNotNullParameter(r14, "callback");
            IChameleonHandlerContext r0 = getContext();
            if (r0 != null) goto L5;
            r14.error(new LKAPIError(-1, "Chameleon Context is null"));
            return;
        L5:
            Context r2 = r0.getCmlContext();
            if (r2 != null) goto L8;
            r14.error(new LKAPIError(-1, "App Context is null"));
            return;
        L8:
            UDDialogBuilder r1 = new UDDialogBuilder(r2);
            r1.title(r15.getTitle()).message(r15.getContent());
            r1.cancelOnTouchOutside(r15.getMaskClosable());
            int r3 = r15.getActions().size();
            if (r3 == 1) goto L19;
            if (r3 == 2) goto L12;
            UDBaseDialogBuilder.ActionBottomOrientation r5 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
        L20:
            r1.actionButtonOrientation(r5);
            if (r3 == 1) goto L33;
            if (r3 == 2) goto L24;
            int[] r4 = {2131391777, 2131391778, 2131391779};
        L34:
            List r6 = CollectionsKt.take(r15.getActions(), 3);
            a r7 = this.b;
            Iterator r8 = r6.iterator();
            int r9 = 0;
        L36:
            if (r8.hasNext() == false) goto L50;
            Object r10 = r8.next();
            int r11 = r9 + 1;
            if (r9 >= 0) goto L40;
            CollectionsKt.throwIndexOverflow();
        L40:
            IWidget$Internal$ConfirmDialogAction r12 = (IWidget$Internal$ConfirmDialogAction) r10;
            if (r9 >= 0) goto L43;
        L45:
            boolean r16 = false;
        L46:
            if (r16 == false) goto L48;
            int r17 = r4[r9];
        L49:
            r1.addActionButton(r17, r12.getText(), new s1b.b(r7, r15, r0, r12));
            r9 = r11;
            goto L36
        L48:
            Integer r18 = 2131391778;
            r17 = r18.intValue();
            goto L49
        L43:
            if (r9 >= r4.length) goto L45;
            r16 = true;
            goto L46
        L50:
            r1.onCancelListener(new s1b.c(this.b, r15, r0));
            this.b.a.put(r15.getId(), new WeakReference(r1.show()));
            r14.success(null);
            return;
        L24:
            int r19 = C0297a.b[r5.ordinal()];
            if (r19 == 1) goto L32;
            if (r19 == 2) goto L31;
            if (r19 != 3) goto L30;
            r4 = new int[]{2131391778, 2131391777};
            goto L34
        L30:
            throw new NoWhenBranchMatchedException();
        L31:
            r4 = new int[]{2131391777, 2131391778};
            goto L34
        L32:
            r4 = new int[]{2131391778, 2131391777};
            goto L34
        L33:
            r4 = new int[]{2131391777};
            goto L34
        L12:
            int r20 = C0297a.a[r15.getAlignActions().ordinal()];
            if (r20 == 1) goto L18;
            if (r20 != 2) goto L17;
            r5 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
            goto L20
        L17:
            throw new NoWhenBranchMatchedException();
        L18:
            r5 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
            goto L20
        L19:
            r5 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
            goto L20
        }
    }

    public final class d extends AbsChameleonHandler<IWidget$Internal$ToastShowOptions> {
        public final String a;

        /* JADX INFO: renamed from: s1b.a$d$a, reason: collision with other inner class name */
        public /* synthetic */ class C0298a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[IWidget$Internal$XToastType.values().length];
                r0[IWidget$Internal$XToastType.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[IWidget$Internal$XToastType.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[IWidget$Internal$XToastType.WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[IWidget$Internal$XToastType.INFO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[IWidget$Internal$XToastType.LOADING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        public d() {
            this.a = LKAPIModules.Internal.Widget.ShowToast.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(IWidget$Internal$ToastShowOptions r6, Callback r7) {
            IWidget$Internal$ToastShowOptions r8 = r6;
            Intrinsics.checkNotNullParameter(r8, "req");
            Intrinsics.checkNotNullParameter(r7, "callback");
            IChameleonHandlerContext r0 = getContext();
            if (r0 != null) goto L5;
            r7.error(new LKAPIError(-1, "Chameleon Context is null"));
            return;
        L5:
            Context r1 = r0.getCmlContext();
            if (r1 != null) goto L8;
            r7.error(new LKAPIError(-1, "App Context is null"));
            return;
        L8:
            IWidget$Internal$XToastType r2 = r8.getType();
            if (r2 != null) goto L11;
            int r3 = -1;
        L12:
            if (r3 != (-1)) goto L14;
        L29:
            int r4 = 2131254921;
        L30:
            String r5 = r8.getContent();
            if (r5 != null) goto L33;
            r5 = BuildConfig.FLAVOR;
        L33:
            Long r9 = r8.getDuration();
            if (r9 == null) goto L36;
            long r10 = r9.longValue();
        L37:
            UDToast.a r11 = UDToast.build(r1);
            r11.g(r5);
            r11.d(r4);
            r11.b.d = r10;
            r11.h();
            r7.success(new IWidget$Internal$ToastShowResult(0));
            return;
        L36:
            r10 = 3000;
            goto L37
        L14:
            if (r3 != 1) goto L16;
            r4 = 2131256306;
            goto L30
        L16:
            if (r3 != 2) goto L18;
            r4 = 2131255144;
            goto L30
        L18:
            if (r3 != 3) goto L20;
            r4 = 2131256189;
            goto L30
        L20:
            if (r3 == 4) goto L29;
            if (r3 != 5) goto L25;
            r4 = 2131255040;
            goto L30
        L25:
            throw new NoWhenBranchMatchedException();
        L11:
            r3 = C0298a.a[r2.ordinal()];
            goto L12
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> b() {
        com.ss.android.lark.chameleonv2.lkapi.widget.picker.a r0 = new com.ss.android.lark.chameleonv2.lkapi.widget.picker.a();
        this.b = new WeakReference(r0);
        com.ss.android.lark.chameleonv2.lkapi.widget.picker.b r1 = new com.ss.android.lark.chameleonv2.lkapi.widget.picker.b();
        this.c = new WeakReference(r1);
        return CollectionsKt.arrayListOf(new AbsChameleonHandler[]{new c(this), new C0296a(this), r0, r1, new h(), new d()});
    }

    public a() {
        this.a = new LinkedHashMap();
    }

    public final void onActivityResult(int r18, int r19, Intent r20) {
        WeakReference<com.ss.android.lark.chameleonv2.lkapi.widget.picker.a> r4 = this.b;
        if (r4 == null) goto L35;
        com.ss.android.lark.chameleonv2.lkapi.widget.picker.a r5 = r4.get();
        if (r5 == null) goto L35;
        if (r18 != 96) goto L35;
        if (r19 == (-1)) goto L13;
        Callback r6 = r5.a;
        if (r6 == null) goto L35;
        r6.success(new IWidget$FilePickerCloseResult(new ArrayList()));
        goto L35
    L13:
        if (r20 == null) goto L15;
        ArrayList<String> r8 = r20.getStringArrayListExtra("extra.file.path.list");
    L16:
        ArrayList r9 = new ArrayList();
        if (r8 == null) goto L22;
        Iterator<String> r10 = r8.iterator();
    L20:
        if (r10.hasNext() == false) goto L32;
        String r11 = r10.next();
        Intrinsics.checkNotNull(r11);
        String r12 = FileUtils.l(r11);
        String r13 = String.valueOf(VFSFiles.b.i(r11).length());
        LruCache<String, String> r14 = l0b.a.a;
        Intrinsics.checkNotNullParameter(r11, "value");
        String r15 = UUID.randomUUID().toString();
        l0b.a.a.put(r15, r11);
        r9.add(new IWidget$FileInfo(r15, r12, r13));
    L32:
        Callback r7 = r5.a;
        if (r7 == null) goto L35;
        r7.success(new IWidget$FilePickerCloseResult(r9));
        goto L35
    L22:
        if (r20 == null) goto L32;
        ClipData r16 = r20.getClipData();
        if (r16 == null) goto L32;
        int r17 = r16.getItemCount();
        int r110 = 0;
    L26:
        if (r110 >= r17) goto L32;
        Uri r111 = r16.getItemAt(r110).getUri();
        Application r112 = LarkContext.getApplication();
        Intrinsics.checkNotNull(r111);
        Pair r113 = LarkUriUtil.g(r112, r111);
        if (r113 == null) goto L30;
        String r114 = (String) r113.component1();
        String r115 = String.valueOf(((Number) r113.component2()).longValue());
    L31:
        String r116 = r111.toString();
        LruCache<String, String> r117 = l0b.a.a;
        Intrinsics.checkNotNullParameter(r116, "value");
        String r21 = UUID.randomUUID().toString();
        l0b.a.a.put(r21, r116);
        r9.add(new IWidget$FileInfo(r21, r114, r115));
        r110 = r110 + 1;
        goto L26
    L30:
        r114 = BuildConfig.FLAVOR;
        r115 = BuildConfig.FLAVOR;
        goto L31
    L15:
        r8 = null;
    L35:
        WeakReference<com.ss.android.lark.chameleonv2.lkapi.widget.picker.b> r22 = this.c;
        if (r22 == null) goto L65;
        com.ss.android.lark.chameleonv2.lkapi.widget.picker.b r23 = r22.get();
        if (r23 != null) goto L40;
        return;
    L40:
        if (r18 == 97) goto L43;
        return;
    L43:
        if (r19 == (-1)) goto L47;
        Callback r1 = r23.a;
        if (r1 == null) goto L67;
        r1.success(new IWidget$FilePickerCloseResult(new ArrayList()));
        return;
    L67:
        return;
    L47:
        if (r20 == null) goto L49;
        ArrayList<String> r24 = r20.getStringArrayListExtra("SELECTED_PHOTOS");
    L50:
        ArrayList r2 = new ArrayList();
        if (r24 == null) goto L56;
        Iterator<String> r3 = r24.iterator();
    L54:
        if (r3.hasNext() == false) goto L56;
        String r25 = r3.next();
        VFSFiles r26 = VFSFiles.b;
        Intrinsics.checkNotNull(r25);
        VFSFile r27 = r26.i(r25);
        String[] r28 = FileUtils.a;
        long r29 = r27.length();
        String r30 = FileUtils.l(r25);
        String r31 = r27.toUri().toString();
        Intrinsics.checkNotNull(r30);
        String r32 = String.valueOf(r29);
        LruCache<String, String> r33 = l0b.a.a;
        Intrinsics.checkNotNullParameter(r31, "value");
        String r34 = UUID.randomUUID().toString();
        l0b.a.a.put(r34, r31);
        r2.add(new IWidget$FileInfo(r34, r30, r32));
    L56:
        Callback r35 = r23.a;
        if (r35 == null) goto L69;
        r35.success(new IWidget$FilePickerCloseResult(r2));
        return;
    L69:
        return;
    L49:
        r24 = null;
        goto L50
    }
}
