package com.obric.widget.host;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000fH&J,\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u001c\u001a\u00020\u0012H&J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u001fH\u0017J\b\u0010\"\u001a\u00020\u0012H&J\b\u0010#\u001a\u00020\u0012H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006$"}, d2 = {"Lcom/obric/widget/host/WidgetHost;", "", "hostId", "", "getHostId", "()Ljava/lang/String;", "createWidget", "Lcom/obric/widget/host/HostedWidget;", "definition", "Lcom/obric/widget/host/WidgetDefinition;", "options", "Lcom/obric/widget/host/CreateOptions;", "(Lcom/obric/widget/host/WidgetDefinition;Lcom/obric/widget/host/CreateOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreWidget", "isEnabled", "", "hasWidgets", "onForeground", "", "onBackground", "onThemeChanged", "isNightMode", "onSystemChanged", "type", "action", "timeMillis", "", "timeZone", "syncVisibility", "destroyByHostInstanceId", "hostInstanceId", "", "destroyByAppWidgetId", "appWidgetId", "clearWidgets", "destroy", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface WidgetHost {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nWidgetHost.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetHost.kt\ncom/obric/widget/host/WidgetHost$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,44:1\n1#2:45\n*E\n"})
    public static final class DefaultImpls {
        public static /* synthetic */ Object createWidget$default(WidgetHost r10, WidgetDefinition r11, CreateOptions r12, Continuation r13, int r14, Object r15) {
            if (r15 != null) goto L9;
            if ((r14 & 2) == 0) goto L7;
            r12 = new CreateOptions(null, null, null, 7, null);
        L7:
            return r10.createWidget(r11, r12, r13);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createWidget");
        }

        public static void destroy(WidgetHost r5) {
            r5.clearWidgets();
        }

        @Deprecated(message = "Launcher compatibility API. Non-Launcher hosts should call HostedWidget.destroy() or destroyByHostInstanceId() with their own stable instance id.", replaceWith = @ReplaceWith(expression = "destroyByHostInstanceId(appWidgetId)", imports = {}))
        public static void destroyByAppWidgetId(WidgetHost r5, int r10) {
            r5.destroyByHostInstanceId(r10);
        }

        public static Object restoreWidget(WidgetHost r5, WidgetDefinition r10, CreateOptions r11, Continuation<? super HostedWidget> r12) {
            if ((r12 instanceof AnonymousClass1) == false) goto L7;
            AnonymousClass1 r13 = (AnonymousClass1) r12;
            int r14 = r13.label;
            if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
            r13.label = r14 - Integer.MIN_VALUE;
        L8:
            Object r15 = r13.result;
            Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r17 = r13.label;
            if (r17 == 0) goto L16;
            if (r17 == 1) goto L15;
            if (r17 != 2) goto L14;
            Object r18 = r13.L$0;
            ResultKt.throwOnFailure(r15);
            return r18;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r15);
        L19:
            r13.L$0 = r15;
            r13.label = 2;
            if (((HostedWidget) r15).restore(r13) != r16) goto L23;
            return r16;
        L23:
            return r15;
        L16:
            ResultKt.throwOnFailure(r15);
            r13.label = 1;
            r15 = r5.createWidget(r10, r11, r13);
            if (r15 != r16) goto L19;
            return r16;
        L7:
            r13 = new AnonymousClass1(r12);
            goto L8
        }

        public static /* synthetic */ Object restoreWidget$default(WidgetHost r10, WidgetDefinition r11, CreateOptions r12, Continuation r13, int r14, Object r15) {
            if (r15 != null) goto L9;
            if ((r14 & 2) == 0) goto L7;
            r12 = new CreateOptions(null, null, null, 7, null);
        L7:
            return r10.restoreWidget(r11, r12, r13);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: restoreWidget");
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.WidgetHost$restoreWidget$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.WidgetHost$DefaultImpls", f = "WidgetHost.kt", i = {}, l = {18, 18}, m = "restoreWidget", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r5) {
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return DefaultImpls.restoreWidget(null, null, null, this);
        }
    }

    void clearWidgets();

    Object createWidget(WidgetDefinition r5, CreateOptions r10, Continuation<? super HostedWidget> r11);

    void destroy();

    @Deprecated(message = "Launcher compatibility API. Non-Launcher hosts should call HostedWidget.destroy() or destroyByHostInstanceId() with their own stable instance id.", replaceWith = @ReplaceWith(expression = "destroyByHostInstanceId(appWidgetId)", imports = {}))
    void destroyByAppWidgetId(int r5);

    void destroyByHostInstanceId(int r5);

    String getHostId();

    boolean hasWidgets();

    boolean isEnabled();

    void onBackground();

    void onForeground();

    void onSystemChanged(String r5, String r10, long r11, String r12);

    void onThemeChanged(boolean r5);

    Object restoreWidget(WidgetDefinition r5, CreateOptions r10, Continuation<? super HostedWidget> r11);

    void syncVisibility();
}
