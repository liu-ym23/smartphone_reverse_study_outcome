package com.bytedance.ai.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/api/Scope;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "userLocation", "userFuzzyLocation", "userLocationBackground", "payment", "record", "bluetooth", "camera", "addPhoneContact", "addPhoneCalendar", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Scope extends Enum<Scope> {
    public static final a Companion = null;
    public static final Set<String> a = null;
    public static final Scope addPhoneCalendar = null;
    public static final Scope addPhoneContact = null;
    public static final /* synthetic */ Scope[] b = null;
    public static final Scope bluetooth = null;
    public static final /* synthetic */ EnumEntries c = null;
    public static final Scope camera = null;
    public static final Scope payment = null;
    public static final Scope record = null;
    public static final Scope userFuzzyLocation = null;
    public static final Scope userLocation = null;
    public static final Scope userLocationBackground = null;
    private final String value;

    public static EnumEntries<Scope> getEntries() {
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.ai.api.Scope$a] */
    static {
        Scope r0 = new Scope("userLocation", 0, "scope.userLocation");
        userLocation = r0;
        Scope r1 = new Scope("userFuzzyLocation", 1, "scope.userFuzzyLocation");
        userFuzzyLocation = r1;
        Scope r10 = new Scope("userLocationBackground", 2, "scope.userLocationBackground");
        userLocationBackground = r10;
        Scope r11 = new Scope("payment", 3, "scope.payment");
        payment = r11;
        Scope r12 = new Scope("record", 4, "scope.record");
        record = r12;
        Scope r13 = new Scope("bluetooth", 5, "scope.bluetooth");
        bluetooth = r13;
        Scope r14 = new Scope("camera", 6, "scope.camera");
        camera = r14;
        Scope r15 = new Scope("addPhoneContact", 7, "scope.addPhoneContact");
        addPhoneContact = r15;
        Scope r16 = new Scope("addPhoneCalendar", 8, "scope.addPhoneCalendar");
        addPhoneCalendar = r16;
        Scope[] r17 = {r0, r1, r10, r11, r12, r13, r14, r15, r16};
        b = r17;
        c = EnumEntriesKt.enumEntries(r17);
        Companion = new a();
        EnumEntries<Scope> r18 = getEntries();
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r20 = r18.iterator();
    L4:
        if (r20.hasNext() == false) goto L6;
        r19.add(((Scope) r20.next()).value);
        goto L4
    L6:
        a = CollectionsKt.toSet(r19);
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
