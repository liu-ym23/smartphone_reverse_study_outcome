package com.bytedance.android.livesdk.interactivity.imagerecognition;

import android.graphics.Bitmap;
import com.bytedance.android.anniex.utils.j;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q;
import com.bytedance.android.livesdk.interactivity.api.imagerecognition.api.ImageRecognitionRetrofitApi;
import com.bytedance.android.livesdk.interactivity.imagerecognition.util.ImageRecognitionUtil;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.imagerecognition.BoundingBox;
import com.bytedance.android.livesdkapi.depend.model.live.imagerecognition.RecognitionBox;
import com.bytedance.android.livesdkapi.depend.model.live.imagerecognition.StreamRecognitionResponse;
import com.bytedance.android.livesdkapi.imagerecognition.ScaleConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.k;
import org.json.JSONObject;
import y50.l;
import y50.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"onFrameSaved", BuildConfig.FLAVOR, "frame", "Landroid/graphics/Bitmap;", "errorInfo", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
final class ImageRecognitionTask$startRecognition$1 extends Lambda implements Function2<Bitmap, String, Unit> {
    final /* synthetic */ ImageRecognitionTask this$0;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ ImageRecognitionTask$startRecognition$1 a;
        public final /* synthetic */ Bitmap b;
        public final /* synthetic */ Ref.LongRef c;
        public final /* synthetic */ Ref.LongRef d;

        public a(ImageRecognitionTask$startRecognition$1 r1, Bitmap r2, Ref.LongRef r3, Ref.LongRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final Object apply(Object r13) {
            h80.c r14 = (h80.c) r13;
            Intrinsics.checkNotNullParameter(r14, "croppedFrame");
            Object r0 = this.b;
            Object r15 = r14.a;
            if (r15 == null) goto L5;
            r0 = r15;
        L5:
            Bitmap r1 = (Bitmap) r0;
            Ref.LongRef r16 = this.c;
            r16.element = System.currentTimeMillis();
            ImageRecognitionTask r17 = this.a.this$0;
            com.bytedance.android.livesdk.interactivity.imagerecognition.d r2 = r17.h;
            long r3 = this.c.element;
            Ref.LongRef r4 = this.d;
            r2.i = r3 - r4.element;
            r4.element = r3;
            int r5 = ImageRecognitionUtil.a;
            Pair r18 = ImageRecognitionUtil.a(r1, r17.i.c());
            byte[] r6 = (byte[]) r18.component1();
            Bitmap.CompressFormat r19 = (Bitmap.CompressFormat) r18.component2();
            this.a.this$0.h.a = r1;
            Ref.LongRef r7 = this.c;
            r7.element = System.currentTimeMillis();
            com.bytedance.android.livesdk.interactivity.imagerecognition.d r8 = this.a.this$0.h;
            long r9 = this.c.element;
            Ref.LongRef r10 = this.d;
            r8.j = r9 - r10.element;
            r10.element = r9;
            int r11 = r1.getWidth();
            int r20 = r1.getHeight();
            RoomContext r21 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r21 == null) goto L14;
            long r23 = ((Room) r21.getRoom().getValue()).getRoomId();
            long r24 = ((Room) r21.getRoom().getValue()).getStreamId();
            ImageRecognitionTask r25 = this.a.this$0;
            com.bytedance.android.livesdk.interactivity.imagerecognition.d r26 = r25.h;
            long r27 = r25.b;
            r26.n = r27;
            ImageRecognitionRetrofitApi.a r28 = ImageRecognitionRetrofitApi.a;
            int r29 = r25.j;
            r28.getClass();
            Intrinsics.checkNotNullParameter(r6, "imageData");
            Intrinsics.checkNotNullParameter(r19, "format");
            HashMap r30 = new HashMap();
            r30.put("room_id", String.valueOf(r23));
            r30.put("stream_id", String.valueOf(r24));
            r30.put("scene", String.valueOf(r29));
            r30.put("request_id", String.valueOf(r27));
            r30.put(sz1.a.KEY_WIDTH, String.valueOf(r11));
            r30.put(sz1.a.KEY_HEIGHT, String.valueOf(r20));
            if (r19 != Bitmap.CompressFormat.JPEG) goto L11;
            String r110 = "stream.jpg";
            String r31 = "image/jpeg";
        L12:
            k.a r33 = new k.a();
            r33.e(k.f);
            r33.b("image", r110, RequestBody.create(MediaType.parse(r31), r6));
            RequestBody r111 = r33.d();
            return ((ImageRecognitionRetrofitApi) com.bytedance.android.live.network.c.b().e(ImageRecognitionRetrofitApi.class)).recognition(r30, r111);
        L11:
            r110 = "stream.png";
            r31 = "image/png";
            goto L12
        L14:
            return Observable.error(new IllegalStateException("roomContext is null"));
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ ImageRecognitionTask$startRecognition$1 a;
        public final /* synthetic */ Ref.LongRef b;
        public final /* synthetic */ Ref.LongRef c;

        public b(ImageRecognitionTask$startRecognition$1 r1, Ref.LongRef r2, Ref.LongRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r35) {
            Response r1 = (Response) r35;
            Intrinsics.checkNotNullParameter(r1, "it");
            this.b.element = System.currentTimeMillis();
            ImageRecognitionTask r2 = this.a.this$0;
            com.bytedance.android.livesdk.interactivity.imagerecognition.d r3 = r2.h;
            long r4 = this.b.element;
            Ref.LongRef r6 = this.c;
            r3.k = r4 - r6.element;
            r6.element = r4;
            r3.o = ((BaseResponse) r1).logId;
            int r5 = com.bytedance.android.livesdk.interactivity.imagerecognition.util.a.a;
            int r7 = r2.j;
            Intrinsics.checkNotNullParameter(r3, "ctx");
            com.bytedance.android.livesdk.interactivity.imagerecognition.util.a.b(r7, r3);
            ImageRecognitionTask r8 = this.a.this$0;
            com.bytedance.android.livesdk.interactivity.imagerecognition.d r9 = r8.h;
            StreamRecognitionResponse r10 = (StreamRecognitionResponse) ((BaseResponse) r1).data;
            if (r10 == null) goto L5;
            String r11 = r10.containerSchema;
        L6:
            if (r10 == null) goto L8;
            List r13 = r10.results;
        L10:
            if (r10 != null) goto L13;
            r9.getClass();
            Intrinsics.checkNotNullParameter("data is null", "<set-?>");
            r9.d = "data is null";
        L30:
            com.bytedance.android.livesdk.interactivity.imagerecognition.d r14 = r9;
            boolean r15 = false;
        L131:
            if (r15 == false) goto L133;
            int r16 = 0;
        L134:
            r14.c = r16;
            Boolean r0 = Boolean.valueOf(r15);
            r0.booleanValue();
            this.a.this$0.h.l = System.currentTimeMillis() - this.c.element;
            return r0;
        L133:
            r16 = -1;
            goto L134
        L13:
            if (r11 != null) goto L15;
        L18:
            boolean r17 = true;
        L19:
            if (r17 == false) goto L21;
            r9.getClass();
            Intrinsics.checkNotNullParameter("schema is null", "<set-?>");
            r9.d = "schema is null";
            goto L30
        L21:
            List r18 = r13;
            if (r18 != null) goto L24;
        L27:
            boolean r19 = true;
        L28:
            if (r19 == false) goto L31;
            r9.getClass();
            Intrinsics.checkNotNullParameter("result list is empty", "<set-?>");
            r9.d = "result list is empty";
            goto L30
        L31:
            r9.f = r10;
            Intrinsics.checkNotNullParameter("success", "<set-?>");
            r9.d = "success";
            Intrinsics.checkNotNullParameter(r11, "<set-?>");
            r9.g = r11;
            Bitmap r20 = r9.a;
            Intrinsics.checkNotNull(r20);
            long r110 = System.currentTimeMillis();
            r32.b r21 = new r32.b();
            r21.e(r8.k.getDesc());
            r21.k(r8.j);
            int r111 = r20.getWidth();
            int r112 = r20.getHeight();
            if (r112 <= r111) goto L48;
            int r113 = UtilityKotlinExtentionsKt.i(132);
            r21.l(1);
            int r23 = (int) (r111 / 0.75f);
            if (r112 <= r23) goto L49;
            Iterator r114 = r13.iterator();
            int r24 = Integer.MAX_VALUE;
            int r25 = Integer.MIN_VALUE;
        L37:
            if (r114.hasNext() == false) goto L43;
            BoundingBox r115 = ((RecognitionBox) r114.next()).boundingBox;
            if (r115 == null) goto L37;
            r24 = Math.min(r24, r115.y);
            r25 = Math.max(r25, r115.y + r115.height);
            goto L37
        L43:
            if (r24 >= Integer.MAX_VALUE) goto L49;
            if ((r25 - r24) > r23) goto L49;
            int r26 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(((r24 + r25) / 2) - (r23 / 2), 0), r112 - r23);
            int r116 = r113;
            boolean r27 = true;
        L50:
            if (r27 == false) goto L52;
            Bitmap r117 = Bitmap.createBitmap(r20, 0, r26, r111, r23);
        L53:
            r21.d(r27);
            if (r27 == false) goto L56;
            float r28 = 1.3333334f;
        L57:
            r21.j(r28);
            float r29 = r116 / r111;
            Bitmap r30 = Bitmap.createScaledBitmap(r117, r116, (int) (r23 * r29), true);
            int r118 = r8.i.c();
            r21.h(ImageRecognitionUtil.b(r30, r118));
            String r119 = r21.b();
            Intrinsics.checkNotNull(r119);
            int r120 = r119.length();
            int r31 = Math.min(r111, r23);
            int r121 = Math.min(r111, r112);
            ScaleConfig r33 = r8.m.getScaleConfig();
            float r210 = 0.0f;
            if (r33 == null) goto L60;
            float r211 = r33.getResultImageScale();
        L61:
            if (r33 == null) goto L63;
            float r212 = r33.getIdentifyAreaScale();
        L64:
            if (r33 == null) goto L66;
            r210 = r33.getIdentifyAreaScaleThreshold();
        L66:
            boolean r213 = r27;
            int r34 = (int) (r31 * r210);
            if (r33 == null) goto L77;
            Integer r36 = Integer.valueOf(r33.getIdentifyAreaSizeThreshold());
            if (r36.intValue() <= 0) goto L71;
            boolean r214 = true;
        L72:
            if (r214 == true) goto L75;
            r36 = null;
        L75:
            if (r36 == null) goto L77;
            int r37 = (int) (UtilityKotlinExtentionsKt.h(r36.intValue()) / r29);
        L78:
            ArrayList r122 = new ArrayList();
            Iterator<T> r38 = r13.iterator();
            int r123 = 0;
        L80:
            if (r38.hasNext() == false) goto L110;
            Iterator<T> r215 = r38;
            RecognitionBox r39 = (RecognitionBox) r38.next();
            ImageRecognitionTask r124 = r8;
            BoundingBox r40 = r39.boundingBox;
            r32.b r216 = r21;
            String r41 = r39.detail;
            if (r40 == null) goto L105;
            if (r41 == null) goto L105;
            r32.a r125 = new r32.a();
            int r310 = r123;
            r125.b(r39.bindingId);
            r125.f(r39.scene);
            r125.d(r41);
            Integer r43 = Integer.valueOf(Math.max(r40.width, r40.height));
            if (r43.intValue() <= r31) goto L87;
            boolean r44 = true;
        L88:
            if (r44 == false) goto L91;
            r43 = null;
        L91:
            if (r43 == null) goto L93;
            int r45 = r43.intValue();
        L94:
            if (r45 > r34) goto L96;
            int r46 = RangesKt.coerceAtMost((int) (r45 * r212), r31);
        L97:
            int r47 = RangesKt.coerceAtMost(r46, r37);
            BoundingBox r126 = new BoundingBox();
            r126.x = j.b(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r40.x + ((r40.width - r47) / 2), 0), r111 - r47) * r29);
            r126.y = j.b(RangesKt.coerceAtMost(RangesKt.coerceAtLeast((r40.y - r26) + ((r40.height - r47) / 2), 0), r23 - r47) * r29);
            float r48 = r47 * r29;
            r126.width = j.b(r48);
            r126.height = j.b(r48);
            r125.c(r126);
            ImageRecognitionTask.e("map " + r40 + " to " + r126);
            if (r211 <= 0) goto L100;
            r45 = RangesKt.coerceAtMost((int) (r45 * r211), r121);
        L100:
            r125.e(ImageRecognitionUtil.b(Bitmap.createBitmap(r20, RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r40.x + ((r40.width - r45) / 2), 0), r111 - r45), RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r40.y + ((r40.height - r45) / 2), 0), r112 - r45), r45, r45), r118));
            String r49 = r125.a();
            if (r49 == null) goto L103;
            int r50 = r49.length();
        L104:
            r123 = r310 + r50;
        L106:
            ArrayList r51 = r122;
            if (r125 == null) goto L109;
            r51.add(r125);
        L109:
            r122 = r51;
            r8 = r124;
            r38 = r215;
            r21 = r216;
            r37 = r37;
            r31 = r31;
            goto L80
        L103:
            r50 = 0;
            goto L104
        L96:
            r46 = r45;
            goto L97
        L93:
            r45 = Math.min(r40.width, r40.height);
            goto L94
        L87:
            r44 = false;
        L105:
            r123 = r123;
            r125 = null;
            goto L106
        L110:
            ImageRecognitionTask r127 = r8;
            r32.b r53 = r21;
            int r311 = r123;
            r53.i(r122);
            HashMap r54 = new HashMap();
            r54.put("identify_object", String.valueOf(r127.j));
            r54.put("request_page", r127.k.getDesc());
            Unit r55 = Unit.INSTANCE;
            r53.f(r54);
            StreamRecognitionResponse r56 = r127.h.f;
            if (r56 == null) goto L130;
            String r57 = r56.extra;
            if (r57 != null) goto L115;
        L123:
            Map<String, Object> r58 = null;
        L125:
            if (TypeIntrinsics.isMutableMap(r58) == true) goto L127;
            r58 = null;
        L127:
            if (r58 != null) goto L129;
            r58 = new HashMap();
        L129:
            r127.m.onInjectExtra(r127.n, r127.k, r56, r58);
            r53.g(r58);
            goto L130
        L115:
            if (r57.length() <= 0) goto L117;
            boolean r59 = true;
        L118:
            if (r59 == true) goto L121;
            r57 = null;
        L121:
            if (r57 == null) goto L123;
            r58 = q.c(new JSONObject(r57));
            goto L125
        L117:
            r59 = false;
        L130:
            String r60 = JsonUtil.toJSONString(r53);
            ImageRecognitionTask.e("handle result cost=" + (System.currentTimeMillis() - r110) + "ms entry=" + r127.k.getDesc() + " scene=" + r127.j + " type=" + r53.getType() + " ratio=" + r53.c() + " canCrop=" + r213 + " bitmapSize=" + r111 + '*' + r112 + " boxSize=" + r111 + '*' + r23 + " windowBitmapSize=" + UtilityKotlinExtentionsKt.k(r30.getWidth()) + '*' + UtilityKotlinExtentionsKt.k(r30.getHeight()) + " boxTop=" + r26 + " imageDataSize=" + r120 + ", smallImageDataSize=" + r311 + " finalSize=" + r60.length() + " extra=" + r53.a());
            Intrinsics.checkNotNullParameter(r60, "<set-?>");
            r14 = r9;
            r14.b = r60;
            r15 = true;
            goto L131
        L71:
            r214 = false;
        L77:
            r37 = Integer.MAX_VALUE;
            goto L78
        L63:
            r212 = 1.0f;
            goto L64
        L60:
            r211 = 0.0f;
            goto L61
        L56:
            r28 = r23 / r111;
            goto L57
        L52:
            r117 = r20;
        L49:
            r23 = r112;
            r116 = r113;
            r26 = 0;
            r27 = false;
            goto L50
        L48:
            r113 = UtilityKotlinExtentionsKt.i(138);
            r21.l(2);
            goto L49
        L24:
            if (r18.isEmpty() == true) goto L27;
            r19 = false;
            goto L28
        L15:
            if (r11.length() == 0) goto L18;
            r17 = false;
            goto L19
        L8:
            r13 = null;
            goto L10
        L5:
            r11 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ImageRecognitionTask$startRecognition$1 a;

        public c(ImageRecognitionTask$startRecognition$1 r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            if (((Boolean) r6).booleanValue() == false) goto L7;
            final ImageRecognitionTask r7 = this.a.this$0;
            int r0 = ImageRecognitionTask.q;
            if (r7.d() == false) goto L9;
            r7.a = 2;
            r7.h.m = System.currentTimeMillis() - r7.b;
            ImageRecognitionTask.e("onRecognitionSuccess. total=" + r7.h.m + " saveFrameCost=" + r7.h.h + " cropCost=" + r7.h.i + " compressCost=" + r7.h.j + " requestCost=" + r7.h.k + " handleResponseCost=" + r7.h.l + " logId=" + r7.h.o + " requestId=" + r7.h.n);
            r7.c(false, new ImageRecognitionTask$onRecognitionSuccess$1(r7));
            return;
        L9:
            return;
        L7:
            ImageRecognitionTask.a(this.a.this$0, null);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ImageRecognitionTask$startRecognition$1 a;
        public final /* synthetic */ Ref.LongRef b;

        public d(ImageRecognitionTask$startRecognition$1 r1, Ref.LongRef r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            l r0 = o.a(r8);
            com.bytedance.android.livesdk.interactivity.imagerecognition.d r1 = this.a.this$0.h;
            r1.c = r0.a;
            String r2 = r0.c;
            if (r2 != null) goto L5;
            r2 = "unknown error";
        L5:
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            r1.d = r2;
            com.bytedance.android.livesdk.interactivity.imagerecognition.d r3 = this.a.this$0.h;
            r3.o = r0.b;
            if (r3.n > 0) goto L8;
        L10:
            ImageRecognitionTask.a(this.a.this$0, r8);
            return;
        L8:
            if (r3.k != 0) goto L10;
            r3.k = System.currentTimeMillis() - this.b.element;
            int r4 = com.bytedance.android.livesdk.interactivity.imagerecognition.util.a.a;
            ImageRecognitionTask r5 = this.a.this$0;
            int r6 = r5.j;
            com.bytedance.android.livesdk.interactivity.imagerecognition.d r9 = r5.h;
            Intrinsics.checkNotNullParameter(r9, "ctx");
            com.bytedance.android.livesdk.interactivity.imagerecognition.util.a.b(r6, r9);
            goto L10
        }
    }

    public ImageRecognitionTask$startRecognition$1(ImageRecognitionTask r1) {
        this.this$0 = r1;
        super(2);
    }

    public final void invoke(Bitmap r7, String r8) {
        if (this.this$0.d() == true) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        ImageRecognitionTask r2 = this.this$0;
        long r1 = r0 - r2.b;
        r2.h.h = r1;
        Integer r3 = null;
        if (r7 != null) goto L8;
    L29:
        com.bytedance.android.livesdk.interactivity.imagerecognition.d r4 = this.this$0.h;
        r4.getClass();
        Intrinsics.checkNotNullParameter("save frame failed", "<set-?>");
        r4.d = "save frame failed";
        com.bytedance.android.livesdk.interactivity.imagerecognition.d r5 = this.this$0.h;
        r5.c = -1;
        if (r8 != null) goto L32;
        r8 = "unknown_error";
    L32:
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r5.e = r8;
        ImageRecognitionTask.a(this.this$0, null);
        ImageRecognitionTask r9 = this.this$0;
        StringBuilder r6 = new StringBuilder("frameSize=");
        if (r7 == null) goto L35;
        Integer r10 = Integer.valueOf(r7.getWidth());
    L36:
        r6.append(r10);
        r6.append('*');
        if (r7 == null) goto L39;
        Integer r11 = Integer.valueOf(r7.getHeight());
    L40:
        r6.append(r11);
        r6.append(" cost=");
        r6.append(r1);
        String r13 = r6.toString();
        r9.getClass();
        ImageRecognitionTask.f(r13, null);
        return;
    L39:
        r11 = null;
        goto L40
    L35:
        r10 = null;
        goto L36
    L8:
        if (r7.getWidth() <= 0) goto L29;
        if (r7.getHeight() <= 0) goto L29;
        Ref.LongRef r14 = new Ref.LongRef();
        r14.element = System.currentTimeMillis();
        Ref.LongRef r15 = new Ref.LongRef();
        int r16 = ImageRecognitionUtil.a;
        Intrinsics.checkNotNullParameter(r7, "frame");
        as0.a r17 = LivePlatformPlayerManager.b();
        if (r17 == null) goto L15;
        LivePlayerView r18 = r17.getLivePlayerView();
    L16:
        if (r18 == null) goto L19;
        r3 = Integer.valueOf(r18.getScaleType());
    L19:
        if (r7.getHeight() <= r7.getWidth()) goto L26;
        if (r18 == null) goto L26;
        if (r3 == null) goto L26;
        if (r3.intValue() != 2) goto L26;
        Observable r19 = Observable.create(new com.bytedance.android.livesdk.interactivity.imagerecognition.util.b(r18, r7, r3));
    L27:
        RxUtilKt.c(r19.flatMap(new a(this, r7, r15, r14)).map(new b(this, r15, r14)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new d(this, r14)), this.this$0.f);
        return;
    L26:
        r19 = Observable.just(h80.c.b);
        goto L27
    L15:
        r18 = null;
        goto L16
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Bitmap) r1, (String) r2);
        return Unit.INSTANCE;
    }
}
