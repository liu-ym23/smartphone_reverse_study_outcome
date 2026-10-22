package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XEnumEntry;
import androidx.room.compiler.processing.XEnumTypeElement;
import androidx.room.compiler.processing.XMemberContainer;
import javax.lang.model.element.Element;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0014\u0010\n\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacEnumEntry;", "Landroidx/room/compiler/processing/javac/JavacElement;", "Landroidx/room/compiler/processing/XEnumEntry;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "entryElement", "Ljavax/lang/model/element/Element;", "enclosingElement", "Landroidx/room/compiler/processing/XEnumTypeElement;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/element/Element;Landroidx/room/compiler/processing/XEnumTypeElement;)V", "closestMemberContainer", "getClosestMemberContainer", "()Landroidx/room/compiler/processing/XEnumTypeElement;", "getEnclosingElement", "fallbackLocationText", "", "getFallbackLocationText", "()Ljava/lang/String;", "name", "getName", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacEnumEntry extends JavacElement implements XEnumEntry {
    private final XEnumTypeElement enclosingElement;

    public JavacEnumEntry(JavacProcessingEnv r5, Element r10, XEnumTypeElement r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "entryElement");
        Intrinsics.checkNotNullParameter(r11, "enclosingElement");
        super(r5, r10);
        this.enclosingElement = r11;
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XMemberContainer getClosestMemberContainer() {
        return getClosestMemberContainer();
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XElement getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getFallbackLocationText() {
        return getName() + " enum entry in " + getEnclosingElement().getFallbackLocationText();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getName() {
        return getElement().getSimpleName().toString();
    }

    @Override // androidx.room.compiler.processing.XElement
    public XEnumTypeElement getClosestMemberContainer() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XElement
    public XEnumTypeElement getEnclosingElement() {
        return this.enclosingElement;
    }
}
