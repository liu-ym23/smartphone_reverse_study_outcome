package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XEnumEntry;
import androidx.room.compiler.processing.XEnumTypeElement;
import androidx.room.compiler.processing.XMemberContainer;
import androidx.room.compiler.processing.XTypeElement;
import com.google.devtools.ksp.symbol.ClassKind;
import il.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\r¨\u0006\u0015"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspEnumEntry;", "Landroidx/room/compiler/processing/ksp/KspTypeElement;", "Landroidx/room/compiler/processing/XEnumEntry;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/c;", "element", "Landroidx/room/compiler/processing/XEnumTypeElement;", "enclosingElement", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/c;Landroidx/room/compiler/processing/XEnumTypeElement;)V", "Landroidx/room/compiler/processing/XEnumTypeElement;", "getEnclosingElement", "()Landroidx/room/compiler/processing/XEnumTypeElement;", "", "getName", "()Ljava/lang/String;", "name", "getClosestMemberContainer", "closestMemberContainer", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspEnumEntry extends KspTypeElement implements XEnumEntry {
    public static final Companion Companion = null;
    private final XEnumTypeElement enclosingElement;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspEnumEntry$Companion;", "", "<init>", "()V", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/c;", "declaration", "Landroidx/room/compiler/processing/ksp/KspEnumEntry;", "create", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/c;)Landroidx/room/compiler/processing/ksp/KspEnumEntry;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final KspEnumEntry create(KspProcessingEnv r5, c r10) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "declaration");
            if (r10.b() != ClassKind.ENUM_ENTRY) goto L7;
            KspTypeElement.Companion r11 = KspTypeElement.Companion;
            KSDeclarationExtKt.requireEnclosingMemberContainer(r10, r5).getDeclaration();
            Intrinsics.checkNotNull(null, "null cannot be cast to non-null type com.google.devtools.ksp.symbol.KSClassDeclaration");
            XMemberContainer r12 = r11.create(r5, null);
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.room.compiler.processing.XEnumTypeElement");
            return new KspEnumEntry(r5, r10, (XEnumTypeElement) r12);
        L7:
            throw new IllegalArgumentException(("Expected declaration to be an enum entry but was " + r10.b()).toString());
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KspEnumEntry(KspProcessingEnv r5, c r10, XEnumTypeElement r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "enclosingElement");
        super(r5, r10, null);
        this.enclosingElement = r11;
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XMemberContainer getClosestMemberContainer() {
        return getClosestMemberContainer();
    }

    @Override // androidx.room.compiler.processing.ksp.KspTypeElement, androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XElement getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.ksp.KspTypeElement, androidx.room.compiler.processing.XElement
    public String getName() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XTypeElement getClosestMemberContainer() {
        return getClosestMemberContainer();
    }

    @Override // androidx.room.compiler.processing.ksp.KspTypeElement, androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XMemberContainer getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XElement
    public XEnumTypeElement getClosestMemberContainer() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.ksp.KspTypeElement, androidx.room.compiler.processing.XElement
    public XEnumTypeElement getEnclosingElement() {
        return this.enclosingElement;
    }
}
