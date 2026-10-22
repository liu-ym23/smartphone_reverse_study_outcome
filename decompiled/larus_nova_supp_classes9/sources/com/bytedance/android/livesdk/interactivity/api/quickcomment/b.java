package com.bytedance.android.livesdk.interactivity.api.quickcomment;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "fastChatSwitch", "Z", BuildConfig.FLAVOR, "bubbleColor", "Ljava/lang/String;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/b$a;", "fastChatList", "Ljava/util/List;", "<init>", "()V", "a", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements vh7.h {

    @SerializedName("bubble_color")
    public String bubbleColor;

    @SerializedName("fast_chat_list")
    public List<a> fastChatList;

    @SerializedName("fast_chat_switch")
    public boolean fastChatSwitch;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/b$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "type", "J", BuildConfig.FLAVOR, "content", "Ljava/lang/String;", "<init>", "()V", "a", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    @ForMain
    public static final class a implements vh7.h {

        @SerializedName("content")
        public String content;

        @SerializedName("type")
        public long type;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.api.quickcomment.b$a$a, reason: collision with other inner class name */
        public static final class C0096a {
        }

        static {
        }

        public a() {
        }

        public a(am3.g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            this.type = r5.j();
            goto L3
        L8:
            if (r2 != 2) goto L9;
            this.content = am3.h.c(r5);
            goto L3
        L9:
            am3.h.e(r5);
            goto L3
        L12:
            r5.d(r0);
        }
    }

    public b() {
    }

    public b(am3.g r5) {
        this.fastChatList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.fastChatSwitch = am3.h.a(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.bubbleColor = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.fastChatList.add(new a(r5));
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }
}
