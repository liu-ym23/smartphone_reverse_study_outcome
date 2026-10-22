package com.obric.memorydata.memory.intent;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/intent/TargetEntity;", "", OaidModel.KEY_ID, "", "type", "", "_packageName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getType", "()I", "get_packageName", "isValid", "", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TargetEntity {
    public static final a Companion = null;
    private final String _packageName;
    private final String id;
    private final int type;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/intent/TargetEntity$Companion;", "", "<init>", "()V", "fromJsonList", "", "Lcom/obric/memorydata/memory/intent/TargetEntity;", "jsonString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: com.obric.memorydata.memory.intent.TargetEntity$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0500a extends TypeToken<List<? extends TargetEntity>> {
            public C0500a() {
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final List<TargetEntity> a(String r5) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
            boolean r1 = false;
            if (r4 != null) goto L5;
        L8:
            boolean r6 = true;
        L9:
            if (r6 == true) goto L11;
            GsonUtil r7 = GsonUtil.INSTANCE;     // Catch: JsonSyntaxException -> L32
            List r8 = null;
            if (r5 != null) goto L15;
        L22:
            if (r8 == null) goto L42;
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");     // Catch: JsonSyntaxException -> L32
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: JsonSyntaxException -> L32
            Iterator r11 = r9.iterator();     // Catch: JsonSyntaxException -> L32
        L25:
            if (r11.hasNext() == false) goto L41;
            Object r2 = r11.next();     // Catch: JsonSyntaxException -> L32
            if (((TargetEntity) ZeusTransformUtils.preCheckCast(r2, TargetEntity.class, "com.obric.memorydata.plugin")).isValid() == false) goto L25;
            r10.add(r2);     // Catch: JsonSyntaxException -> L32
            goto L25
        L41:
            return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        L42:
            return CollectionsKt.emptyList();
        L15:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L17;
            r1 = true;
        L17:
            if (r1 == true) goto L20;
            r5 = null;
        L20:
            if (r5 == null) goto L22;
            r8 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r5, new C0500a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonSyntaxException -> L32
        L32:
            e = move-exception;
            e.printStackTrace();
            return CollectionsKt.emptyList();
        L11:
            return CollectionsKt.emptyList();
        L5:
            if (r4.length() == 0) goto L8;
            r6 = false;
            goto L9
        }
    }

    static {
        Companion = new a(null);
    }

    public TargetEntity(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r4, "_packageName");
        this.id = r2;
        this.type = r3;
        this._packageName = r4;
    }

    public static /* synthetic */ TargetEntity copy$default(TargetEntity r0, String r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.type;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0._packageName;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.id;
    }

    public final int component2() {
        return this.type;
    }

    public final String component3() {
        return this._packageName;
    }

    public final TargetEntity copy(String r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "_packageName");
        return new TargetEntity(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TargetEntity.class) == true) goto L8;
        return false;
    L8:
        TargetEntity r6 = (TargetEntity) ZeusTransformUtils.preCheckCast(r5, TargetEntity.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (this.type == r6.type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this._packageName, r6._packageName) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getId() {
        return this.id;
    }

    public final int getType() {
        return this.type;
    }

    public final String get_packageName() {
        return this._packageName;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + Integer.hashCode(this.type)) * 31) + this._packageName.hashCode();
    }

    public final boolean isValid() {
        if (this.id == null) goto L14;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(this._packageName, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == true) goto L14;
        return true;
    L7:
        if (r4.length() == 0) goto L10;
        r5 = false;
    L14:
        return false;
    }

    public String toString() {
        return "TargetEntity(id=" + this.id + ", type=" + this.type + ", _packageName=" + this._packageName + ')';
    }
}
