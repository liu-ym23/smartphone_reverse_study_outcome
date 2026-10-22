package f71;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdk.message.model.i3;
import com.bytedance.android.livesdk.message.model.k1;
import com.bytedance.android.livesdk.message.model.m1;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lf71/c;", "", "Lf71/c$a;", Constants.Keys.DATA, "Lf71/c$a;", "<init>", "()V", "a", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName(Constants.Keys.DATA)
    public a data;

    @ForMain
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0005¨\u0006\f"}, d2 = {"Lf71/c$a;", "", "", "Lcom/bytedance/android/livesdk/message/model/m1;", "bottomRightCardArea", "Ljava/util/List;", "Lcom/bytedance/android/livesdk/message/model/k1;", "binPinArea", "Lcom/bytedance/android/livesdk/message/model/i3;", "commonCardArea", "<init>", "()V", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements h {

        @SerializedName("biz_pin_area")
        public List<k1> binPinArea;

        @SerializedName("bottom_right_card_area")
        public List<m1> bottomRightCardArea;

        @SerializedName("common_card_area")
        public List<i3> commonCardArea;

        public a() {
        }

        public a(g r5) {
            this.bottomRightCardArea = new ArrayList();
            this.binPinArea = new ArrayList();
            this.commonCardArea = new ArrayList();
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L16;
            if (r2 == 1) goto L14;
            if (r2 == 2) goto L13;
            if (r2 != 3) goto L11;
            List<i3> r3 = this.commonCardArea;
            i3 r4 = new i3(r5);
        L15:
            r3.add(r4);
            goto L3
        L11:
            am3.h.e(r5);
            goto L3
        L13:
            r3 = this.binPinArea;
            r4 = new k1(r5);
            goto L15
        L14:
            r3 = this.bottomRightCardArea;
            r4 = new m1(r5);
            goto L15
        L16:
            r5.d(r0);
        }
    }

    public c() {
    }

    public c(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.data = new a(r5);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }
}
