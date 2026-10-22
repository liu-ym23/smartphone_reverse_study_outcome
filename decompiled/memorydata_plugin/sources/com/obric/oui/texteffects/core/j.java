package com.obric.oui.texteffects.core;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\f\rB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectLayer;", "", "()V", OaidModel.KEY_ID, "", "getId", "()Ljava/lang/String;", "properties", "", "Lcom/obric/oui/texteffects/core/PropertyTrack;", "getProperties", "()Ljava/util/List;", "ExternalView", "Text", "Lcom/obric/oui/texteffects/core/EffectLayer$Text;", "Lcom/obric/oui/texteffects/core/EffectLayer$ExternalView;", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class j {

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectLayer$ExternalView;", "Lcom/obric/oui/texteffects/core/EffectLayer;", OaidModel.KEY_ID, "", "bindingKey", "gradientBlurConfig", "Lcom/obric/oui/texteffects/core/GradientBlurLayerSpec;", "properties", "", "Lcom/obric/oui/texteffects/core/PropertyTrack;", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/oui/texteffects/core/GradientBlurLayerSpec;Ljava/util/List;)V", "getBindingKey", "()Ljava/lang/String;", "getGradientBlurConfig", "()Lcom/obric/oui/texteffects/core/GradientBlurLayerSpec;", "getId", "getProperties", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14605b;
        private final o c;
        private final List<t> d;

        public a(String r3, String r4, o r5, List<t> r6) {
            List<t> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r4, "bindingKey");
            Intrinsics.checkNotNullParameter(r7, "properties");
            super(null);
            this.f14604a = r3;
            this.f14605b = r4;
            this.c = r5;
            this.d = r7;
        }

        @Override // com.obric.oui.texteffects.core.j
        public String a() {
            return this.f14604a;
        }

        @Override // com.obric.oui.texteffects.core.j
        public List<t> b() {
            return this.d;
        }

        public final String c() {
            return this.f14605b;
        }

        public final o d() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(a(), r6.a()) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f14605b, r6.f14605b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(b(), r6.b()) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((a().hashCode() * 31) + this.f14605b.hashCode()) * 31;
            o r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + b().hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "ExternalView(id=" + a() + ", bindingKey=" + this.f14605b + ", gradientBlurConfig=" + this.c + ", properties=" + b() + ')';
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003JY\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectLayer$Text;", "Lcom/obric/oui/texteffects/core/EffectLayer;", OaidModel.KEY_ID, "", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/oui/texteffects/core/TextSource;", "fill", "Lcom/obric/oui/texteffects/core/FillSpec;", "mask", "Lcom/obric/oui/texteffects/core/MaskSpec;", "blend", "Lcom/obric/oui/texteffects/core/BlendSpec;", "character", "Lcom/obric/oui/texteffects/core/CharacterEffectSpec;", "properties", "", "Lcom/obric/oui/texteffects/core/PropertyTrack;", "(Ljava/lang/String;Lcom/obric/oui/texteffects/core/TextSource;Lcom/obric/oui/texteffects/core/FillSpec;Lcom/obric/oui/texteffects/core/MaskSpec;Lcom/obric/oui/texteffects/core/BlendSpec;Lcom/obric/oui/texteffects/core/CharacterEffectSpec;Ljava/util/List;)V", "getBlend", "()Lcom/obric/oui/texteffects/core/BlendSpec;", "getCharacter", "()Lcom/obric/oui/texteffects/core/CharacterEffectSpec;", "getFill", "()Lcom/obric/oui/texteffects/core/FillSpec;", "getId", "()Ljava/lang/String;", "getMask", "()Lcom/obric/oui/texteffects/core/MaskSpec;", "getProperties", "()Ljava/util/List;", "getSource", "()Lcom/obric/oui/texteffects/core/TextSource;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextSource f14607b;
        private final n c;
        private final s d;
        private final BlendSpec e;
        private final d f;
        private final List<t> g;

        public b(String r3, TextSource r4, n r5, s r6, BlendSpec r7, d r8, List<t> r9) {
            List<t> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r4, AILabCheckPermissionTask.KEY_SOURCE);
            Intrinsics.checkNotNullParameter(r5, "fill");
            Intrinsics.checkNotNullParameter(r7, "blend");
            Intrinsics.checkNotNullParameter(r10, "properties");
            super(null);
            this.f14606a = r3;
            this.f14607b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r10;
        }

        @Override // com.obric.oui.texteffects.core.j
        public String a() {
            return this.f14606a;
        }

        @Override // com.obric.oui.texteffects.core.j
        public List<t> b() {
            return this.g;
        }

        public final TextSource c() {
            return this.f14607b;
        }

        public final n d() {
            return this.c;
        }

        public final s e() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(a(), r6.a()) == true) goto L12;
            return false;
        L12:
            if (this.f14607b == r6.f14607b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(b(), r6.b()) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final BlendSpec f() {
            return this.e;
        }

        public final d g() {
            return this.f;
        }

        public int hashCode() {
            int r0 = ((((a().hashCode() * 31) + this.f14607b.hashCode()) * 31) + this.c.hashCode()) * 31;
            s r1 = this.d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.e.hashCode()) * 31;
            d r5 = this.f;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + b().hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "Text(id=" + a() + ", source=" + this.f14607b + ", fill=" + this.c + ", mask=" + this.d + ", blend=" + this.e + ", character=" + this.f + ", properties=" + b() + ')';
        }
    }

    private j() {
    }

    public /* synthetic */ j(DefaultConstructorMarker r1) {
        this();
    }

    public abstract String a();

    public abstract List<t> b();
}
