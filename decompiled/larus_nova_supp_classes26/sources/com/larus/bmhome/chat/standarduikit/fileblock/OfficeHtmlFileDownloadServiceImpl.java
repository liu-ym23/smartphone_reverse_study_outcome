package com.larus.bmhome.chat.standarduikit.fileblock;

import android.content.Context;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.office.card.urlpreview.IOfficeHtmlFileDownloadService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/fileblock/OfficeHtmlFileDownloadServiceImpl;", "Lcom/larus/office/card/urlpreview/IOfficeHtmlFileDownloadService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "download", "", "context", "Landroid/content/Context;", ShareType.URL, "", "fileName", "shareDownloadedFile", "", "fileUri", "showSavedToDevice", "showFailure", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeHtmlFileDownloadServiceImpl implements IOfficeHtmlFileDownloadService {
    public static final /* synthetic */ int b = 0;
    public final CoroutineScope a;

    public static final class a {
    }

    static {
    }

    public OfficeHtmlFileDownloadServiceImpl() {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
    }

    public final boolean a(final Context r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, ShareType.URL);
        Intrinsics.checkNotNullParameter(r13, "fileName");
        if (y0.e(r12) == true) goto L6;
        return false;
    L6:
        if ((!StringsKt.isBlank(r13)) == true) goto L9;
        r13 = null;
    L9:
        if (r13 != null) goto L11;
        r13 = "download.html";
    L11:
        final String r8 = r13;
        s r14 = s.a;
        CharSequence r0 = r11.getText(2131905387);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r0, ShareType.TEXT);
        s.d(r11, r0, null, false);
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L14
        ChatInputService.b.f().c(r11.getApplicationContext(), r12, r8, false, r8, new OfficeHtmlFileDownloadServiceImpl$download$1$1(this, r11, r8));     // Catch: Throwable -> L14
        Object r16 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L14
    L16:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L19;
        FLogger.a.e("OfficeHtmlDownload", "HTML artifact download start failed", r17);
        s.a.a();
        s.s(r11, 2131910881);
    L19:
        Boolean r18 = Boolean.FALSE;
        if (Result.isFailure-impl(r16) == false) goto L23;
        r16 = r18;
    L23:
        return ((Boolean) r16).booleanValue();
    L14:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }
}
