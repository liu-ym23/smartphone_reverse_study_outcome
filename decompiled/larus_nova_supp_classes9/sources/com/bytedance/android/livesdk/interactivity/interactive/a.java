package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.livesdk.chatroom.ui.u9;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001:\u0003\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "switchOn", "Z", "getSwitchOn", "()Z", "setSwitchOn", "(Z)V", "Lcom/bytedance/android/livesdk/interactivity/interactive/a$b;", "basic", "Lcom/bytedance/android/livesdk/interactivity/interactive/a$b;", "getBasic", "()Lcom/bytedance/android/livesdk/interactivity/interactive/a$b;", "setBasic", "(Lcom/bytedance/android/livesdk/interactivity/interactive/a$b;)V", "Lcom/bytedance/android/livesdk/interactivity/interactive/a$a;", "background", "Lcom/bytedance/android/livesdk/interactivity/interactive/a$a;", "getBackground", "()Lcom/bytedance/android/livesdk/interactivity/interactive/a$a;", "setBackground", "(Lcom/bytedance/android/livesdk/interactivity/interactive/a$a;)V", "<init>", "()V", "a", "b", "c", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class a {

    @SerializedName("background")
    private C0163a background;

    @SerializedName("basic")
    private b basic;

    @SerializedName("switch_on")
    private boolean switchOn;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.interactive.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/a$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "titleColor", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setTitleColor", "(Ljava/lang/String;)V", "inputPanelColor", "b", "setInputPanelColor", "inputPanel", "getInputPanel", "setInputPanel", "inputBoxColor", "a", "setInputBoxColor", "textColor", "d", "setTextColor", "inputPanelTopColor", "c", "setInputPanelTopColor", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0163a {

        @SerializedName("input_box_color")
        private String inputBoxColor;

        @SerializedName("input_panel")
        private String inputPanel;

        @SerializedName("input_panel_color")
        private String inputPanelColor;

        @SerializedName("comment_panel")
        private String inputPanelTopColor;

        @SerializedName("comment_panel_text_color")
        private String textColor;

        @SerializedName("title_color")
        private String titleColor;

        public C0163a() {
        }

        public final String a() {
            return this.inputBoxColor;
        }

        public final String b() {
            return this.inputPanelColor;
        }

        public final String c() {
            return this.inputPanelTopColor;
        }

        public final String d() {
            return this.textColor;
        }

        public final String e() {
            return this.titleColor;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/a$b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "titleType", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setTitleType", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/interactivity/interactive/a$c;", "title", "Lcom/bytedance/android/livesdk/interactivity/interactive/a$c;", "b", "()Lcom/bytedance/android/livesdk/interactivity/interactive/a$c;", "setTitle", "(Lcom/bytedance/android/livesdk/interactivity/interactive/a$c;)V", "inputText", "a", "setInputText", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("input_text")
        private String inputText;

        @SerializedName("title")
        private c title;

        @SerializedName("title_type")
        private String titleType;

        public b() {
        }

        public final String a() {
            return this.inputText;
        }

        public final c b() {
            return this.title;
        }

        public final String c() {
            return this.titleType;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/a$c;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "text", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "image", "a", "setImage", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("image")
        private String image;

        @SerializedName("text")
        private String text;

        public c() {
        }

        public final String a() {
            return this.image;
        }

        public final String b() {
            return this.text;
        }
    }

    public a() {
    }

    public final u9 a() {
        b r0 = this.basic;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.c();
    L7:
        if (Intrinsics.areEqual(r2, "image") == false) goto L9;
        int r3 = 2;
    L10:
        b r4 = this.basic;
        if (r4 == null) goto L13;
        String r5 = r4.a();
    L14:
        b r6 = this.basic;
        if (r6 == null) goto L19;
        c r7 = r6.b();
        if (r7 == null) goto L19;
        String r8 = r7.b();
    L20:
        b r9 = this.basic;
        if (r9 == null) goto L25;
        c r10 = r9.b();
        if (r10 == null) goto L25;
        String r11 = r10.a();
    L26:
        C0163a r13 = this.background;
        if (r13 == null) goto L29;
        String r14 = r13.e();
    L30:
        u9.a r15 = new u9.a(r3, r8, r11, r14);
        C0163a r16 = this.background;
        if (r16 == null) goto L33;
        String r17 = r16.b();
    L34:
        C0163a r18 = this.background;
        if (r18 == null) goto L37;
        String r19 = r18.a();
    L38:
        C0163a r20 = this.background;
        if (r20 == null) goto L41;
        String r21 = r20.d();
    L42:
        C0163a r23 = this.background;
        if (r23 == null) goto L46;
        r1 = r23.c();
    L46:
        return new u9(r5, r15, r17, r19, r21, r1);
    L41:
        r21 = null;
        goto L42
    L37:
        r19 = null;
        goto L38
    L33:
        r17 = null;
        goto L34
    L29:
        r14 = null;
    L25:
        r11 = null;
    L19:
        r8 = null;
        goto L20
    L13:
        r5 = null;
        goto L14
    L9:
        r3 = 1;
        goto L10
    L5:
        r2 = null;
        goto L7
    }
}
