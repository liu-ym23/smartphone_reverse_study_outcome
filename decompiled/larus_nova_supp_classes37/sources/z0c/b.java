package z0c;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.playerconfig.LarkPlayerSettings;
import com.ss.ttvideoengine.TTVideoEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(TTVideoEngine r6, String r7, String r8) {
        Lazy r0 = LarkPlayerSettings.a;
        Intrinsics.checkNotNullParameter(r7, "tag");
        Intrinsics.checkNotNullParameter(r8, "subTag");
        HashMap r1 = new HashMap();
        LarkPlayerSettings.EngineSetting r2 = (LarkPlayerSettings.EngineSetting) LarkPlayerSettings.d.getValue();
        ArrayList<LarkPlayerSettings.SettingItem> r3 = r2.getBase();
        if (r3 == null) goto L8;
        Iterator<T> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        LarkPlayerSettings.SettingItem r5 = (LarkPlayerSettings.SettingItem) r4.next();
        r1.put(Integer.valueOf(r5.getKey()), r5);
    L8:
        ArrayList<LarkPlayerSettings.TagItem> r9 = r2.getTags();
        if (r9 == null) goto L41;
        Iterator<T> r10 = r9.iterator();
    L11:
        Object r11 = null;
        if (r10.hasNext() == false) goto L16;
        Object r12 = r10.next();
        if (Intrinsics.areEqual(((LarkPlayerSettings.TagItem) r12).getName(), r7) == false) goto L11;
    L17:
        LarkPlayerSettings.TagItem r13 = (LarkPlayerSettings.TagItem) r12;
        if (r13 == null) goto L41;
        ArrayList<LarkPlayerSettings.SettingItem> r14 = r13.getBase();
        if (r14 == null) goto L25;
        Iterator<T> r15 = r14.iterator();
    L23:
        if (r15.hasNext() == false) goto L25;
        LarkPlayerSettings.SettingItem r16 = (LarkPlayerSettings.SettingItem) r15.next();
        r1.put(Integer.valueOf(r16.getKey()), r16);
    L25:
        ArrayList<LarkPlayerSettings.SubTagItem> r17 = r13.getSubTags();
        if (r17 == null) goto L41;
        Iterator<T> r18 = r17.iterator();
    L29:
        if (r18.hasNext() == false) goto L33;
        Object r19 = r18.next();
        if (Intrinsics.areEqual(((LarkPlayerSettings.SubTagItem) r19).getName(), r8) == false) goto L29;
        r11 = r19;
    L33:
        LarkPlayerSettings.SubTagItem r20 = (LarkPlayerSettings.SubTagItem) r11;
        if (r20 == null) goto L41;
        ArrayList<LarkPlayerSettings.SettingItem> r21 = r20.getBase();
        if (r21 == null) goto L41;
        Iterator<T> r22 = r21.iterator();
    L39:
        if (r22.hasNext() == false) goto L41;
        LarkPlayerSettings.SettingItem r23 = (LarkPlayerSettings.SettingItem) r22.next();
        r1.put(Integer.valueOf(r23.getKey()), r23);
        goto L39
    L16:
        r12 = null;
    L41:
        Iterator r24 = r1.values().iterator();
    L43:
        if (r24.hasNext() == false) goto L73;
        LarkPlayerSettings.SettingItem r25 = (LarkPlayerSettings.SettingItem) r24.next();
        if (r25.getKey() == Integer.MAX_VALUE) goto L43;
        if (r25.getValue() == null) goto L43;
        if (r25.getType().length() <= 0) goto L51;
        boolean r26 = true;
    L52:
        if (r26 == false) goto L43;
        String r27 = r25.getType();
        switch(r27.hashCode()) {
            case -891985903: goto L69;
            case 104431: goto L65;
            case 3327612: goto L61;
            case 97526364: goto L57;
            default: goto L72;
        };
    L72:
        Log.i("LarkPlayerEngineConfig", "tag:" + r7 + ", subTag:" + r8 + ", set engine key:" + r25.getDesc() + ", value:" + r25.getValue());
        goto L43
    L57:
        if (r27.equals("float") == false) goto L72;
        int r28 = r25.getKey();
        Object r29 = r25.getValue();
        Intrinsics.checkNotNull(r29, "null cannot be cast to non-null type kotlin.Double");
        r6.setFloatOption(r28, (float) ((Double) r29).doubleValue());
        goto L72
    L61:
        if (r27.equals("long") == false) goto L72;
        int r30 = r25.getKey();
        Object r31 = r25.getValue();
        Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type kotlin.Double");
        r6.setLongOption(r30, (long) ((Double) r31).doubleValue());
        goto L72
    L65:
        if (r27.equals("int") == false) goto L72;
        int r32 = r25.getKey();
        Object r33 = r25.getValue();
        Intrinsics.checkNotNull(r33, "null cannot be cast to non-null type kotlin.Double");
        r6.setIntOption(r32, (int) ((Double) r33).doubleValue());
        goto L72
    L69:
        if (r27.equals("string") == false) goto L72;
        int r34 = r25.getKey();
        Object r35 = r25.getValue();
        Intrinsics.checkNotNull(r35, "null cannot be cast to non-null type kotlin.String");
        r6.setStringOption(r34, (String) r35);
        goto L72
    L51:
        r26 = false;
        goto L52
    }
}
