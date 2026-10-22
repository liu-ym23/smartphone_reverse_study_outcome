package com.obric.memorydata.markdown.custom;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"copyToClipboard", "", "Landroid/content/Context;", AnnotatedPrivateKey.LABEL, "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "TAG", "scope", "Lkotlinx/coroutines/CoroutineScope;", "startCustomActivity", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "markdown_lite_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final al f9979a = null;

    static {
        f9979a = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(new ak("CustomActions"), CoroutineContext.class, "com.obric.memorydata.plugin")));
    }

    public static final /* synthetic */ al a() {
        return f9979a;
    }

    public static final void a(Context r2, String r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r3, AnnotatedPrivateKey.LABEL);
        Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        ((ClipboardManager) ZeusTransformUtils.preCheckCast(r5.getSystemService(ClipboardManager.class), ClipboardManager.class, "com.obric.memorydata.plugin")).setPrimaryClip(ClipData.newPlainText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")));
    }

    public static final /* synthetic */ boolean a(Context r2, Intent r3) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
    }

    private static final boolean b(Context r3, Intent r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        boolean r6 = com.obric.memorydata.utils.ba.a(r5, r4);
        if (r6 == true) goto L5;
        String r0 = r5.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_open_failed, TypedValues.Custom.S_STRING, "markdown_action_open_failed"));
        Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");
        com.obric.memorydata.utils.ba.a(r5, r0, 80);
    L5:
        return r6;
    }
}
