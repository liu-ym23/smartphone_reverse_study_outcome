package com.obric.assistant.provider;

import android.content.UriMatcher;
import android.os.Build;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class h implements Function0 {
    public final /* synthetic */ ObricLocalDataSearchDomainProvider a;

    public /* synthetic */ h(ObricLocalDataSearchDomainProvider r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ObricLocalDataSearchDomainProvider r0 = this.a;
        UriMatcher r1 = ObricLocalDataSearchDomainProvider.f;
        Map r2 = MapsKt.createMapBuilder();
        r2.put("android:read_contacts", SetsKt.setOf("android.permission.READ_CONTACTS"));
        r2.put("android:read_call_log", SetsKt.setOf("android.permission.READ_CALL_LOG"));
        r2.put("android:read_sms", SetsKt.setOf("android.permission.READ_SMS"));
        r2.put("android:read_calendar", SetsKt.setOf("android.permission.READ_CALENDAR"));
        int r3 = Build.VERSION.SDK_INT;
        if (r3 < 34) goto L6;
        r2.put("android:read_media_visual_user_selected", SetsKt.setOf("android.permission.READ_MEDIA_VISUAL_USER_SELECTED"));
    L6:
        if (r3 < 33) goto L9;
        r2.put("android:read_media_images", SetsKt.setOf("android.permission.READ_MEDIA_IMAGES"));
        r2.put("android:read_media_video", SetsKt.setOf("android.permission.READ_MEDIA_VIDEO"));
    L9:
        if (r3 < 30) goto L11;
        r2.put("android:manage_external_storage", SetsKt.setOf("android.permission.MANAGE_EXTERNAL_STORAGE"));
    L11:
        Map r4 = MapsKt.build(r2);
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator r6 = r4.entrySet().iterator();
    L13:
        if (r6.hasNext() == false) goto L28;
        Map.Entry r7 = (Map.Entry) r6.next();
        Set r8 = (Set) r7.getValue();
        if ((r8 instanceof Collection) == true) goto L17;
    L19:
        Iterator r9 = r8.iterator();
    L21:
        if (r9.hasNext() == false) goto L25;
        String r10 = (String) r9.next();
        if (((Set) r0.d.getValue()).contains(r10) == false) goto L21;
        boolean r11 = true;
    L26:
        if (r11 == false) goto L13;
        r5.put(r7.getKey(), r7.getValue());
    L25:
        r11 = false;
        goto L26
    L17:
        if (r8.isEmpty() == false) goto L19;
    L28:
        return r5;
    }
}
