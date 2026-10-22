package androidx.room.jarjarred.kotlinx.metadata.jvm;

import androidx.room.jarjarred.kotlinx.metadata.KmExtensionType;
import androidx.room.jarjarred.kotlinx.metadata.KmPropertyExtensionVisitor;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\u000e\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b\u000e\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0017R\u0011\u0010\u001b\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmPropertyExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyExtensionVisitor;", "delegate", "<init>", "(Ljava/lang/Object;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "jvmFlags", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmFieldSignature;", "fieldSignature", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;", "getterSignature", "setterSignature", "", "visit", "(ILandroidx/room/jarjarred/kotlinx/metadata/jvm/JvmFieldSignature;Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;)V", "(Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmFieldSignature;Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;)V", "signature", "visitSyntheticMethodForAnnotations", "(Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;)V", "visitSyntheticMethodForDelegate", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmPropertyExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "getType", "()Lzt/c;", "type", "Companion", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class JvmPropertyExtensionVisitor implements KmPropertyExtensionVisitor {
    public static final Companion Companion = null;

    @JvmField
    public static final KmExtensionType TYPE = null;
    private final JvmPropertyExtensionVisitor delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmPropertyExtensionVisitor$Companion;", "", "()V", "TYPE", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmPropertyExtensionVisitor.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public JvmPropertyExtensionVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmExtensionVisitor
    public final KmExtensionType getType() {
        return TYPE;
    }

    public void visit(int r5, JvmFieldSignature r10, JvmMethodSignature r11, JvmMethodSignature r12) {
        JvmPropertyExtensionVisitor r13 = this.delegate;
        if (r13 == null) goto L5;
        r13.visit(r5, r10, r11, r12);
    L5:
        visit(r10, r11, r12);
    }

    public void visitEnd() {
        JvmPropertyExtensionVisitor r5 = this.delegate;
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    public void visitSyntheticMethodForAnnotations(JvmMethodSignature r5) {
        JvmPropertyExtensionVisitor r10 = this.delegate;
        if (r10 == null) goto L6;
        r10.visitSyntheticMethodForAnnotations(r5);
        return;
    }

    public void visitSyntheticMethodForDelegate(JvmMethodSignature r5) {
        JvmPropertyExtensionVisitor r10 = this.delegate;
        if (r10 == null) goto L6;
        r10.visitSyntheticMethodForDelegate(r5);
        return;
    }

    @JvmOverloads
    public JvmPropertyExtensionVisitor(JvmPropertyExtensionVisitor r5) {
        this.delegate = r5;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use visit(Flags, JvmFieldSignature?, JvmMethodSignature?, JvmMethodSignature?) instead.", replaceWith = @ReplaceWith(expression = "visit(flagsOf(), fieldSignature, getterSignature, setterSignature)", imports = {"androidx.room.jarjarred.kotlinx.metadata.flagsOf"}))
    public void visit(JvmFieldSignature r5, JvmMethodSignature r10, JvmMethodSignature r11) {
        JvmPropertyExtensionVisitor r12 = this.delegate;
        if (r12 == null) goto L6;
        r12.visit(r5, r10, r11);
        return;
    }

    public /* synthetic */ JvmPropertyExtensionVisitor(JvmPropertyExtensionVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
