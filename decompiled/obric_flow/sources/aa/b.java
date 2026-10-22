package aa;

import ai.i;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import fi.g;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f150c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter f152b;

    static {
        f150c = Charset.forName("UTF-8");
    }

    public b(Gson r5, TypeAdapter r10) {
        this.f151a = r5;
        this.f152b = r10;
    }

    @Override // ai.i
    public final Object convert(Object r5) {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream(1024);
        OutputStreamWriter r11 = new OutputStreamWriter(r10, f150c);
        JsonWriter r12 = this.f151a.newJsonWriter(r11);
        this.f152b.write(r12, r5);
        r12.close();
        return new g("application/json; charset=UTF-8", r10.toByteArray(), new String[0]);
    }
}
