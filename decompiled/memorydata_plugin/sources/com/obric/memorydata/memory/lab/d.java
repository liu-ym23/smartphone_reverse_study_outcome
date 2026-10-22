package com.obric.memorydata.memory.lab;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003JS\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016¨\u0006("}, d2 = {"Lcom/obric/memorydata/memory/lab/AILabPermissionState;", "", "schema", "Lcom/obric/memorydata/memory/lab/AILabPermissionRepository$PermissionSchema;", "rawData", "Lorg/json/JSONObject;", "labVisible", "", "screenMemory", "Lcom/obric/memorydata/memory/lab/AILabPermissionItemState;", "voiceMemory", "autoMemory", "aiProactiveAgent", "<init>", "(Lcom/obric/memorydata/memory/lab/AILabPermissionRepository$PermissionSchema;Lorg/json/JSONObject;ZLcom/obric/memorydata/memory/lab/AILabPermissionItemState;Lcom/obric/memorydata/memory/lab/AILabPermissionItemState;Lcom/obric/memorydata/memory/lab/AILabPermissionItemState;Lcom/obric/memorydata/memory/lab/AILabPermissionItemState;)V", "getSchema", "()Lcom/obric/memorydata/memory/lab/AILabPermissionRepository$PermissionSchema;", "getRawData", "()Lorg/json/JSONObject;", "getLabVisible", "()Z", "getScreenMemory", "()Lcom/obric/memorydata/memory/lab/AILabPermissionItemState;", "getVoiceMemory", "getAutoMemory", "getAiProactiveAgent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AILabPermissionRepository.PermissionSchema f10248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f10249b;
    private final boolean c;
    private final c d;
    private final c e;
    private final c f;
    private final c g;

    public d(AILabPermissionRepository.PermissionSchema r2, JSONObject r3, boolean r4, c r5, c r6, c r7, c r8) {
        Intrinsics.checkNotNullParameter(r5, "screenMemory");
        Intrinsics.checkNotNullParameter(r6, "voiceMemory");
        Intrinsics.checkNotNullParameter(r7, "autoMemory");
        Intrinsics.checkNotNullParameter(r8, "aiProactiveAgent");
        this.f10248a = r2;
        this.f10249b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public final AILabPermissionRepository.PermissionSchema a() {
        return this.f10248a;
    }

    public final JSONObject b() {
        return this.f10249b;
    }

    public final boolean c() {
        return this.c;
    }

    public final c d() {
        return this.d;
    }

    public final c e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (this.f10248a == r6.f10248a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10249b, r6.f10249b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final c f() {
        return this.f;
    }

    public final c g() {
        return this.g;
    }

    public int hashCode() {
        AILabPermissionRepository.PermissionSchema r0 = this.f10248a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        JSONObject r4 = this.f10249b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((((((((r3 + r1) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AILabPermissionState(schema=" + this.f10248a + ", rawData=" + this.f10249b + ", labVisible=" + this.c + ", screenMemory=" + this.d + ", voiceMemory=" + this.e + ", autoMemory=" + this.f + ", aiProactiveAgent=" + this.g + ')';
    }
}
