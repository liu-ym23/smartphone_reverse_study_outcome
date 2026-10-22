package androidx.room.compiler.codegen.java;

import androidx.room.compiler.codegen.CodeLanguage;
import androidx.room.compiler.codegen.TargetLanguage;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/compiler/codegen/java/JavaLang;", "Landroidx/room/compiler/codegen/TargetLanguage;", "()V", "language", "Landroidx/room/compiler/codegen/CodeLanguage;", "getLanguage", "()Landroidx/room/compiler/codegen/CodeLanguage;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class JavaLang implements TargetLanguage {
    private final CodeLanguage language;

    public JavaLang() {
        this.language = CodeLanguage.JAVA;
    }

    @Override // androidx.room.compiler.codegen.TargetLanguage
    public CodeLanguage getLanguage() {
        return this.language;
    }
}
