package r32;

import com.bytedance.android.livesdkapi.depend.model.live.imagerecognition.BoundingBox;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012¨\u0006\u001f"}, d2 = {"Lr32/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "bindingId", "I", "getBindingId", "()I", "b", "(I)V", "scene", "getScene", "f", BuildConfig.FLAVOR, "imageData", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/imagerecognition/BoundingBox;", "boundingBox", "Lcom/bytedance/android/livesdkapi/depend/model/live/imagerecognition/BoundingBox;", "getBoundingBox", "()Lcom/bytedance/android/livesdkapi/depend/model/live/imagerecognition/BoundingBox;", "c", "(Lcom/bytedance/android/livesdkapi/depend/model/live/imagerecognition/BoundingBox;)V", "detail", "getDetail", "d", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("binding_id")
    private int bindingId;

    @SerializedName("bounding_box")
    private BoundingBox boundingBox;

    @SerializedName("detail")
    private String detail;

    @SerializedName("img_data")
    private String imageData;

    @SerializedName("scene")
    private int scene;

    public a() {
    }

    public final String a() {
        return this.imageData;
    }

    public final void b(int r1) {
        this.bindingId = r1;
    }

    public final void c(BoundingBox r1) {
        this.boundingBox = r1;
    }

    public final void d(String r1) {
        this.detail = r1;
    }

    public final void e(String r1) {
        this.imageData = r1;
    }

    public final void f(int r1) {
        this.scene = r1;
    }
}
