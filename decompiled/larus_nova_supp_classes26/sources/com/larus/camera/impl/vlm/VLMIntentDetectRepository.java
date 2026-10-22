package com.larus.camera.impl.vlm;

import android.graphics.Bitmap;
import android.util.Base64;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.camera.api.vlm.VLMIntent;
import com.larus.camera.api.vlm.VLMSceneType;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import java.io.ByteArrayOutputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class VLMIntentDetectRepository {
    public static final VLMIntentDetectRepository a = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bb\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMIntentApi;", "", "requestVLMIntent", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMIntentResponse;", "request", "Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMIntentRequest;", "(Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMIntentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface VLMIntentApi {
        public static final a a = null;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            a = a.a;
        }

        @POST("/biz/vlm/intent")
        Object requestVLMIntent(@Body f r1, Continuation<? super BizResponse<g>> r2);
    }

    public static final class a {
        public final e a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
        }

        public final String toString() {
            return "BuildHttpFileResult(fileData=" + this.a + ", width=" + this.b + ", height=" + this.c + ", originImageSize=" + this.d + ", compressedImageSize=" + this.e + ')';
        }

        public a(e r2, int r3, int r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "fileData");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class b {
        public final f a;
        public final int b;
        public final int c;
        public final ix8.g d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "BuildHttpRequestResult(request=" + this.a + ", firstImageWidth=" + this.b + ", firstImageHeight=" + this.c + ", preProcessInfo=" + this.d + ')';
        }

        public b(f r2, int r3, int r4, ix8.g r5) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r5, "preProcessInfo");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class c {
        public final String a;
        public final int b;

        public c() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "CompressResult(base64Data=" + this.a + ", compressedImageSize=" + this.b + ')';
        }

        public /* synthetic */ c(int r2) {
            this("", 0);
        }

        public c(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "base64Data");
            this.a = r2;
            this.b = r3;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$EduFileData;", "", "needIntent", "", "needDewarp", "eduSceneType", "", "needDetection", "<init>", "(ZZLjava/lang/Long;Z)V", "getNeedIntent", "()Z", "getNeedDewarp", "getEduSceneType", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNeedDetection", "component1", "component2", "component3", "component4", "copy", "(ZZLjava/lang/Long;Z)Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$EduFileData;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d {

        @SerializedName("edu_scene_type")
        private final Long eduSceneType;

        @SerializedName("need_detection")
        private final boolean needDetection;

        @SerializedName("need_dewarp")
        private final boolean needDewarp;

        @SerializedName("need_intent")
        private final boolean needIntent;

        public d() {
            this(true, false, null, false);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (this.needIntent == r6.needIntent) goto L12;
            return false;
        L12:
            if (this.needDewarp == r6.needDewarp) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.eduSceneType, r6.eduSceneType) == true) goto L18;
            return false;
        L18:
            if (this.needDetection == r6.needDetection) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.needIntent == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.needDewarp == false) goto L9;
            int r3 = 1231;
        L10:
            int r4 = (r2 + r3) * 31;
            Long r5 = this.eduSceneType;
            if (r5 != null) goto L13;
            int r6 = 0;
        L14:
            int r7 = (r4 + r6) * 31;
            if (this.needDetection == true) goto L19;
            r1 = 1237;
        L19:
            return r7 + r1;
        L13:
            r6 = r5.hashCode();
            goto L14
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "EduFileData(needIntent=" + this.needIntent + ", needDewarp=" + this.needDewarp + ", eduSceneType=" + this.eduSceneType + ", needDetection=" + this.needDetection + ')';
        }

        public d(boolean r1, boolean r2, Long r3, boolean r4) {
            this.needIntent = r1;
            this.needDewarp = r2;
            this.eduSceneType = r3;
            this.needDetection = r4;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMFileData;", "", "fileData", "", "type", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getFileData", "()Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMFileData;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e {

        @SerializedName("file_data")
        private final String fileData;

        @SerializedName("type")
        private final Integer type;

        public e() {
            this(null, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (Intrinsics.areEqual(this.fileData, r6.fileData) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r6.type) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.fileData;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.type;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "VLMFileData(fileData=" + this.fileData + ", type=" + this.type + ')';
        }

        public final Integer getType() {
            return this.type;
        }

        public e(String r1, Integer r2) {
            this.fileData = r1;
            this.type = r2;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMIntentRequest;", "", "files", "", "Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMFileData;", "sceneType", "", "eduFileData", "Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$EduFileData;", "<init>", "(Ljava/util/List;ILcom/larus/camera/impl/vlm/VLMIntentDetectRepository$EduFileData;)V", "getFiles", "()Ljava/util/List;", "getSceneType", "()I", "getEduFileData", "()Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$EduFileData;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f {

        @SerializedName("edu_file_data")
        private final d eduFileData;

        @SerializedName("files")
        private final List<e> files;

        @SerializedName("scene_type")
        private final int sceneType;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof f) == true) goto L8;
            return false;
        L8:
            f r6 = (f) r5;
            if (Intrinsics.areEqual(this.files, r6.files) == true) goto L12;
            return false;
        L12:
            if (this.sceneType == r6.sceneType) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.eduFileData, r6.eduFileData) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            List<e> r0 = this.files;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.sceneType) * 31;
            d r4 = this.eduFileData;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "VLMIntentRequest(files=" + this.files + ", sceneType=" + this.sceneType + ", eduFileData=" + this.eduFileData + ')';
        }

        public f() {
            this(null, VLMSceneType.TAKE_PICTURE.getValue(), null);
        }

        public f(List<e> r1, int r2, d r3) {
            this.files = r1;
            this.sceneType = r2;
            this.eduFileData = r3;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006!"}, d2 = {"Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMIntentResponse;", "", "vlmIntent", "", "enableChoice", "Lcom/larus/camera/api/vlm/VLMIntentEnableChoice;", "requestId", "", "eduIntentData", "eduExtraParam", "<init>", "(Ljava/lang/Integer;Lcom/larus/camera/api/vlm/VLMIntentEnableChoice;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVlmIntent", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnableChoice", "()Lcom/larus/camera/api/vlm/VLMIntentEnableChoice;", "getRequestId", "()Ljava/lang/String;", "getEduIntentData", "getEduExtraParam", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Lcom/larus/camera/api/vlm/VLMIntentEnableChoice;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/camera/impl/vlm/VLMIntentDetectRepository$VLMIntentResponse;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g {

        @SerializedName("edu_extra_param")
        private final String eduExtraParam;

        @SerializedName("edu_data")
        private final String eduIntentData;

        @SerializedName("enable_choice")
        private final ix8.f enableChoice;

        @SerializedName("request_id")
        private final String requestId;

        @SerializedName("vlm_intent")
        private final Integer vlmIntent;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof g) == true) goto L8;
            return false;
        L8:
            g r6 = (g) r5;
            if (Intrinsics.areEqual(this.vlmIntent, r6.vlmIntent) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.enableChoice, r6.enableChoice) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.requestId, r6.requestId) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.eduIntentData, r6.eduIntentData) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.eduExtraParam, r6.eduExtraParam) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            Integer r0 = this.vlmIntent;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            ix8.f r4 = this.enableChoice;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.requestId;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.eduIntentData;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.eduExtraParam;
            if (r13 == null) goto L23;
            r1 = r13.hashCode();
        L23:
            return r12 + r1;
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "VLMIntentResponse(vlmIntent=" + this.vlmIntent + ", enableChoice=" + this.enableChoice + ", requestId=" + this.requestId + ", eduIntentData=" + this.eduIntentData + ", eduExtraParam=" + this.eduExtraParam + ')';
        }

        public g() {
            this.vlmIntent = Integer.valueOf(VLMIntent.COMMON.getValue());
            this.enableChoice = null;
            this.requestId = null;
            this.eduIntentData = null;
            this.eduExtraParam = null;
        }

        public final String a() {
            return this.eduExtraParam;
        }

        public final String b() {
            return this.eduIntentData;
        }

        public final ix8.f c() {
            return this.enableChoice;
        }

        public final String d() {
            return this.requestId;
        }

        public final Integer e() {
            return this.vlmIntent;
        }
    }

    public /* synthetic */ class h {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[VLMIntent.values().length];
            r0[VLMIntent.COMMON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[VLMIntent.EDU.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = new VLMIntentDetectRepository();
    }

    public VLMIntentDetectRepository() {
    }

    public static c a(Bitmap r2, int r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L12
        r2.compress(Bitmap.CompressFormat.JPEG, r3, r1);     // Catch: Throwable -> L7
        byte[] r4 = r1.toByteArray();     // Catch: Throwable -> L7
        c r5 = new c(Base64.encodeToString(r4, 2), r4.length);     // Catch: Throwable -> L7
    L5:
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L12
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L12
    L14:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L19;
        FLogger.a.e("VLMIntentDetectRepository", "[bitmapToBase64] error, " + r7);
        r6 = new c(0);
    L19:
        return (c) r6;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final Object b(ix8.c r13, Continuation<? super ix8.d> r14) {
        if ((r14 instanceof VLMIntentDetectRepository$requestDetect$1) == false) goto L7;
        VLMIntentDetectRepository$requestDetect$1 r0 = (VLMIntentDetectRepository$requestDetect$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r15);
    L38:
        return r15;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.larus.camera.impl.vlm.a r16 = (com.larus.camera.impl.vlm.a) r0.L$1;
        ix8.c r4 = (ix8.c) r0.L$0;
        ResultKt.throwOnFailure(r15);
        com.larus.camera.impl.vlm.a r6 = r16;
    L31:
        ix8.d r17 = (ix8.d) r15;
        if (r17 != null) goto L39;
        FLogger.a.e("VLMIntentDetectRepository", "[VLMIntentRequest] failed, timeout");
        r6.a("-1", -1, "", 0, "");
        return new ix8.d.a(ix8.e.a.a);
    L39:
        return r17;
    L16:
        ResultKt.throwOnFailure(r15);
        Long r18 = r13.c.a;
        if (r18 != null) goto L19;
    L24:
        r18 = null;
    L25:
        com.larus.camera.impl.vlm.a r5 = new com.larus.camera.impl.vlm.a(r13.e, r13.c);
        if (r18 == null) goto L35;
        r18.longValue();
        long r7 = r18.longValue();
        VLMIntentDetectRepository$requestDetect$2$1 r19 = new VLMIntentDetectRepository$requestDetect$2$1(r13, r5, null);
        r0.L$0 = r13;
        r0.L$1 = r5;
        r0.label = 1;
        r15 = TimeoutKt.c(r7, r19, r0);
        if (r15 != r2) goto L30;
        return r2;
    L30:
        r6 = r5;
        goto L31
    L35:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        r15 = c(r13, r5, r0);
        if (r15 != r2) goto L38;
        return r2;
    L19:
        if (r18.longValue() <= 0) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L24;
    L21:
        r8 = false;
    L7:
        r0 = new VLMIntentDetectRepository$requestDetect$1(this, r14);
        goto L8
    }

    public final Object c(ix8.c r26, com.larus.camera.impl.vlm.a r27, Continuation<? super ix8.d> r28) {
        if ((r28 instanceof VLMIntentDetectRepository$requestDetectInternal$1) == false) goto L7;
        VLMIntentDetectRepository$requestDetectInternal$1 r1 = (VLMIntentDetectRepository$requestDetectInternal$1) r28;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        VLMIntentDetectRepository$requestDetectInternal$1 r10 = r1;
        Object r0 = r10.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r10.label;
        Integer r13 = null;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        b r5 = (b) r10.L$1;
        com.larus.camera.impl.vlm.a r6 = (com.larus.camera.impl.vlm.a) r10.L$0;
        ResultKt.throwOnFailure(r0);
    L24:
        dm9.a.a r7 = (dm9.a) r0;
        if ((r7 instanceof dm9.a.a) == false) goto L32;
        FLogger.a.e("VLMIntentDetectRepository", "[VLMIntentRequest] failed, " + r7);
        dm9.a.a r8 = r7;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r8, "error");
        if (r8.c == null) goto L29;
        String r9 = "network";
    L30:
        r6.a(TriggerSendLoading.NO_LOADING, -1, r9, r8.a, r8.b);
        return new ix8.d.a(new ix8.e.b(r8.b), r5.d);
    L29:
        r9 = "business";
        goto L30
    L32:
        if ((r7 instanceof dm9.a.b) == false) goto L55;
        g r11 = (g) ((dm9.a.b) r7).a.getData();
        if (r11 == null) goto L36;
        r13 = r11.e();
    L36:
        if (r13 != null) goto L39;
        r6.getClass();
        Intrinsics.checkNotNullParameter("empty or invalid response", "errorMsg");
        r6.a(TriggerSendLoading.NO_LOADING, -1, "decode", 0, "empty or invalid response");
        ix8.d.a r12 = new ix8.d.a(new ix8.e.b("empty or invalid response"), r5.d);
    L56:
        return r12;
    L39:
        VLMIntent.a r14 = VLMIntent.Companion;
        int r15 = r13.intValue();
        r14.getClass();
        VLMIntent r16 = VLMIntent.EDU;
        if (r15 != r16.getValue()) goto L42;
        VLMIntent r17 = r16;
    L43:
        if (r17 != r16) goto L45;
        int r18 = 1;
    L46:
        r6.a("1", r18, "", 0, "");
        int r19 = h.a[r17.ordinal()];
        if (r19 == 1) goto L52;
        if (r19 != 2) goto L51;
        return new ix8.d.b(ix8.e.d.a, r5.b, r5.c, r11.b(), r11.c(), r11.d(), r11.a(), r5.d);
    L51:
        throw new NoWhenBranchMatchedException();
    L52:
        r12 = new ix8.d.a(ix8.e.d.a, r5.d);
        goto L56
    L45:
        r18 = 0;
        goto L46
    L42:
        r17 = VLMIntent.COMMON;
        goto L43
    L55:
        throw new NoWhenBranchMatchedException();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.larus.camera.impl.vlm.a r20 = (com.larus.camera.impl.vlm.a) r10.L$0;
        ResultKt.throwOnFailure(r0);
        Object r21 = r0;
        com.larus.camera.impl.vlm.a r22 = r20;
    L20:
        b r110 = (b) r21;
        ix8.g r23 = r110.d;
        r22.getClass();
        Intrinsics.checkNotNullParameter(r23, "preProcessInfo");
        r22.e = System.currentTimeMillis();
        r22.f = r23;
        VLMIntentApi.a r24 = VLMIntentApi.a;
        VLMIntentDetectRepository$requestDetectInternal$2 r25 = new VLMIntentDetectRepository$requestDetectInternal$2(r110, null);
        r10.L$0 = r22;
        r10.L$1 = r110;
        r10.label = 2;
        r24.getClass();
        FlowHttpConnection r29 = FlowHttpConnection.a;
        Object r30 = FlowHttpConnection.g("Basic", VLMIntentApi.class, r25, true, null, null, null, r10, 240);
        if (r30 != r3) goto L23;
        return r3;
    L23:
        r5 = r110;
        r6 = r22;
        r0 = r30;
        goto L24
    L16:
        ResultKt.throwOnFailure(r0);
        CoroutineDispatcher r31 = Dispatchers.getDefault();
        VLMIntentDetectRepository$requestDetectInternal$httpRequest$1 r32 = new VLMIntentDetectRepository$requestDetectInternal$httpRequest$1(r26, null);
        r10.L$0 = r27;
        r10.label = 1;
        Object r33 = BuildersKt.withContext(r31, r32, r10);
        if (r33 != r3) goto L19;
        return r3;
    L19:
        r21 = r33;
        r22 = r27;
    L7:
        r1 = new VLMIntentDetectRepository$requestDetectInternal$1(this, r28);
        goto L8
    }
}
