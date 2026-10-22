package androidx.room.jarjarred.kotlinx.metadata.jvm;

import androidx.room.jarjarred.kotlinx.metadata.KmClassExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionType;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u00020\b2\n\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00008TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0017\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmClassExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmDeclarationContainerExtensionVisitor;", "delegate", "<init>", "(Ljava/lang/Object;)V", "", "internalName", "", "visitAnonymousObjectOriginName", "(Ljava/lang/String;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "visitJvmFlags", "(I)V", "visitEnd", "()V", "getDelegate", "()Ljava/lang/Object;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "getType", "()Lzt/c;", "type", "Companion", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class JvmClassExtensionVisitor extends JvmDeclarationContainerExtensionVisitor implements KmClassExtensionVisitor {
    public static final Companion Companion = null;

    @JvmField
    public static final KmExtensionType TYPE = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmClassExtensionVisitor$Companion;", "", "()V", "TYPE", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmClassExtensionVisitor.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public JvmClassExtensionVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmDeclarationContainerExtensionVisitor
    public /* bridge */ /* synthetic */ JvmDeclarationContainerExtensionVisitor getDelegate() {
        return getDelegate();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmExtensionVisitor
    public final KmExtensionType getType() {
        return TYPE;
    }

    public void visitAnonymousObjectOriginName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "internalName");
        JvmClassExtensionVisitor r10 = getDelegate();
        if (r10 == null) goto L6;
        r10.visitAnonymousObjectOriginName(r5);
        return;
    }

    public void visitEnd() {
        JvmClassExtensionVisitor r5 = getDelegate();
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    public void visitJvmFlags(int r5) {
        JvmClassExtensionVisitor r10 = getDelegate();
        if (r10 == null) goto L6;
        r10.visitJvmFlags(r5);
        return;
    }

    public /* synthetic */ JvmClassExtensionVisitor(JvmClassExtensionVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmDeclarationContainerExtensionVisitor
    public JvmClassExtensionVisitor getDelegate() {
        return (JvmClassExtensionVisitor) super.getDelegate();
    }

    @JvmOverloads
    public JvmClassExtensionVisitor(JvmClassExtensionVisitor r5) {
        super(r5);
    }
}
