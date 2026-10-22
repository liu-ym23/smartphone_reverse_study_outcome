package com.obric.aikernel;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.UserHandle;
import androidx.core.app.NotificationCompat;
import com.obric.aikernel.middleware.api.traker.ITrackerApi;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import com.obric.aikernel.multiusr.MultiUsrAdapter;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiProcHandler extends ContentProvider {

    /* JADX INFO: renamed from: com.obric.aikernel.MultiProcHandler$call$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.MultiProcHandler$call$1", f = "MultiProcHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $extras;
        int label;
        final /* synthetic */ MultiProcHandler this$0;

        AnonymousClass1(Bundle r10, MultiProcHandler r11, Continuation<? super AnonymousClass1> r12) {
            this.$extras = r10;
            this.this$0 = r11;
            super(1, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r10) {
            return new AnonymousClass1(this.$extras, this.this$0, r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r10) {
            return invoke2(r10);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r10);
            Bundle r11 = this.$extras;
            if (r11 == null) goto L8;
            MultiProcHandler.a(this.this$0, r11);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MultiProcHandler() {
    }

    public static final /* synthetic */ void a(MultiProcHandler r10, Bundle r11) {
        r10.c(r11);
    }

    private final Bundle b(Bundle r10) {
        String r11 = r10.getString("url");
        if (r11 != null) goto L5;
        return null;
    L5:
        UserHandle r12 = (UserHandle) r10.getParcelable("handle");
        if (r12 != null) goto L8;
        return null;
    L8:
        ParcelFileDescriptor r13 = MultiUsrAdapter.f4720a.b(r11, r12);
        Bundle r14 = new Bundle();
        r14.putParcelable("fdObject", r13);
        return r14;
    }

    private final void c(Bundle r10) {
        String r11 = r10.getString("e");
        if (r11 != null) goto L5;
        return;
    L5:
        String r12 = r10.getString("p");
        if (r12 == null) goto L8;
        JSONObject r13 = new JSONObject(r12);
    L9:
        TrackerApi.INSTANCE.onEvent(r11, r13);
        return;
    L8:
        r13 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r10v6, types: [T, com.obric.aikernel.MultiProcHandler$call$1] */
    @Override // android.content.ContentProvider
    public Bundle call(String r10, String r11, String r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r10, "authority");
        Intrinsics.checkNotNullParameter(r11, "api");
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        if (Intrinsics.areEqual(r11, ITrackerApi.TAG) == false) goto L8;
        if (Intrinsics.areEqual(r12, NotificationCompat.CATEGORY_EVENT) == false) goto L15;
        r14.element = new AnonymousClass1(r13, this, null);
    L15:
        if (((Function1) r14.element) == null) goto L17;
        h.d(m0.a(z0.b()), null, null, new MultiProcHandler$call$3$1(r14, null), 3, null);
    L17:
        return null;
    L8:
        if (Intrinsics.areEqual(r11, "MultiUsrAdapter") == false) goto L15;
        if (Intrinsics.areEqual(r12, "getFd") == false) goto L15;
        if (r13 != null) goto L13;
        return null;
    L13:
        return b(r13);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        return 0;
    }
}
