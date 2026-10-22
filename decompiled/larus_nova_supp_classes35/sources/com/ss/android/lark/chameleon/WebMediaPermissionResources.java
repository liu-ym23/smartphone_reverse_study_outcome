package com.ss.android.lark.chameleon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chameleon/WebMediaPermissionResources;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "()V", "AUDIO_CAPTURE", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "VIDEO_CAPTURE", "webToAndroid", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "grantableWebResources", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "requested", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "([Ljava/lang/String;)Ljava/util/List;", "androidPermissions", "webResources", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebMediaPermissionResources {
    public static final String AUDIO_CAPTURE = "android.webkit.resource.AUDIO_CAPTURE";
    public static final WebMediaPermissionResources INSTANCE = null;
    public static final String VIDEO_CAPTURE = "android.webkit.resource.VIDEO_CAPTURE";
    private static final Map<String, String> webToAndroid = null;

    private WebMediaPermissionResources() {
    }

    static {
        INSTANCE = new WebMediaPermissionResources();
        webToAndroid = MapsKt.mapOf(new Pair[]{TuplesKt.to(AUDIO_CAPTURE, "android.permission.RECORD_AUDIO"), TuplesKt.to(VIDEO_CAPTURE, "android.permission.CAMERA")});
    }

    @JvmStatic
    public static final List<String> androidPermissions(Collection<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "webResources");
        Map<String, String> r0 = webToAndroid;
        ArrayList r1 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        String r2 = r0.get((String) r4.next());
        if (r2 == null) goto L4;
        r1.add(r2);
        goto L4
    L9:
        return CollectionsKt.distinct(r1);
    }

    @JvmStatic
    public static final List<String> grantableWebResources(String[] r5) {
        if (r5 == null) goto L4;
        ArrayList r0 = new ArrayList();
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        String r3 = r5[r2];
        if (webToAndroid.containsKey(r3) == false) goto L10;
        r0.add(r3);
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        return r0;
    L4:
        return CollectionsKt.emptyList();
    }
}
