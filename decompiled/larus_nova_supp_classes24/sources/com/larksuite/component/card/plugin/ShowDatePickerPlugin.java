package com.larksuite.component.card.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Size;
import androidx.appcompat.app.AppCompatDialog;
import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.component.card.component.CardCalendarDialogFactory$CardCalendarDialogStyle;
import com.larksuite.component.card.component.CardCalendarDialogFactory$CardCalendarType;
import com.larksuite.component.card.navigation.UniversalCardLargeScreenAdapt;
import com.larksuite.component.card.utils.UniversalCardHostInfoManager;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0003\u000f\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0012"}, d2 = {"Lcom/larksuite/component/card/plugin/ShowDatePickerPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "showMsgCardDateTimePickerAsync", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/ShowDatePickerPlugin$MsgCardDatePickerApiRequest;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/component/card/plugin/CallbackProcessResponse;", "enableTimePickerFix", "", "Companion", "MsgCardDatePickerApiRequest", "WindowSizeObserver", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ShowDatePickerPlugin extends OPPlugin {
    public static final a Companion = null;
    private static final String TAG = "ShowCardDatePickerPlugin";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/larksuite/component/card/plugin/ShowDatePickerPlugin$MsgCardDatePickerApiRequest;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "initialDate", "", "getInitialDate", "()Ljava/lang/String;", "setInitialDate", "(Ljava/lang/String;)V", "tag", "getTag", "setTag", "name", "getName", "setName", "elementId", "getElementId", "setElementId", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MsgCardDatePickerApiRequest extends LKBaseRequestModel {

        @JSONField(name = "elementID")
        @LKRequiredParam
        private String elementId;

        @JSONField(name = "initialDate")
        private String initialDate;

        @JSONField(name = "name")
        private String name;

        @JSONField(name = "tag")
        private String tag;

        public MsgCardDatePickerApiRequest() {
        }

        public final String getElementId() {
            return this.elementId;
        }

        public final String getInitialDate() {
            return this.initialDate;
        }

        public final String getName() {
            return this.name;
        }

        public final String getTag() {
            return this.tag;
        }

        public final void setElementId(String r1) {
            this.elementId = r1;
        }

        public final void setInitialDate(String r1) {
            this.initialDate = r1;
        }

        public final void setName(String r1) {
            this.name = r1;
        }

        public final void setTag(String r1) {
            this.tag = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements UniversalCardHostInfoManager.c {
        public final WeakReference<UDDialog> a;

        public b(UDDialog r2) {
            Intrinsics.checkNotNullParameter(r2, "dialog");
            this.a = new WeakReference(r2);
        }

        @Override // com.larksuite.component.card.utils.UniversalCardHostInfoManager.c
        public final void a(Size r2) {
            Intrinsics.checkNotNullParameter(r2, "size");
            AppCompatDialog r3 = (UDDialog) this.a.get();
            if (r3 == null) goto L6;
            r3.cancel();
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MsgCardDatePickerApiRequest a;
        public final /* synthetic */ ShowDatePickerPlugin b;
        public final /* synthetic */ LKEvent c;
        public final /* synthetic */ j18.f<CallbackProcessResponse> d;

        public static final class a implements DialogInterface.OnDismissListener {
            public final /* synthetic */ LKEvent a;
            public final /* synthetic */ b b;

            public a(LKEvent r1, b r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface r3) {
                Object r4 = this.a.h;
                com.larksuite.component.card.service.c r1 = null;
                if ((r4 instanceof ILynxBridgeContext) == false) goto L5;
                ILynxBridgeContext r5 = (ILynxBridgeContext) r4;
            L6:
                if (r5 == null) goto L12;
                ILynxContainerContext r6 = r5.getContainerContext();
                if (r6 == null) goto L12;
                Map r7 = r6.getBizExtra();
                if (r7 == null) goto L12;
                Object r8 = r7.get("card_service");
            L14:
                if ((r8 instanceof com.larksuite.component.card.service.d) == true) goto L16;
                r8 = null;
            L16:
                com.larksuite.component.card.service.d r9 = (com.larksuite.component.card.service.d) r8;
                if (r9 == null) goto L20;
                r1 = r9.getService(gz7.c.class);
            L20:
                gz7.c r2 = (gz7.c) r1;
                if (r2 == null) goto L24;
                r2.a(this.b);
                return;
            L24:
                return;
            L12:
                r8 = null;
                goto L14
            L5:
                r5 = null;
                goto L6
            }
        }

        public static final class b implements DialogInterface.OnCancelListener {
            public final /* synthetic */ j18.f<CallbackProcessResponse> a;

            public b(j18.f<CallbackProcessResponse> r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface r2) {
                CallbackProcessResponse r3 = new CallbackProcessResponse();
                n18.b r0 = g.a;
                r3.setApiErrNo(g.a);
                this.a.callback(r3);
            }
        }

        /* JADX INFO: renamed from: com.larksuite.component.card.plugin.ShowDatePickerPlugin$c$c, reason: collision with other inner class name */
        public static final class C0024c implements com.larksuite.component.card.component.d {
            public final /* synthetic */ LKEvent a;
            public final /* synthetic */ j18.f<CallbackProcessResponse> b;
            public final /* synthetic */ MsgCardDatePickerApiRequest c;
            public final /* synthetic */ Ref.ObjectRef<String> d;

            public C0024c(LKEvent r1, j18.f<CallbackProcessResponse> r2, MsgCardDatePickerApiRequest r3, Ref.ObjectRef<String> r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // com.larksuite.component.card.component.d
            public final void a(String r13, long r14) {
                Intrinsics.checkNotNullParameter(r13, "time");
                Object r0 = this.a.h;
                com.larksuite.component.card.cardcontainer.c r2 = null;
                if ((r0 instanceof ILynxBridgeContext) == false) goto L13;
                Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext");
                ILynxContainerContext r1 = ((ILynxBridgeContext) r0).getContainerContext();
                if (r1 == null) goto L9;
                Map r3 = r1.getBizExtra();
                if (r3 == null) goto L9;
                Object r4 = r3.get("card_share_data");
            L11:
                if ((r4 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L13;
                r2 = (com.larksuite.component.card.cardcontainer.c) r4;
            L9:
                r4 = null;
            L13:
                if (r2 != null) goto L16;
                Log.e(ShowDatePickerPlugin.TAG, "card share data is null");
                CallbackProcessResponse r15 = new CallbackProcessResponse();
                r15.setApiErrNo(o18.a.e);
                this.b.callback(r15);
                return;
            L16:
                com.larksuite.component.card.monitor.a.b(r2.b.getVersion(), "interaction", this.c.getTag(), r2.c.getMonitorData(), r2.b.getCardID(), null, r2.b.isStreamingMode(), null, 160);
                int r5 = com.larksuite.component.card.utils.i.a;
                String r6 = (String) this.d.element;
                String r16 = new SimpleDateFormat(r6, Locale.US).format(new Date(r14));     // Catch: Exception -> L19
            L21:
                CallbackProcessResponse r17 = new CallbackProcessResponse();
                r17.setSelectText(r16);
                r17.setSelectValue(r13);
                r17.setTimezone(TimeZone.getDefault().getID());
                this.b.callback(r17);
                return;
            L19:
                e = move-exception;
                Log.w("TimeUtil", "parse time exception", e);
                r16 = "";
                goto L21
            }
        }

        public c(MsgCardDatePickerApiRequest r1, ShowDatePickerPlugin r2, LKEvent r3, j18.f<CallbackProcessResponse> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [android.app.Dialog, com.larksuite.component.universe_design.dialog.UDDialog, java.lang.Object] */
        public final void a() {
            CardCalendarDialogFactory$CardCalendarType r0 = CardCalendarDialogFactory$CardCalendarType.Date;
            Ref.ObjectRef r1 = new Ref.ObjectRef();
            r1.element = "yyyy-MM-dd";
            if (Intrinsics.areEqual(this.a.getTag(), "picker_time") == false) goto L6;
            r0 = CardCalendarDialogFactory$CardCalendarType.Time;
            r1.element = "HH:mm";
        L8:
            com.larksuite.component.card.service.c r5 = null;
            if (TextUtils.isEmpty(this.a.getInitialDate()) == false) goto L11;
            long r6 = System.currentTimeMillis();
        L39:
            if (r6 != (-1)) goto L42;
            r6 = System.currentTimeMillis();
        L42:
            if (UniversalCardLargeScreenAdapt.b() == false) goto L51;
            Context r2 = this.c.getContext();
            if (r2 != null) goto L46;
        L50:
            CardCalendarDialogFactory$CardCalendarDialogStyle r3 = CardCalendarDialogFactory$CardCalendarDialogStyle.BottomSheet;
        L52:
            com.larksuite.component.card.component.b r4 = new com.larksuite.component.card.component.b(this.c.getContext()).controller(new com.larksuite.component.card.component.c(this.c.getContext())).allowContentScroll(false).headerLayoutRes(2131559250).contentLayoutRes(2131559248).footerLayoutRes(2131559249);
            r4.b = r3;
            r4.a = r6;
            r4.c = r0;
            com.larksuite.component.card.component.b r7 = r4.onCancelListener(new b(this.d));
            r7.d = new C0024c(this.c, this.d, this.a, r1);
            ?? r8 = r7.build();
            if (UniversalCardLargeScreenAdapt.b() == false) goto L81;
            Context r9 = this.c.getContext();
            if (r9 == null) goto L81;
            LKEvent r10 = this.c;
            if (com.larksuite.component.card.utils.h.a(r9) == false) goto L81;
            b r11 = new b(r8);
            Object r12 = r10.h;
            if ((r12 instanceof ILynxBridgeContext) == false) goto L61;
            ILynxBridgeContext r13 = (ILynxBridgeContext) r12;
        L62:
            if (r13 == null) goto L68;
            ILynxContainerContext r14 = r13.getContainerContext();
            if (r14 == null) goto L68;
            Map r15 = r14.getBizExtra();
            if (r15 == null) goto L68;
            Object r16 = r15.get("card_service");
        L70:
            if ((r16 instanceof com.larksuite.component.card.service.d) == true) goto L72;
            r16 = null;
        L72:
            com.larksuite.component.card.service.d r17 = (com.larksuite.component.card.service.d) r16;
            if (r17 == null) goto L76;
            r5 = r17.getService(gz7.c.class);
        L76:
            gz7.c r19 = (gz7.c) r5;
            if (r19 == null) goto L79;
            r19.h(r11);
        L79:
            r8.setOnDismissListener(new a(r10, r11));
        L68:
            r16 = null;
            goto L70
        L61:
            r13 = null;
        L81:
            if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L89;
            DialogLancet.handleBlockedDialogShow(r8);
            return;
        L89:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L86
        L84:
            DialogLancet.beforeDialogShow(r8);
            r8.show();
            DialogLancet.afterDialogShow(r8);
            return;
        L46:
            if (com.larksuite.component.card.utils.h.a(r2) == false) goto L48;
            r3 = CardCalendarDialogFactory$CardCalendarDialogStyle.Modal;
        L49:
            if (r3 != null) goto L52;
        L48:
            r3 = CardCalendarDialogFactory$CardCalendarDialogStyle.BottomSheet;
            goto L49
        L51:
            r3 = CardCalendarDialogFactory$CardCalendarDialogStyle.BottomSheet;
            goto L52
        L11:
            if (CardCalendarDialogFactory$CardCalendarType.Time == r0) goto L13;
        L27:
            int r20 = com.larksuite.component.card.utils.i.a;
            String r21 = this.a.getInitialDate();
            String r110 = (String) r1.element;
            Intrinsics.checkNotNullParameter(r110, "pattern");
            r6 = new SimpleDateFormat(r110 + " Z", Locale.US).parse(r21).getTime();     // Catch: Exception -> L30
        L30:
            e = move-exception;
            Log.e("TimeUtil", e.getMessage(), e);
            r6 = new SimpleDateFormat(r110, Locale.US).parse(r21).getTime();     // Catch: Exception -> L34
        L34:
            e = move-exception;
            Log.w("TimeUtil", "parse time exception", e);
        L36:
            r6 = -1;
            goto L39
        L13:
            if (ShowDatePickerPlugin.access$enableTimePickerFix(this.b) == false) goto L27;
            int r22 = com.larksuite.component.card.utils.i.a;
            String r23 = this.a.getInitialDate();
            String r111 = (String) r1.element;
            Intrinsics.checkNotNullParameter(r111, "pattern");
            if (r23 != null) goto L93;
            Date r24 = null;
        L20:
            r6 = com.larksuite.component.card.utils.i.a(r24);     // Catch: Exception -> L17
        L17:
            e = move-exception;
            Log.e("TimeUtil", e.getMessage(), e);
            r6 = com.larksuite.component.card.utils.i.a(new SimpleDateFormat(r111, Locale.US).parse(r23));     // Catch: Exception -> L25
        L25:
            e = move-exception;
            Log.w("TimeUtil", "parse time exception", e);
            goto L36
        L93:
            r24 = new SimpleDateFormat(r111 + " Z", Locale.US).parse(r23);     // Catch: Exception -> L17
            goto L20
        L6:
            if (Intrinsics.areEqual(this.a.getTag(), "picker_datetime") == false) goto L8;
            r0 = CardCalendarDialogFactory$CardCalendarType.DateTime;
            r1.element = "yyyy-MM-dd HH:mm";
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    private final boolean enableTimePickerFix() {
        return !idb.f.a().isCurrentEnable("universal_card.date_picker_fix_disable");
    }

    public ShowDatePickerPlugin() {
    }

    public static final /* synthetic */ boolean access$enableTimePickerFix(ShowDatePickerPlugin r0) {
        return r0.enableTimePickerFix();
    }

    @LKPluginFunction(async = true, eventName = {"msgCardShowDatePicker"})
    public final void showMsgCardDateTimePickerAsync(LKEvent r2, MsgCardDatePickerApiRequest r3, j18.f<CallbackProcessResponse> r4) {
        Intrinsics.checkNotNullParameter(r2, "lkEvent");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "invokeCallback");
        mz7.b.a(new c(r3, this, r2, r4));
    }
}
