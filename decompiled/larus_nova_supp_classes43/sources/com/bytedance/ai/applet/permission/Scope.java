package com.bytedance.ai.applet.permission;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/applet/permission/Scope;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "userLocation", "userFuzzyLocation", "userLocationBackground", "record", "bluetooth", "camera", "addPhoneContact", "addPhoneCalendar", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Scope extends Enum<Scope> {
    public static final a Companion = null;
    public static final Set<String> a = null;
    public static final Scope addPhoneCalendar = null;
    public static final Scope addPhoneContact = null;
    public static final /* synthetic */ Scope[] b = null;
    public static final Scope bluetooth = null;
    public static final /* synthetic */ EnumEntries c = null;
    public static final Scope camera = null;
    public static final Scope record = null;
    public static final Scope userFuzzyLocation = null;
    public static final Scope userLocation = null;
    public static final Scope userLocationBackground = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<Scope> getEntries() {
        return c;
    }

    static {
        Scope r0 = new Scope("userLocation", 0, "scope.userLocation");
        userLocation = r0;
        Scope r1 = new Scope("userFuzzyLocation", 1, "scope.userFuzzyLocation");
        userFuzzyLocation = r1;
        Scope r10 = new Scope("userLocationBackground", 2, "scope.userLocationBackground");
        userLocationBackground = r10;
        Scope r11 = new Scope("record", 3, "scope.record");
        record = r11;
        Scope r12 = new Scope("bluetooth", 4, "scope.bluetooth");
        bluetooth = r12;
        Scope r13 = new Scope("camera", 5, "scope.camera");
        camera = r13;
        Scope r14 = new Scope("addPhoneContact", 6, "scope.addPhoneContact");
        addPhoneContact = r14;
        Scope r15 = new Scope("addPhoneCalendar", 7, "scope.addPhoneCalendar");
        addPhoneCalendar = r15;
        Scope[] r16 = {r0, r1, r10, r11, r12, r13, r14, r15};
        b = r16;
        c = EnumEntriesKt.enumEntries(r16);
        Companion = new a();
        EnumEntries<Scope> r17 = getEntries();
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L4:
        if (r19.hasNext() == false) goto L6;
        r18.add(((Scope) r19.next()).value);
        goto L4
    L6:
        a = CollectionsKt.toSet(r18);
    }

    public static Scope[] values() {
        return (Scope[]) b.clone();
    }

    public static final /* synthetic */ Set access$getVALUES$cp() {
        return a;
    }

    public final String getValue() {
        return this.value;
    }

    public static Scope valueOf(String r1) {
        return (Scope) r27.a.a(Scope.class, r1);
    }

    public Scope(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}
