package com.obric.memorydata.ability.data;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ed;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0002,-B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001d\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003JG\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u001bHÖ\u0001J\t\u0010+\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/memorydata/ability/data/PackageEventStandardData;", "Lcom/obric/memorydata/ability/data/IStandardData;", "Lcom/obric/memorydata/ability/IStorageCollectData;", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "displayName", "versionName", "versionCode", "", "isSystemApp", "", "event", "Lcom/obric/memorydata/ability/data/PackageEventStandardData$Type;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLcom/obric/memorydata/ability/data/PackageEventStandardData$Type;)V", "getPackageName", "()Ljava/lang/String;", "getDisplayName", "getVersionName", "getVersionCode", "()J", "()Z", "getEvent", "()Lcom/obric/memorydata/ability/data/PackageEventStandardData$Type;", "setEvent", "(Lcom/obric/memorydata/ability/data/PackageEventStandardData$Type;)V", "dataVersion", "", "timestamp", "getDataId", "getDataVersion", "collectNewData", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "Type", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PackageEventStandardData implements h, com.obric.memorydata.ability.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8316a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8317b;
    private final String c;
    private final String d;
    private final long e;
    private final boolean f;
    private Type g;
    private final int h;
    private final long i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/ability/data/PackageEventStandardData$Type;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ADD", "REMOVE", "UPDATE", "toString", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type ADD = null;
        public static final Type REMOVE = null;
        public static final Type UPDATE = null;
        private final String value;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{ADD, REMOVE, UPDATE};
        }

        static {
            ADD = new Type("ADD", 0, "add");
            REMOVE = new Type("REMOVE", 1, "remove");
            UPDATE = new Type("UPDATE", 2, BuildConfig.CHANNEL);
            Type[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Type(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String r2) {
            return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
        }

        public static Type[] values() {
            return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/ability/data/PackageEventStandardData$Companion;", "", "<init>", "()V", "from", "Lcom/obric/memorydata/ability/data/PackageEventStandardData;", "packageInfo", "Landroid/content/pm/PackageInfo;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final PackageEventStandardData a(PackageInfo r11) {
            Intrinsics.checkNotNullParameter(r11, "packageInfo");
            String r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getApplicationLabel(r11.applicationInfo).toString();
            if ((r11.applicationInfo.flags & 1) == 0) goto L5;
        L8:
            boolean r6 = true;
        L9:
            String r1 = r11.packageName;
            Intrinsics.checkNotNullExpressionValue(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);
            String r0 = r11.versionName;
            if (r0 != null) goto L13;
            r0 = "";
        L13:
            return new PackageEventStandardData(r1, r2, r0, r11.getLongVersionCode(), r6, null, 32, null);
        L5:
            if ((r11.applicationInfo.flags & 128) != 0) goto L8;
            r6 = false;
            goto L9
        }
    }

    static {
        f8316a = new a(null);
    }

    public PackageEventStandardData(String r2, String r3, String r4, long r5, boolean r7, Type r8) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "displayName");
        Intrinsics.checkNotNullParameter(r4, "versionName");
        this.f8317b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
        this.g = r8;
        this.h = 1;
        this.i = System.currentTimeMillis();
    }

    public /* synthetic */ PackageEventStandardData(String r10, String r11, String r12, long r13, boolean r15, Type r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 32) == 0) goto L5;
        Type r8 = null;
    L6:
        this(r10, r11, r12, r13, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    public final void a(Type r1) {
        this.g = r1;
    }

    public final boolean a() {
        return this.f;
    }

    @Override // com.obric.memorydata.ability.m
    public long collectNewData() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPackageEventDao().insert(new ed(getDataId(), this.h, this.i, this.f8317b, this.c, this.d, this.e, this.f, String.valueOf(this.g), 0, 512, null));
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, PackageEventStandardData.class) == true) goto L8;
        return false;
    L8:
        PackageEventStandardData r10 = (PackageEventStandardData) ZeusTransformUtils.preCheckCast(r9, PackageEventStandardData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8317b, r10.f8317b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L18;
        return false;
    L18:
        if (this.e == r10.e) goto L21;
        return false;
    L21:
        if (this.f == r10.f) goto L24;
        return false;
    L24:
        if (this.g == r10.g) goto L26;
        return false;
    L26:
        return true;
    }

    @Override // com.obric.memorydata.ability.data.h
    public int getDataId() {
        return 100001002;
    }

    public int hashCode() {
        int r0 = ((((((((this.f8317b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31;
        Type r3 = this.g;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r0 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        return "PackageEventStandardData(packageName=" + this.f8317b + ", displayName=" + this.c + ", versionName=" + this.d + ", versionCode=" + this.e + ", isSystemApp=" + this.f + ", event=" + this.g + ')';
    }
}
