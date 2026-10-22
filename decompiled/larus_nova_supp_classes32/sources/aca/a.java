package aca;

import com.larus.common.apphost.AppHost;
import com.obric.assistant.settings.ToggleName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {

    /* JADX INFO: renamed from: aca.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0005a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ToggleName.values().length];
            r0[ToggleName.CONTACTS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r0[ToggleName.CALL_LOGS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r0[ToggleName.MESSAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[ToggleName.ALBUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[ToggleName.NOTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r0[ToggleName.CLOCK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r0[ToggleName.GLOBAL_MEMORY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r0[ToggleName.FILE_MANAGEMENT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[ToggleName.CALENDAR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[ToggleName.RECORD.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r0[ToggleName.AI_DIARY.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            a = r0;
        }
    }

    public static final String a(ToggleName r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        switch(C0005a.a[r3.ordinal()]) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L18:
        String r4 = tga.b.a();
        return AppHost.a.getApplication().getString(2131912168, new Object[]{r4});
    L7:
        return AppHost.a.getApplication().getString(2131912129);
    L9:
        return AppHost.a.getApplication().getString(2131912140);
    L11:
        return AppHost.a.getApplication().getString(2131912144);
    L13:
        return AppHost.a.getApplication().getString(2131912136);
    L15:
        return AppHost.a.getApplication().getString(2131912161);
    L17:
        return AppHost.a.getApplication().getString(2131912153);
    L21:
        return AppHost.a.getApplication().getString(2131912148);
    L23:
        return AppHost.a.getApplication().getString(2131912166);
    L25:
        return AppHost.a.getApplication().getString(2131912151);
    L27:
        return AppHost.a.getApplication().getString(2131912155);
    }

    public static final String b(ToggleName r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        switch(C0005a.a[r1.ordinal()]) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return AppHost.a.getApplication().getString(2131912146);
    L9:
        return AppHost.a.getApplication().getString(2131912170);
    L11:
        return AppHost.a.getApplication().getString(2131912149);
    L13:
        return AppHost.a.getApplication().getString(2131912156);
    L15:
        return AppHost.a.getApplication().getString(2131912160);
    L17:
        return AppHost.a.getApplication().getString(2131912152);
    L19:
        return tga.b.a();
    L21:
        return AppHost.a.getApplication().getString(2131912147);
    L23:
        return AppHost.a.getApplication().getString(2131912165);
    L25:
        return AppHost.a.getApplication().getString(2131912150);
    L27:
        return AppHost.a.getApplication().getString(2131912154);
    }
}
