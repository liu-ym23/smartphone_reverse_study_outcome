package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.text.Typography;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/serialization/json/internal/CharMappings;", "", "()V", "CHAR_TO_TOKEN", "", "ESCAPE_2_CHAR", "", "initC2ESC", "", "c", "", "esc", "", "initC2TC", "cl", "", "initCharToToken", "initEscape", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f17840a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f17841b = null;
    public static final byte[] c = null;

    static {
        e r0 = new e();
        f17840a = r0;
        f17841b = new char[117];
        c = new byte[WebSocketProtocol.PAYLOAD_SHORT];
        r0.a();
        r0.b();
    }

    private e() {
    }

    private final void a() {
        int r0 = 0;
    L4:
        if (r0 >= 32) goto L6;
        a(r0, 'u');
        r0 = r0 + 1;
        goto L4
    L6:
        a(8, 'b');
        a(9, 't');
        a(10, 'n');
        a(12, 'f');
        a(13, 'r');
        a('/', '/');
        a(Typography.quote, Typography.quote);
        a('\\', '\\');
    }

    private final void a(char r1, byte r2) {
        a(r1, r2);
    }

    private final void a(char r1, char r2) {
        a(r1, r2);
    }

    private final void a(int r1, byte r2) {
        c[r1] = r2;
    }

    private final void a(int r1, char r2) {
        if (r2 == 'u') goto L6;
        f17841b[r2] = (char) r1;
        return;
    }

    private final void b() {
        int r0 = 0;
    L4:
        if (r0 >= 33) goto L6;
        a(r0, ByteCompanionObject.MAX_VALUE);
        r0 = r0 + 1;
        goto L4
    L6:
        a(9, (byte) 3);
        a(10, (byte) 3);
        a(13, (byte) 3);
        a(32, (byte) 3);
        a(',', (byte) 4);
        a(':', (byte) 5);
        a('{', (byte) 6);
        a('}', (byte) 7);
        a('[', (byte) 8);
        a(']', (byte) 9);
        a(Typography.quote, (byte) 1);
        a('\\', (byte) 2);
    }
}
