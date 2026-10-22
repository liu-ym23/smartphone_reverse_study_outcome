package com.bytedance.android.livesdk.interactivity.comment.share.model;

import am3.g;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0006\fB\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/share/model/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/comment/share/model/a$b;", "shareDataList", "Ljava/util/List;", "a", "()Ljava/util/List;", "setShareDataList", "(Ljava/util/List;)V", "<init>", "()V", "b", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("share_data_list")
    protected List<b> shareDataList;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.share.model.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR$\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/share/model/a$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "itemId", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "setItemId", "(Ljava/lang/String;)V", "Lpy/k;", "icon", "Lpy/k;", "f", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "title", "i", "setTitle", "text", "h", "setText", "buttonText", "a", "setButtonText", "defaultSchema", "d", "setDefaultSchema", BuildConfig.FLAVOR, "closePanelAfterSchemaJump", "Z", "c", "()Z", "setClosePanelAfterSchemaJump", "(Z)V", "isDefault", "k", "setDefault", BuildConfig.FLAVOR, "trackingParams", "Ljava/util/Map;", "j", "()Ljava/util/Map;", "setTrackingParams", "(Ljava/util/Map;)V", "extra", "e", "setExtra", "buttonTrackingEventName", "b", "setButtonTrackingEventName", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0146a implements h {
        public transient String a;
        public transient boolean b;

        @SerializedName("button_text")
        protected String buttonText;

        @SerializedName("button_tracking_event_name")
        protected String buttonTrackingEventName;
        public transient boolean c;

        @SerializedName("close_panel_after_schema_jump")
        protected boolean closePanelAfterSchemaJump;
        public boolean d;

        @SerializedName("default_schema")
        protected String defaultSchema;

        @SerializedName("extra")
        protected String extra;

        @SerializedName("icon")
        protected k icon;

        @SerializedName("is_default")
        protected boolean isDefault;

        @SerializedName("item_id")
        protected String itemId;

        @SerializedName("text")
        protected String text;

        @SerializedName("title")
        protected String title;

        @SerializedName("tracking_params")
        protected Map<String, String> trackingParams;

        public C0146a() {
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
        public C0146a(g r10) {
            this.trackingParams = new HashMap();
            long r0 = r10.c();
        L3:
            int r2 = r10.f();
            if (r2 == (-1)) goto L35;
            switch(r2) {
                case 1: goto L34;
                case 2: goto L33;
                case 3: goto L32;
                case 4: goto L31;
                case 5: goto L30;
                case 6: goto L29;
                case 7: goto L28;
                case 8: goto L27;
                case 9: goto L26;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            this.extra = am3.h.c(r10);
            goto L3
        L8:
            long r4 = r10.c();
            String r3 = null;
            String r6 = null;
        L9:
            int r7 = r10.f();
            if (r7 == (-1)) goto L18;
            if (r7 != 1) goto L14;
            r3 = am3.h.c(r10);
            goto L9
        L14:
            if (r7 != 2) goto L15;
            r6 = am3.h.c(r10);
            goto L9
        L15:
            am3.h.e(r10);
            goto L9
        L18:
            r10.d(r4);
            Map<String, String> r5 = this.trackingParams;
            if (r3 == null) goto L25;
            if (r6 == null) goto L23;
            r5.put(r3, r6);
            goto L3
        L23:
            throw new IllegalStateException("Value must not be null");
        L25:
            throw new IllegalStateException("Key must not be null");
        L26:
            this.isDefault = am3.h.a(r10);
            goto L3
        L27:
            this.closePanelAfterSchemaJump = am3.h.a(r10);
            goto L3
        L28:
            this.buttonTrackingEventName = am3.h.c(r10);
            goto L3
        L29:
            this.defaultSchema = am3.h.c(r10);
            goto L3
        L30:
            this.buttonText = am3.h.c(r10);
            goto L3
        L31:
            this.text = am3.h.c(r10);
            goto L3
        L32:
            this.title = am3.h.c(r10);
            goto L3
        L33:
            this.icon = f.a(r10, k.class);
            goto L3
        L34:
            this.itemId = am3.h.c(r10);
            goto L3
        L6:
            am3.h.e(r10);
            goto L3
        L35:
            r10.d(r0);
        }

        public final String a() {
            return this.buttonText;
        }

        public final String b() {
            return this.buttonTrackingEventName;
        }

        public final boolean c() {
            return this.closePanelAfterSchemaJump;
        }

        public final String d() {
            return this.defaultSchema;
        }

        public final String e() {
            return this.extra;
        }

        public final k f() {
            return this.icon;
        }

        public final String g() {
            return this.itemId;
        }

        public final String h() {
            return this.text;
        }

        public final String i() {
            return this.title;
        }

        public final Map<String, String> j() {
            return this.trackingParams;
        }

        public final boolean k() {
            return this.isDefault;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/share/model/a$b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "itemType", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setItemType", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/comment/share/model/a$a;", "itemList", "Ljava/util/List;", "a", "()Ljava/util/List;", "setItemList", "(Ljava/util/List;)V", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements h {

        @SerializedName("item_list")
        protected List<C0146a> itemList;

        @SerializedName("item_type")
        protected String itemType;

        public b() {
        }

        public b(g r5) {
            this.itemList = new ArrayList();
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            this.itemType = am3.h.c(r5);
            goto L3
        L8:
            if (r2 != 2) goto L9;
            this.itemList.add(new C0146a(r5));
            goto L3
        L9:
            am3.h.e(r5);
            goto L3
        L12:
            r5.d(r0);
        }

        public final List<C0146a> a() {
            return this.itemList;
        }

        public final String b() {
            return this.itemType;
        }
    }

    public a() {
    }

    public a(g r5) {
        this.shareDataList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.shareDataList.add(new b(r5));
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }

    public final List<b> a() {
        return this.shareDataList;
    }
}
