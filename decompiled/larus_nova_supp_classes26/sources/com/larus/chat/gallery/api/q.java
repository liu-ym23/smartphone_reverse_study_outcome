package com.larus.chat.gallery.api;

import android.app.Dialog;
import com.larus.chat.gallery.impl.preview.toolbar.action.k0;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.InputDraftSnapshot;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface q extends n, u, t, s, x {
    void b(Function1<? super List<AttachmentSnapshot>, Unit> r1);

    void c(Dialog r1);

    List<o> d();

    PreviewSelectionLimit e(String r1);

    void f(Function1<? super List<AttachmentSnapshot>, Unit> r1);

    l getCapability();

    String getTitle(String r1);

    InputDraftSnapshot i(String r1);

    String j();

    String k();

    boolean l(PreviewSourceAction r1, String r2);

    Boolean n();

    String o();

    z p();

    PreviewSelectionLimit r(PreviewMediaType r1);

    void u();

    boolean v(PreviewSourceAction r1, String r2, k0 r3);

    boolean w(String r1);
}
