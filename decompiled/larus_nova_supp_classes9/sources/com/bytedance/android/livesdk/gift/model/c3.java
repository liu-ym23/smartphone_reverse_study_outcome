package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR2\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR$\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R(\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010\b\"\u0004\b%\u0010\nR\"\u0010&\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0017\u001a\u0004\b'\u0010\u0019\"\u0004\b(\u0010\u001b¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/c3;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/revenue/platform/api/core/KmpList;", "sectionBgStartColor", "Ljava/util/List;", "f", "()Ljava/util/List;", "n", "(Ljava/util/List;)V", "sectionBgEndColor", "e", "m", "Lpy/k;", "sectionHeaderImg", "Lpy/k;", "g", "()Lpy/k;", "o", "(Lpy/k;)V", BuildConfig.FLAVOR, "entranceText", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "entranceSchema", "b", "j", "entranceIconImg", "a", "i", "Lcom/bytedance/android/livesdk/gift/model/h1;", "gifts", "d", "l", "sectionName", "h", "p", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c3 implements vh7.h {

    @SerializedName("entrance_icon_img")
    protected py.k entranceIconImg;

    @SerializedName("entrance_schema")
    protected String entranceSchema;

    @SerializedName("entrance_text")
    protected String entranceText;

    @SerializedName("gifts")
    protected List<? extends h1> gifts;

    @SerializedName("section_bg_end_color")
    protected List<Integer> sectionBgEndColor;

    @SerializedName("section_bg_start_color")
    protected List<Integer> sectionBgStartColor;

    @SerializedName("section_header_img")
    protected py.k sectionHeaderImg;

    @SerializedName("section_name")
    protected String sectionName;

    public c3() {
        this.sectionBgStartColor = CollectionsKt.emptyList();
        this.sectionBgEndColor = CollectionsKt.emptyList();
        this.entranceText = BuildConfig.FLAVOR;
        this.entranceSchema = BuildConfig.FLAVOR;
        this.gifts = new ArrayList();
        this.sectionName = BuildConfig.FLAVOR;
    }

    public final py.k a() {
        return this.entranceIconImg;
    }

    public final String b() {
        return this.entranceSchema;
    }

    public final String c() {
        return this.entranceText;
    }

    public final List<h1> d() {
        return this.gifts;
    }

    public final List<Integer> e() {
        return this.sectionBgEndColor;
    }

    public final List<Integer> f() {
        return this.sectionBgStartColor;
    }

    public final py.k g() {
        return this.sectionHeaderImg;
    }

    public final String h() {
        return this.sectionName;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, py.k] */
    public c3(am3.g r5) {
        this.sectionBgStartColor = new ArrayList();
        this.sectionBgEndColor = new ArrayList();
        this.gifts = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L17;
        switch(r2) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.sectionName = am3.h.c(r5);
        goto L3
    L8:
        List<? extends h1> r3 = this.gifts;
        Object r4 = vh7.f.a(r5, h1.class);
    L16:
        r3.add(r4);
        goto L3
    L9:
        this.entranceIconImg = vh7.f.a(r5, py.k.class);
        goto L3
    L10:
        this.entranceSchema = am3.h.c(r5);
        goto L3
    L11:
        this.entranceText = am3.h.c(r5);
        goto L3
    L12:
        this.sectionHeaderImg = vh7.f.a(r5, py.k.class);
        goto L3
    L13:
        r3 = this.sectionBgEndColor;
    L15:
        r4 = Integer.valueOf(r5.i());
        goto L16
    L14:
        r3 = this.sectionBgStartColor;
        goto L15
    L6:
        am3.h.e(r5);
        goto L3
    L17:
        r5.d(r0);
        if (this.sectionBgStartColor.isEmpty() == false) goto L21;
        this.sectionBgStartColor = CollectionsKt.emptyList();
    L21:
        if (this.sectionBgEndColor.isEmpty() == false) goto L24;
        this.sectionBgEndColor = CollectionsKt.emptyList();
    L24:
        if (this.entranceText != null) goto L27;
        this.entranceText = BuildConfig.FLAVOR;
    L27:
        if (this.entranceSchema != null) goto L30;
        this.entranceSchema = BuildConfig.FLAVOR;
    L30:
        if (this.gifts.isEmpty() == false) goto L33;
        this.gifts = new ArrayList();
    L33:
        if (this.sectionName != null) goto L54;
        this.sectionName = BuildConfig.FLAVOR;
        return;
    }

    public final void i(py.k r1) {
        this.entranceIconImg = r1;
    }

    public final void j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entranceSchema = r2;
    }

    public final void k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entranceText = r2;
    }

    public final void l(List<? extends h1> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.gifts = r2;
    }

    public final void m(List<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.sectionBgEndColor = r2;
    }

    public final void n(List<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.sectionBgStartColor = r2;
    }

    public final void o(py.k r1) {
        this.sectionHeaderImg = r1;
    }

    public final void p(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.sectionName = r2;
    }
}
