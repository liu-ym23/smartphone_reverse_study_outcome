package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.room.api.record.LiveScreenRecordGuideConfig;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.business.depend.highlight.PublishHighlightVideoData;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.HighlightPreviewDialog;
import com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.SaveVideoHandler$saveVideo$1;
import com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.p;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010Q\u001a\u00020P¢\u0006\u0004\bU\u0010VJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R$\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b7\u00109R!\u0010@\u001a\b\u0012\u0004\u0012\u00020;0:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020D8\u0006¢\u0006\f\n\u0004\b\u0005\u0010E\u001a\u0004\bF\u0010GR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00060A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010CR\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060D8\u0006¢\u0006\f\n\u0004\bI\u0010E\u001a\u0004\bJ\u0010GR\u0017\u0010L\u001a\u00020K8\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0017\u0010Q\u001a\u00020P8\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T¨\u0006W"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/RecordGuideContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/CloseDialogSource;", "source", BuildConfig.FLAVOR, "closeGuideDialog", BuildConfig.FLAVOR, "show", "notifyPublishLoadingShow", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordMetaData;", "metaData", "gotoPublish", "mute", "mutePlayerClient", "isPublishLoading", BuildConfig.BUILD_TYPE, "onDialogCreate", "onDialogClose", "clickClose", "saveDraft", "openPreviewDialog", "saveVideo", "publish", BuildConfig.FLAVOR, "tag", "Ljava/lang/String;", "Lcom/bytedance/android/livesdk/interactivity/comment/highlight/b;", "highlightData", "Lcom/bytedance/android/livesdk/interactivity/comment/highlight/b;", "getHighlightData", "()Lcom/bytedance/android/livesdk/interactivity/comment/highlight/b;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dc", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDc", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/d;", "downloadHandler", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/d;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/m;", "saveDraftHandler", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/m;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/e;", "previewVideoHandler", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/e;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/h;", "publishHandler", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/h;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/p;", "saveVideoHandler", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/p;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "<set-?>", "isReleased", "Z", "()Z", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/c;", "bizHandlers$delegate", "Lkotlin/Lazy;", "getBizHandlers", "()Ljava/util/List;", "bizHandlers", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "_closeGuideDialog", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "getCloseGuideDialog", "()Lcom/bytedance/android/live/core/arch/mvvm/d;", "_publishLoadingShow", "publishLoadingShow", "getPublishLoadingShow", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/n;", "info", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/n;", "getInfo", "()Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/n;", "<init>", "(Landroid/content/Context;Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/n;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecordGuideContext extends DataContext {
    private final PropertyOwner<CloseDialogSource> _closeGuideDialog;
    private final PropertyOwner<Boolean> _publishLoadingShow;
    private final Lazy bizHandlers$delegate;
    private final CompositeDisposable cd;
    private final com.bytedance.android.live.core.arch.mvvm.d<CloseDialogSource> closeGuideDialog;
    private final Context context;
    private final DataCenter dc;
    private final com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.d downloadHandler;
    private final com.bytedance.android.livesdk.interactivity.comment.highlight.b highlightData;
    private final n info;
    private boolean isReleased;
    private final com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.e previewVideoHandler;
    private final com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.h publishHandler;
    private final com.bytedance.android.live.core.arch.mvvm.d<Boolean> publishLoadingShow;
    private final com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.m saveDraftHandler;
    private final p saveVideoHandler;
    private final String tag;

    public static final class a implements IMiddlewareHostBusiness.OnLiveHighlightPublish {
        public final /* synthetic */ RecordGuideContext a;
        public final /* synthetic */ ILiveRecordService.RecordMetaData b;

        public final void onPublish(int r3) {
            if (r3 != 1) goto L6;
            f2.c("发布失败", 0);
        L6:
            String r4 = this.b.getNewFile();
            if (r4 != null) goto L9;
        L14:
            RecordGuideContext.access$mutePlayerClient(this.a, false);
            this.a.release();
            return;
        L9:
            if (r2.a(r4) == true) goto L12;
            r4 = null;
        L12:
            if (r4 == null) goto L14;
            z22.c.b(r4);
            goto L14
        }

        public a(RecordGuideContext r1, ILiveRecordService.RecordMetaData r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RecordGuideContext a;

        public b(RecordGuideContext r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Disposable r3 = (Disposable) r2;
            RecordGuideContext.access$notifyPublishLoadingShow(this.a, true);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RecordGuideContext a;

        public c(RecordGuideContext r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            RecordGuideContext.access$notifyPublishLoadingShow(this.a, false);
            RecordGuideContext.access$closeGuideDialog(this.a, CloseDialogSource.Publish);
            RecordGuideContext r0 = this.a;
            RecordGuideContext.access$gotoPublish(r0, (ILiveRecordService.RecordMetaData) r3);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ RecordGuideContext a;

        public d(RecordGuideContext r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            RecordGuideContext.access$notifyPublishLoadingShow(this.a, false);
            f2.c("发布失败", 0);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ RecordGuideContext a;

        public e(RecordGuideContext r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Disposable r3 = (Disposable) r2;
            RecordGuideContext.access$closeGuideDialog(this.a, CloseDialogSource.SaveDraft);
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L5;
            f2.c("已保存至草稿", 0);
            return;
        L5:
            f2.c("保存失败", 0);
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            f2.c("保存失败", 0);
        }
    }

    public static final class h implements Action {
        public final /* synthetic */ RecordGuideContext a;

        public h(RecordGuideContext r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.release();
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ RecordGuideContext a;

        public i(RecordGuideContext r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Disposable r3 = (Disposable) r2;
            RecordGuideContext.access$closeGuideDialog(this.a, CloseDialogSource.SaveLocal);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ RecordGuideContext a;

        public j(RecordGuideContext r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Uri r5 = (Uri) r4;
            String r0 = r5.getPath();
            if (r0 != null) goto L5;
        L10:
            f2.c("保存失败", 0);
            Unit r6 = Unit.INSTANCE;
            return;
        L5:
            if (r2.a(r0) == true) goto L8;
            r0 = null;
        L8:
            if (r0 == null) goto L10;
            f2.c("下载成功至相册查看", 0);
            this.a.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", r5));
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ RecordGuideContext a;

        public k(RecordGuideContext r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            f2.c("保存失败", 0);
            this.a.release();
        }
    }

    private final List<com.bytedance.android.livesdk.interactivity.comment.record.guide.c> getBizHandlers() {
        return (List) this.bizHandlers$delegate.getValue();
    }

    public final boolean isPublishLoading() {
        return ((Boolean) this._publishLoadingShow.a).booleanValue();
    }

    public final void release() {
        if (this.isReleased == false) goto L5;
        return;
    L5:
        this.isReleased = true;
        Iterator<T> r0 = getBizHandlers().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((com.bytedance.android.livesdk.interactivity.comment.record.guide.c) r0.next()).b();
        goto L7
    L9:
        this.cd.clear();
    }

    public final void clickClose() {
        if (isPublishLoading() == false) goto L6;
        ALogger.i(this.tag, "publish loading, return click close");
        return;
    L6:
        closeGuideDialog(CloseDialogSource.ClickBack);
        release();
    }

    public final void onDialogClose() {
        Iterator<T> r0 = getBizHandlers().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.interactivity.comment.record.guide.c) r0.next()).onDialogDismiss();
        goto L4
    }

    public final void onDialogCreate() {
        Iterator<T> r0 = getBizHandlers().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.interactivity.comment.record.guide.c) r0.next()).a(this);
        goto L4
    }

    public final void openPreviewDialog() {
        if (isPublishLoading() == false) goto L6;
        ALogger.i(this.tag, "publish loading, return openPreviewDialog");
        return;
    L6:
        com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.e r0 = this.previewVideoHandler;
        n r1 = this.info;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "info");
        com.bytedance.android.livesdk.interactivity.comment.highlight.b r2 = r1.c;
        DataCenter r3 = r1.b;
        if (r0.b != null) goto L55;
        String r4 = r2.f();
        if (r4 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == false) goto L18;
        f2.c("预览失败", 0);
        return;
    L18:
        String r6 = BuildConfig.FLAVOR;
        if (r3 == null) goto L26;
        Room r7 = z.o(r3);
        if (r7 == null) goto L26;
        User r8 = r7.getOwner();
        if (r8 == null) goto L26;
        String r9 = r8.getNickName();
        if (r9 == null) goto L26;
    L27:
        if (r3 == null) goto L34;
        IRoom r10 = a0.n(r3);
        if (r10 == null) goto L34;
        IBaseUser r11 = r10.getOwner();
        if (r11 == null) goto L34;
        String r13 = r11.getIdString();
        if (r13 == null) goto L34;
    L35:
        String r14 = "@".concat(r9);
        String r15 = "#" + r2.b();
        String r16 = r2.f();
        if (r16 == null) goto L39;
        r6 = r16;
    L39:
        zf1.h r17 = new zf1.h(r14, r15, r6);
        FragmentActivity r18 = ContextUtil.contextToFragmentActivity(r1.getContext());
        if ((r18 instanceof FragmentActivity) == true) goto L42;
        r18 = null;
    L42:
        if (r18 == null) goto L54;
        int r19 = HighlightPreviewDialog.h;
        com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.e.a r20 = r0.c;
        HighlightPreviewDialog r21 = new HighlightPreviewDialog();
        r21.f = r17;
        r21.g = r20;
        r0.b = r21;
        FragmentManager r23 = r18.getSupportFragmentManager();
        LandscapeRestrictionOperation r24 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r21, "HighlightPreviewDialog", r24);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r23, r21, r24) == false) goto L51;
    L48:
        j0.l().sendLog("livesdk_comment_highlight_content_play", MapsKt.mapOf(new Pair[]{TuplesKt.to("highlights_content_id", String.valueOf(r2.e())), TuplesKt.to("anchor_id", r13), TuplesKt.to("tag_name", r2.b())}), new Object[]{IRoom.class, x.class});
        return;
    L51:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L50
    L47:
        r21.show(r23, "HighlightPreviewDialog");
        goto L48
    L54:
        return;
    L34:
        r13 = BuildConfig.FLAVOR;
    L26:
        r9 = BuildConfig.FLAVOR;
        goto L27
    L12:
        if (r4.length() == 0) goto L15;
        r5 = false;
        goto L16
    }

    public final void publish() {
        if (isPublishLoading() == false) goto L6;
        ALogger.i(this.tag, "publish loading, return publish");
        return;
    L6:
        com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.h r0 = this.publishHandler;
        n r1 = this.info;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "info");
        Observable r2 = Observable.just(r1).flatMap(new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.f(r0, r1)).flatMap(new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.g(r1));
        if (r2 == null) goto L16;
        Observable r3 = RxUtilKt.h(r2);
        if (r3 == null) goto L17;
        Observable r4 = r3.doOnSubscribe(new b(this));
        if (r4 == null) goto L18;
        Disposable r5 = r4.subscribe(new c(this), new d(this));
        if (r5 == null) goto L19;
        RxUtilKt.c(r5, this.cd);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void saveDraft() {
        if (isPublishLoading() == false) goto L6;
        ALogger.i(this.tag, "publish loading, return saveDraft");
        return;
    L6:
        com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.m r0 = this.saveDraftHandler;
        Context r1 = this.context;
        n r2 = this.info;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "info");
        Observable r3 = Observable.just(r2).flatMap(new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.i(r0, r2)).flatMap(new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.j(r2)).flatMap(new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.l(r2, r1));
        if (r3 == null) goto L16;
        Observable r4 = RxUtilKt.h(r3);
        if (r4 == null) goto L17;
        Observable r5 = r4.doOnSubscribe(new e(this));
        if (r5 == null) goto L18;
        Disposable r6 = r5.subscribe(f.a, g.a, new h(this));
        if (r6 == null) goto L19;
        RxUtilKt.c(r6, this.cd);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void saveVideo() {
        if (isPublishLoading() == false) goto L6;
        ALogger.i(this.tag, "publish loading, return saveVideo");
        return;
    L6:
        p r0 = this.saveVideoHandler;
        n r1 = this.info;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "info");
        RxUtilKt.c(RxUtilKt.h(Observable.create(new SaveVideoHandler$saveVideo$1(r0, r1))).doOnSubscribe(new i(this)).subscribe(new j(this), new k(this)), this.cd);
    }

    public final com.bytedance.android.live.core.arch.mvvm.d<CloseDialogSource> getCloseGuideDialog() {
        return this.closeGuideDialog;
    }

    public final Context getContext() {
        return this.context;
    }

    public final DataCenter getDc() {
        return this.dc;
    }

    public final com.bytedance.android.livesdk.interactivity.comment.highlight.b getHighlightData() {
        return this.highlightData;
    }

    public final n getInfo() {
        return this.info;
    }

    public final com.bytedance.android.live.core.arch.mvvm.d<Boolean> getPublishLoadingShow() {
        return this.publishLoadingShow;
    }

    public final boolean isReleased() {
        return this.isReleased;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.d access$getDownloadHandler$p(RecordGuideContext r0) {
        return r0.downloadHandler;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.e access$getPreviewVideoHandler$p(RecordGuideContext r0) {
        return r0.previewVideoHandler;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.h access$getPublishHandler$p(RecordGuideContext r0) {
        return r0.publishHandler;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.m access$getSaveDraftHandler$p(RecordGuideContext r0) {
        return r0.saveDraftHandler;
    }

    public static final /* synthetic */ p access$getSaveVideoHandler$p(RecordGuideContext r0) {
        return r0.saveVideoHandler;
    }

    private final void closeGuideDialog(CloseDialogSource r2) {
        this._closeGuideDialog.a(r2);
    }

    private final void gotoPublish(ILiveRecordService.RecordMetaData r19) {
        Activity r4 = ContextUtil.contextToActivity(this.context);
        if (r4 != null) goto L5;
        return;
    L5:
        String r1 = r19.getNewFile();
        if (r1 != null) goto L8;
        r1 = r19.getOriginFile();
    L8:
        String r3 = r1;
        DataCenter r2 = this.info.b;
        String r5 = null;
        if (r2 == null) goto L11;
        Room r6 = z.o(r2);
    L12:
        if (r6 == null) goto L16;
        User r7 = r6.getOwner();
        if (r7 == null) goto L16;
        String r8 = r7.getNickName();
    L17:
        String r9 = String.valueOf(r8);
        String r10 = this.info.c.b();
        if (r10 != null) goto L20;
    L27:
        r10 = r9.concat("的高光瞬间");
    L28:
        String r13 = r10;
        if (r6 == null) goto L31;
        String r11 = r6.getAnchorId();
    L32:
        String r14 = String.valueOf(r11);
        if (r6 == null) goto L35;
        String r15 = r6.getIdStr();
    L36:
        String r16 = String.valueOf(r15);
        String r17 = String.valueOf(this.info.c.e());
        IMiddlewareUserService r18 = jc1.k.f(IMiddlewareUserService.class);
        if (r18 == null) goto L43;
        com.bytedance.android.livesdk.user.e r20 = r18.user();
        if (r20 == null) goto L43;
        IBaseUser r21 = r20.b();
        if (r21 == null) goto L43;
        r5 = r21.getIdString();
    L43:
        PublishHighlightVideoData r110 = new PublishHighlightVideoData(r3, r4, "active_publish", "live_detail", r14, r9, r17, r16, String.valueOf(r5), r13, BuildConfig.FLAVOR, new a(this, r19));
        r110.setHighlightsContentType("active_publish");
        mutePlayerClient(true);
        IMiddlewareHostBusiness r23 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r23 == null) goto L47;
        r23.openEditAndPublishPage(r110);
        return;
    L47:
        return;
    L35:
        r15 = null;
        goto L36
    L31:
        r11 = null;
        goto L32
    L20:
        if (r10.length() <= 0) goto L22;
        boolean r24 = true;
    L23:
        if (r24 == true) goto L26;
        r10 = null;
    L26:
        if (r10 != null) goto L28;
    L22:
        r24 = false;
    L16:
        r8 = null;
        goto L17
    L11:
        r6 = null;
        goto L12
    }

    private final void mutePlayerClient(boolean r6) {
        if (r6 == false) goto L6;
        IInteractivityInjectService r0 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r0 == null) goto L9;
        r0.muteLivePlayerClient();
    L9:
        LiveScreenRecordGuideConfig.c.getClass();
        if (((Boolean) LiveScreenRecordGuideConfig.b.getValue()).booleanValue() == true) goto L12;
        return;
    L12:
        if (hd0.c.f().h() == true) goto L14;
        return;
    L14:
        if (r6 == false) goto L20;
        IPushStreamService r7 = jc1.k.f(IPushStreamService.class);
        if (r7 == null) goto L28;
        com.bytedance.android.live.pushstream.d r8 = r7.getPushLiveStream();
        if (r8 == null) goto L29;
        r8.J0("live highlight record publish", new uv0.a(LiveRequestSourceRole.Business, "RecordGuideContext.mutePlayerClient", null));
        return;
    L29:
        return;
    L28:
        return;
    L20:
        IPushStreamService r9 = jc1.k.f(IPushStreamService.class);
        if (r9 == null) goto L31;
        com.bytedance.android.live.pushstream.d r10 = r9.getPushLiveStream();
        if (r10 == null) goto L32;
        r10.q1("live highlight record publish", new uv0.a(LiveRequestSourceRole.Business, "RecordGuideContext.mutePlayerClient", null));
        return;
    L32:
        return;
    L31:
        return;
    L6:
        IInteractivityInjectService r1 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r1 == null) goto L9;
        r1.unmuteLivePlayerClient();
        goto L9
    }

    private final void notifyPublishLoadingShow(boolean r2) {
        this._publishLoadingShow.a(Boolean.valueOf(r2));
    }

    public RecordGuideContext(Context r2, n r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "info");
        this.context = r2;
        this.info = r3;
        this.tag = "RecordGuideContext";
        this.highlightData = r3.c;
        this.dc = r3.b;
        com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.d r4 = new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.d();
        this.downloadHandler = r4;
        this.saveDraftHandler = new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.m(r4);
        this.previewVideoHandler = new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.e();
        this.publishHandler = new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.h(r4);
        this.saveVideoHandler = new p(r4);
        this.cd = new CompositeDisposable();
        this.bizHandlers$delegate = LazyKt.lazy(new RecordGuideContext$bizHandlers$2(this));
        PropertyOwner<CloseDialogSource> r5 = new PropertyOwner(CloseDialogSource.Default);
        this._closeGuideDialog = r5;
        this.closeGuideDialog = r5;
        PropertyOwner<Boolean> r6 = new PropertyOwner(Boolean.FALSE);
        this._publishLoadingShow = r6;
        this.publishLoadingShow = r6;
    }

    public static final /* synthetic */ void access$closeGuideDialog(RecordGuideContext r0, CloseDialogSource r1) {
        r0.closeGuideDialog(r1);
    }

    public static final /* synthetic */ void access$gotoPublish(RecordGuideContext r0, ILiveRecordService.RecordMetaData r1) {
        r0.gotoPublish(r1);
    }

    public static final /* synthetic */ void access$mutePlayerClient(RecordGuideContext r0, boolean r1) {
        r0.mutePlayerClient(r1);
    }

    public static final /* synthetic */ void access$notifyPublishLoadingShow(RecordGuideContext r0, boolean r1) {
        r0.notifyPublishLoadingShow(r1);
    }
}
