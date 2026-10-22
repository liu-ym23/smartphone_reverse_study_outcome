package com.ss.android.lark.chameleon.widget.emptyview;

import android.content.Context;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J \u0010#\u001a\u00020\u001f2\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070&0%J\u0014\u0010\u0005\u001a\u00020\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%J\u0014\u0010'\u001a\u00020\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070%J \u0010(\u001a\u00020\u001f2\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00150&0%J\u0014\u0010\u0014\u001a\u00020\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%J \u0010)\u001a\u00020\u001f2\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00150&0%J\u0014\u0010\u0019\u001a\u00020\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%J \u0010*\u001a\u00020\u001f2\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00150&0%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00150\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00150\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00150\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u0018¨\u0006+"}, d2 = {"Lcom/ss/android/lark/chameleon/widget/emptyview/Config;", BuildConfig.FLAVOR, "()V", "FEATURE_KEY_NEW_ERROR_OPTIMIZATION", BuildConfig.FLAVOR, "icons", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getIcons", "()Ljava/util/Map;", "language", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "loadingView", "getLoadingView", "()I", "setLoadingView", "(I)V", "subTips", BuildConfig.FLAVOR, "getSubTips", "setSubTips", "(Ljava/util/Map;)V", "tips", "getTips", "viewsTxt", "getViewsTxt", "setViewsTxt", "defaultIcons", BuildConfig.FLAVOR, "defaultTips", "context", "Landroid/content/Context;", "icon", "build", "Lkotlin/Function0;", "Lkotlin/Pair;", "loading", "subTip", "tip", "viewText", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Config {
    private final String FEATURE_KEY_NEW_ERROR_OPTIMIZATION;
    private final Map<Integer, Integer> icons;
    private String language;
    private int loadingView;
    private Map<Integer, CharSequence> subTips;
    private final Map<Integer, CharSequence> tips;
    private Map<Integer, CharSequence> viewsTxt;

    public final void defaultIcons() {
        icon(AnonymousClass1.INSTANCE);
        icon(AnonymousClass2.INSTANCE);
        icon(AnonymousClass3.INSTANCE);
        icon(AnonymousClass4.INSTANCE);
        icon(AnonymousClass5.INSTANCE);
        icon(AnonymousClass6.INSTANCE);
        icon(AnonymousClass7.INSTANCE);
        icon(AnonymousClass8.INSTANCE);
    }

    public Config() {
        this.tips = new LinkedHashMap();
        this.icons = new LinkedHashMap();
        this.viewsTxt = new LinkedHashMap();
        this.language = Locale.ENGLISH.getLanguage();
        this.FEATURE_KEY_NEW_ERROR_OPTIMIZATION = "ccm.newerror.optimization";
        this.subTips = new LinkedHashMap();
    }

    public final Map<Integer, Integer> getIcons() {
        return this.icons;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final int getLoadingView() {
        return this.loadingView;
    }

    public final Map<Integer, CharSequence> getSubTips() {
        return this.subTips;
    }

    public final Map<Integer, CharSequence> getTips() {
        return this.tips;
    }

    public final Map<Integer, CharSequence> getViewsTxt() {
        return this.viewsTxt;
    }

    public final void defaultTips(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        tip(C03301.INSTANCE);
        tip(new C03312(r2));
        tip(new C03323(r2));
        tip(new C03334(r2));
        tip(new C03345(r2));
        tip(new C03356(r2));
        tip(new C03367(r2));
        tip(new C03378(r2));
    }

    public final void icon(Function0<Pair<Integer, Integer>> r3) {
        Intrinsics.checkNotNullParameter(r3, "build");
        Pair r4 = (Pair) r3.invoke();
        Map<Integer, Integer> r0 = this.icons;
        Object r1 = r4.getFirst();
        r0.put((Integer) r1, (Integer) r4.getSecond());
    }

    public final void icons(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "build");
        r2.invoke();
    }

    public final void loading(Function0<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "build");
        this.loadingView = ((Number) r2.invoke()).intValue();
    }

    public final void setLanguage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.language = r2;
    }

    public final void setLoadingView(int r1) {
        this.loadingView = r1;
    }

    public final void setSubTips(Map<Integer, CharSequence> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.subTips = r2;
    }

    public final void setViewsTxt(Map<Integer, CharSequence> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.viewsTxt = r2;
    }

    public final void subTip(Function0<? extends Pair<Integer, ? extends CharSequence>> r3) {
        Intrinsics.checkNotNullParameter(r3, "build");
        Pair r4 = (Pair) r3.invoke();
        Map<Integer, CharSequence> r0 = this.subTips;
        Object r1 = r4.getFirst();
        r0.put((Integer) r1, (CharSequence) r4.getSecond());
    }

    public final void subTips(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "build");
        r2.invoke();
    }

    public final void tip(Function0<? extends Pair<Integer, ? extends CharSequence>> r3) {
        Intrinsics.checkNotNullParameter(r3, "build");
        Pair r4 = (Pair) r3.invoke();
        Map<Integer, CharSequence> r0 = this.tips;
        Object r1 = r4.getFirst();
        r0.put((Integer) r1, (CharSequence) r4.getSecond());
    }

    public final void tips(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "build");
        r2.invoke();
    }

    public final void viewText(Function0<? extends Pair<Integer, ? extends CharSequence>> r3) {
        Intrinsics.checkNotNullParameter(r3, "build");
        Pair r4 = (Pair) r3.invoke();
        Map<Integer, CharSequence> r0 = this.viewsTxt;
        Object r1 = r4.getFirst();
        r0.put((Integer) r1, (CharSequence) r4.getSecond());
    }
}
