package com.larksuite.component.card.component.video.service;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.LruCache;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.DownloadFileScene;
import com.bytedance.lark.pb.media.v1.GetFileStateByUrlRequest;
import com.bytedance.lark.pb.media.v1.GetFileStateResponse;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.data.media.VideoInfo;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.widget.photo.preview.utils.DownloadCheckUtil;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.f;
import com.ss.android.lark.widget.photopicker.gallery.callback.OnImageSelectListener;
import com.ss.android.lark.widget.photopicker.gallery.callback.VideoOperateListener;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class CardVideoServiceImpl implements com.larksuite.component.card.component.video.service.c {
    public static WeakReference<CardVideoServiceImpl> c;
    public final CoroutineScope a;
    public final c b;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0006\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/card/component/video/service/CardVideoServiceImpl$CardPreviewFinishedListener;", "Lcom/ss/android/lark/widget/photopicker/gallery/callback/OnImageSelectListener;", "<init>", "()V", "selectPosition", "", "position", "", "previousKey", "", "exitListener", "describeContents", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardPreviewFinishedListener implements OnImageSelectListener {
        public static final Parcelable.Creator<CardPreviewFinishedListener> CREATOR = null;

        public static final class a implements Parcelable.Creator<CardPreviewFinishedListener> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final CardPreviewFinishedListener createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "parcel");
                r2.readInt();
                return new CardPreviewFinishedListener();
            }

            @Override // android.os.Parcelable.Creator
            public final CardPreviewFinishedListener[] newArray(int r1) {
                return new CardPreviewFinishedListener[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public CardPreviewFinishedListener() {
        }

        public final int describeContents() {
            return 0;
        }

        public void selectPosition(int r1, String r2) {
        }

        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dest");
            r1.writeInt(1);
        }

        public void exitListener(String r2) {
            Log.i("CardVideoService", "preview video exited");
            WeakReference<CardVideoServiceImpl> r0 = CardVideoServiceImpl.c;
            CardVideoServiceImpl.c = null;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/card/component/video/service/CardVideoServiceImpl$CardVideoOperateListener;", "Lcom/ss/android/lark/widget/photopicker/gallery/callback/VideoOperateListener;", "sessionID", "", "<init>", "(Ljava/lang/String;)V", "onOperate", "", "context", "Landroid/content/Context;", "videoView", "Lcom/ss/android/lark/widget/photo/preview/video/online/IOnlineVideoGalleryContract$IView;", "actionID", "photoItem", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "isVideo", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardVideoOperateListener implements VideoOperateListener {
        private final String sessionID;

        public CardVideoOperateListener(String r2) {
            Intrinsics.checkNotNullParameter(r2, "sessionID");
            this.sessionID = r2;
        }

        public void onOperate(Context r8, String r9, PhotoItem r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r8, "context");
            Intrinsics.checkNotNullParameter(r9, "actionID");
            onOperate(r8, null, r9, r10, r11);
        }

        public boolean onOperate(Context r2, com.ss.android.lark.widget.photo.preview.video.online.c r3, String r4, PhotoItem r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, "actionID");
            if (Intrinsics.areEqual(r4, "SAVE_VIDEO") == true) goto L6;
            return false;
        L6:
            WeakReference<CardVideoServiceImpl> r7 = CardVideoServiceImpl.c;
            if (r7 != null) goto L9;
        L15:
            Log.e("CardVideoService", a.a(this.sessionID) + " onOperate cannot find serviceRef");
            return true;
        L9:
            if (r7.get() == null) goto L15;
            String r8 = this.sessionID;
            Intrinsics.checkNotNullParameter(r8, "sessionID");
            Intrinsics.checkNotNullParameter(r2, "context");
            if (r5 != null) goto L13;
            Log.e("CardVideoService", a.a(r8) + " downloadVideoWithCheck photoItem is null");
            return true;
        L13:
            int r9 = DownloadCheckUtil.a;
            f.a().o();
            throw null;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larksuite/component/card/component/video/service/CardVideoServiceImpl$FileState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UNKNOWN", "NORMAL", "DELETED", "RECOVERABLE", "UNRECOVERABLE", "FREED_UP", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum FileState extends Enum<FileState> {
        public static final FileState DELETED = null;
        public static final FileState FREED_UP = null;
        public static final FileState NORMAL = null;
        public static final FileState RECOVERABLE = null;
        public static final FileState UNKNOWN = null;
        public static final FileState UNRECOVERABLE = null;
        public static final /* synthetic */ FileState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<FileState> getEntries() {
            return b;
        }

        static {
            FileState r0 = new FileState("UNKNOWN", 0);
            UNKNOWN = r0;
            FileState r1 = new FileState("NORMAL", 1);
            NORMAL = r1;
            FileState r3 = new FileState("DELETED", 2);
            DELETED = r3;
            FileState r5 = new FileState("RECOVERABLE", 3);
            RECOVERABLE = r5;
            FileState r7 = new FileState("UNRECOVERABLE", 4);
            UNRECOVERABLE = r7;
            FileState r9 = new FileState("FREED_UP", 5);
            FREED_UP = r9;
            FileState[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static FileState[] values() {
            return (FileState[]) a.clone();
        }

        public static FileState valueOf(String r1) {
            return (FileState) r27.a.a(FileState.class, r1);
        }

        public FileState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }

        public static final String a(String r2) {
            WeakReference<CardVideoServiceImpl> r0 = CardVideoServiceImpl.c;
            return "[CardVideoService-" + r2 + ']';
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GetFileStateResponse.State.values().length];
            r0[GetFileStateResponse.State.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[GetFileStateResponse.State.DELETED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[GetFileStateResponse.State.RECOVERABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[GetFileStateResponse.State.UNRECOVERABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[GetFileStateResponse.State.FREED_UP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class c extends LruCache<String, FileState> {
        @Override // android.util.LruCache
        public final FileState create(String r1) {
            return null;
        }

        @Override // android.util.LruCache
        public final void entryRemoved(boolean r1, String r2, FileState r3, FileState r4) {
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r1, FileState r2) {
            return 1;
        }

        public c() {
            super(100);
        }
    }

    static {
        new a();
    }

    @Override // com.larksuite.component.card.service.c
    public final void destroy() {
        CoroutineScopeKt.cancel$default(this.a, "CardVideoServiceImpl destroy", null, 2, null);
        this.b.evictAll();
        c = null;
    }

    public CardVideoServiceImpl(com.larksuite.component.card.service.b r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceContext");
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.b = new c();
    }

    public static final Object m(CardVideoServiceImpl r7, final String r8, VideoInfo r9, Continuation r10) {
        r7.getClass();
        if ((r10 instanceof CardVideoServiceImpl$checkFileStateSuspend$1) == false) goto L7;
        CardVideoServiceImpl$checkFileStateSuspend$1 r0 = (CardVideoServiceImpl$checkFileStateSuspend$1) r10;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r12 = (String) r0.L$1;
        r8 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L24:
        int r13 = b.a[((GetFileStateResponse.State) r11).ordinal()];
        if (r13 != 1) goto L27;
        FileState r14 = FileState.NORMAL;
    L41:
        FileState r4 = r14;
        Log.i("CardVideoService", a.a(r8) + " checkFileStateSuspend fileState: " + r4);
        r7.b.put(r8, r4);
        return r4;
    L27:
        if (r13 != 2) goto L29;
        r14 = FileState.DELETED;
        goto L41
    L29:
        if (r13 != 3) goto L31;
        r14 = FileState.RECOVERABLE;
        goto L41
    L31:
        if (r13 != 4) goto L33;
        r14 = FileState.UNRECOVERABLE;
        goto L41
    L33:
        if (r13 != 5) goto L36;
        r14 = FileState.FREED_UP;
        goto L41
    L36:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        FileState r15 = r7.b.get(r8);
        if (r15 == null) goto L17;
        Log.i("CardVideoService", a.a(r8) + " checkFileStateSuspend from cache");
        return r15;
    L17:
        String r16 = r9.getUrl();
        if (r16 == null) goto L44;
        r0.L$0 = r8;
        r0.L$1 = r16;
        r0.label = 1;
        final j r17 = new j(IntrinsicsKt.intercepted(r0), 1);
        r17.C();
        SdkSender.asynSendRequestNonWrap(Command.GET_FILE_STATE_BY_URL, new GetFileStateByUrlRequest.Builder().url(r16).scene(DownloadFileScene.UniversalCard), new CardVideoServiceImpl$checkFileStateSuspend$sdkFileState$1$1(r8, r17), new com.larksuite.component.card.component.video.service.b(r8));
        r11 = r17.B();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L22:
        if (r11 != r2) goto L24;
        return r2;
    L44:
        throw new IllegalStateException("videoInfo.url is null");
    L7:
        r0 = new CardVideoServiceImpl$checkFileStateSuspend$1(r7, r10);
        goto L8
    }

    @Override // com.larksuite.component.card.component.video.service.c
    public final void d(CardContext r12, VideoInfo r13, RichTextElement.ImageProperty r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "cardContext");
        Intrinsics.checkNotNullParameter(r13, "videoInfo");
        BuildersKt.launch$default(this.a, null, null, new CardVideoServiceImpl$previewVideo$1(r13, this, r14, r12, r15, null), 3, null);
    }
}
