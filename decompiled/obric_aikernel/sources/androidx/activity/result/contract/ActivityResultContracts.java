package androidx.activity.result.contract;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultContracts {

    @RequiresApi(33)
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = null;

        static {
            INSTANCE = new Api33Impl();
        }

        private Api33Impl() {
        }

        @DoNotInline
        public final int getPickImagesMaxLimit() {
            return MediaStore.getPickImagesMaxLimit();
        }
    }

    public static class CaptureVideo extends ActivityResultContract<Uri, Boolean> {
        public CaptureVideo() {
        }

        @CallSuper
        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, Uri r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            Intent r12 = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", r11);
            Intrinsics.checkNotNullExpressionValue(r12, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return r12;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, Uri r11) {
            return createIntent2(r10, r11);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult2(Context r10, Uri r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context r10, Uri r11) {
            return getSynchronousResult2(r10, r11);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Boolean parseResult(int r10, Intent r11) {
            if (r10 != (-1)) goto L5;
            boolean r12 = true;
        L7:
            return Boolean.valueOf(r12);
        L5:
            r12 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Boolean parseResult(int r10, Intent r11) {
            return parseResult(r10, r11);
        }
    }

    @RequiresApi(19)
    public static class CreateDocument extends ActivityResultContract<String, Uri> {
        private final String mimeType;

        @Deprecated(message = "Using a wildcard mime type with CreateDocument is not recommended as it breaks the automatic handling of file extensions. Instead, specify the mime type by using the constructor that takes an concrete mime type (e.g.., CreateDocument(\"image/png\")).", replaceWith = @ReplaceWith(expression = "CreateDocument(\"todo/todo\")", imports = {}))
        public CreateDocument() {
            this("*/*");
        }

        public CreateDocument(String r10) {
            Intrinsics.checkNotNullParameter(r10, "mimeType");
            this.mimeType = r10;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, String r11) {
            return createIntent2(r10, r11);
        }

        @CallSuper
        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            Intent r12 = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.mimeType).putExtra("android.intent.extra.TITLE", r11);
            Intrinsics.checkNotNullExpressionValue(r12, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return r12;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context r10, String r11) {
            return getSynchronousResult2(r10, r11);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(Context r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int r10, Intent r11) {
            if (r10 != (-1)) goto L5;
            boolean r12 = true;
        L7:
            if (r12 == true) goto L10;
            r11 = null;
        L10:
            if (r11 != null) goto L12;
            return null;
        L12:
            return r11.getData();
        L5:
            r12 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r10, Intent r11) {
            return parseResult(r10, r11);
        }
    }

    public static class GetContent extends ActivityResultContract<String, Uri> {
        public GetContent() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, String r11) {
            return createIntent2(r10, r11);
        }

        @CallSuper
        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            Intent r12 = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(r11);
            Intrinsics.checkNotNullExpressionValue(r12, "Intent(Intent.ACTION_GET…          .setType(input)");
            return r12;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context r10, String r11) {
            return getSynchronousResult2(r10, r11);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(Context r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int r10, Intent r11) {
            if (r10 != (-1)) goto L5;
            boolean r12 = true;
        L7:
            if (r12 == true) goto L10;
            r11 = null;
        L10:
            if (r11 != null) goto L12;
            return null;
        L12:
            return r11.getData();
        L5:
            r12 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r10, Intent r11) {
            return parseResult(r10, r11);
        }
    }

    @RequiresApi(18)
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {
        public static final Companion Companion = null;

        @RequiresApi(18)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }

            public final List<Uri> getClipDataUris$activity_release(Intent r10) {
                Intrinsics.checkNotNullParameter(r10, "<this>");
                LinkedHashSet r11 = new LinkedHashSet();
                Uri r12 = r10.getData();
                if (r12 == null) goto L5;
                r11.add(r12);
            L5:
                ClipData r13 = r10.getClipData();
                if (r13 == null) goto L8;
            L11:
                if (r13 == null) goto L19;
                int r14 = 0;
                int r15 = r13.getItemCount();
            L13:
                if (r14 >= r15) goto L19;
                Uri r16 = r13.getItemAt(r14).getUri();
                if (r16 == null) goto L17;
                r11.add(r16);
            L17:
                r14 = r14 + 1;
            L19:
                return new ArrayList(r11);
            L8:
                if (r11.isEmpty() == false) goto L11;
                return CollectionsKt.emptyList();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public GetMultipleContents() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, String r11) {
            return createIntent2(r10, r11);
        }

        @CallSuper
        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            Intent r12 = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(r11).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            Intrinsics.checkNotNullExpressionValue(r12, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return r12;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context r10, String r11) {
            return getSynchronousResult2(r10, r11);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult2(Context r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ List<Uri> parseResult(int r10, Intent r11) {
            return parseResult2(r10, r11);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: parseResult, reason: avoid collision after fix types in other method */
        public final List<Uri> parseResult2(int r10, Intent r11) {
            if (r10 != (-1)) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == true) goto L9;
            r11 = null;
        L9:
            if (r11 == null) goto L14;
            List<Uri> r13 = Companion.getClipDataUris$activity_release(r11);
            if (r13 == null) goto L14;
            return r13;
        L14:
            return CollectionsKt.emptyList();
        L5:
            r12 = false;
            goto L6
        }
    }

    @RequiresApi(19)
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        public OpenDocument() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, String[] r11) {
            return createIntent2(r10, r11);
        }

        @CallSuper
        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, String[] r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            Intent r12 = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", r11).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(r12, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return r12;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context r10, String[] r11) {
            return getSynchronousResult2(r10, r11);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(Context r10, String[] r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int r10, Intent r11) {
            if (r10 != (-1)) goto L5;
            boolean r12 = true;
        L7:
            if (r12 == true) goto L10;
            r11 = null;
        L10:
            if (r11 != null) goto L12;
            return null;
        L12:
            return r11.getData();
        L5:
            r12 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r10, Intent r11) {
            return parseResult(r10, r11);
        }
    }

    @RequiresApi(21)
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        public OpenDocumentTree() {
        }

        @CallSuper
        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, Uri r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intent r12 = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT < 26) goto L6;
            if (r11 == null) goto L6;
            r12.putExtra("android.provider.extra.INITIAL_URI", r11);
        L6:
            return r12;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, Uri r11) {
            return createIntent2(r10, r11);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(Context r10, Uri r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context r10, Uri r11) {
            return getSynchronousResult2(r10, r11);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int r10, Intent r11) {
            if (r10 != (-1)) goto L5;
            boolean r12 = true;
        L7:
            if (r12 == true) goto L10;
            r11 = null;
        L10:
            if (r11 != null) goto L12;
            return null;
        L12:
            return r11.getData();
        L5:
            r12 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r10, Intent r11) {
            return parseResult(r10, r11);
        }
    }

    @RequiresApi(19)
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        public OpenMultipleDocuments() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, String[] r11) {
            return createIntent2(r10, r11);
        }

        @CallSuper
        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, String[] r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            Intent r12 = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", r11).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(r12, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return r12;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context r10, String[] r11) {
            return getSynchronousResult2(r10, r11);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult2(Context r10, String[] r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ List<Uri> parseResult(int r10, Intent r11) {
            return parseResult2(r10, r11);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: parseResult, reason: avoid collision after fix types in other method */
        public final List<Uri> parseResult2(int r10, Intent r11) {
            if (r10 != (-1)) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == true) goto L9;
            r11 = null;
        L9:
            if (r11 == null) goto L14;
            List<Uri> r13 = GetMultipleContents.Companion.getClipDataUris$activity_release(r11);
            if (r13 == null) goto L14;
            return r13;
        L14:
            return CollectionsKt.emptyList();
        L5:
            r12 = false;
            goto L6
        }
    }

    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        public PickContact() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, Void r11) {
            return createIntent2(r10, r11);
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, Void r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intent r12 = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            Intrinsics.checkNotNullExpressionValue(r12, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return r12;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Uri parseResult(int r10, Intent r11) {
            if (r10 != (-1)) goto L5;
            boolean r12 = true;
        L7:
            if (r12 == true) goto L10;
            r11 = null;
        L10:
            if (r11 != null) goto L12;
            return null;
        L12:
            return r11.getData();
        L5:
            r12 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r10, Intent r11) {
            return parseResult(r10, r11);
        }
    }

    @RequiresApi(19)
    public static class PickMultipleVisualMedia extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {
        public static final Companion Companion = null;
        private final int maxItems;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }

            public final int getMaxItems$activity_release() {
                if (PickVisualMedia.Companion.isPhotoPickerAvailable() == true) goto L5;
            L7:
                return Integer.MAX_VALUE;
            L5:
                if (Build.VERSION.SDK_INT < 33) goto L7;
                return Api33Impl.INSTANCE.getPickImagesMaxLimit();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public PickMultipleVisualMedia() {
            this(0, 1, null);
        }

        public PickMultipleVisualMedia(int r10) {
            this.maxItems = r10;
            boolean r11 = true;
            if (r10 > 1) goto L6;
            r11 = false;
        L6:
            if (r11 == false) goto L9;
            return;
        L9:
            throw new IllegalArgumentException("Max items must be higher than 1".toString());
        }

        public /* synthetic */ PickMultipleVisualMedia(int r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L5;
            r10 = Companion.getMaxItems$activity_release();
        L5:
            this(r10);
        }

        @CallSuper
        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, PickVisualMediaRequest r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            PickVisualMedia.Companion r12 = PickVisualMedia.Companion;
            boolean r13 = true;
            if (r12.isPhotoPickerAvailable() == false) goto L15;
            Intent r14 = new Intent("android.provider.action.PICK_IMAGES");
            r14.setType(r12.getVisualMimeType$activity_release(r11.getMediaType()));
            if (Build.VERSION.SDK_INT >= 33) goto L7;
        L14:
            r14.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.maxItems);
        L18:
            return r14;
        L7:
            if (this.maxItems <= Api33Impl.INSTANCE.getPickImagesMaxLimit()) goto L10;
            r13 = false;
        L10:
            if (r13 == true) goto L14;
            throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()".toString());
        L15:
            r14 = new Intent("android.intent.action.OPEN_DOCUMENT");
            r14.setType(r12.getVisualMimeType$activity_release(r11.getMediaType()));
            r14.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            if (r14.getType() != null) goto L18;
            r14.setType("*/*");
            r14.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            goto L18
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, PickVisualMediaRequest r11) {
            return createIntent2(r10, r11);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult2(Context r10, PickVisualMediaRequest r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context r10, PickVisualMediaRequest r11) {
            return getSynchronousResult2(r10, r11);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ List<Uri> parseResult(int r10, Intent r11) {
            return parseResult2(r10, r11);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: parseResult, reason: avoid collision after fix types in other method */
        public final List<Uri> parseResult2(int r10, Intent r11) {
            if (r10 != (-1)) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == true) goto L9;
            r11 = null;
        L9:
            if (r11 == null) goto L14;
            List<Uri> r13 = GetMultipleContents.Companion.getClipDataUris$activity_release(r11);
            if (r13 == null) goto L14;
            return r13;
        L14:
            return CollectionsKt.emptyList();
        L5:
            r12 = false;
            goto L6
        }
    }

    public static class PickVisualMedia extends ActivityResultContract<PickVisualMediaRequest, Uri> {
        public static final Companion Companion = null;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }

            public final String getVisualMimeType$activity_release(VisualMediaType r10) {
                Intrinsics.checkNotNullParameter(r10, "input");
                if ((r10 instanceof ImageOnly) == false) goto L6;
                return "image/*";
            L6:
                if ((r10 instanceof VideoOnly) == false) goto L9;
                return "video/*";
            L9:
                if ((r10 instanceof SingleMimeType) == false) goto L12;
                return ((SingleMimeType) r10).getMimeType();
            L12:
                if ((r10 instanceof ImageAndVideo) == false) goto L16;
                return null;
            L16:
                throw new NoWhenBranchMatchedException();
            }

            @JvmStatic
            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isPhotoPickerAvailable() {
                int r10 = Build.VERSION.SDK_INT;
                if (r10 < 33) goto L6;
            L10:
                return true;
            L6:
                if (r10 >= 30) goto L8;
                return false;
            L8:
                if (SdkExtensions.getExtensionVersion(30) >= 2) goto L10;
                return false;
            }
        }

        public static final class ImageAndVideo implements VisualMediaType {
            public static final ImageAndVideo INSTANCE = null;

            static {
                INSTANCE = new ImageAndVideo();
            }

            private ImageAndVideo() {
            }
        }

        public static final class ImageOnly implements VisualMediaType {
            public static final ImageOnly INSTANCE = null;

            static {
                INSTANCE = new ImageOnly();
            }

            private ImageOnly() {
            }
        }

        public static final class SingleMimeType implements VisualMediaType {
            private final String mimeType;

            public SingleMimeType(String r10) {
                Intrinsics.checkNotNullParameter(r10, "mimeType");
                this.mimeType = r10;
            }

            public final String getMimeType() {
                return this.mimeType;
            }
        }

        public static final class VideoOnly implements VisualMediaType {
            public static final VideoOnly INSTANCE = null;

            static {
                INSTANCE = new VideoOnly();
            }

            private VideoOnly() {
            }
        }

        public interface VisualMediaType {
        }

        static {
            Companion = new Companion(null);
        }

        public PickVisualMedia() {
        }

        @JvmStatic
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean isPhotoPickerAvailable() {
            return Companion.isPhotoPickerAvailable();
        }

        @CallSuper
        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, PickVisualMediaRequest r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            Companion r12 = Companion;
            if (r12.isPhotoPickerAvailable() == false) goto L5;
            Intent r13 = new Intent("android.provider.action.PICK_IMAGES");
            r13.setType(r12.getVisualMimeType$activity_release(r11.getMediaType()));
            return r13;
        L5:
            Intent r14 = new Intent("android.intent.action.OPEN_DOCUMENT");
            r14.setType(r12.getVisualMimeType$activity_release(r11.getMediaType()));
            if (r14.getType() != null) goto L10;
            r14.setType("*/*");
            r14.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            return r14;
        L10:
            return r14;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, PickVisualMediaRequest r11) {
            return createIntent2(r10, r11);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(Context r10, PickVisualMediaRequest r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context r10, PickVisualMediaRequest r11) {
            return getSynchronousResult2(r10, r11);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int r10, Intent r11) {
            if (r10 != (-1)) goto L5;
            boolean r12 = true;
        L7:
            if (r12 == true) goto L10;
            r11 = null;
        L10:
            if (r11 != null) goto L12;
            return null;
        L12:
            return r11.getData();
        L5:
            r12 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r10, Intent r11) {
            return parseResult(r10, r11);
        }
    }

    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {
        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        public static final Companion Companion = null;
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }

            public final Intent createIntent$activity_release(String[] r10) {
                Intrinsics.checkNotNullParameter(r10, "input");
                Intent r11 = new Intent(RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS).putExtra(RequestMultiplePermissions.EXTRA_PERMISSIONS, r10);
                Intrinsics.checkNotNullExpressionValue(r11, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return r11;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public RequestMultiplePermissions() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, String[] r11) {
            return createIntent2(r10, r11);
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, String[] r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            return Companion.createIntent$activity_release(r11);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(Context r10, String[] r11) {
            return getSynchronousResult2(r10, r11);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult2(Context r10, String[] r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            boolean r12 = true;
            int r13 = 0;
            if (r11.length != 0) goto L5;
            boolean r14 = true;
        L6:
            if (r14 == true) goto L8;
            int r15 = r11.length;
            int r16 = 0;
        L10:
            if (r16 >= r15) goto L18;
            if (ContextCompat.checkSelfPermission(r10, r11[r16]) != 0) goto L14;
            boolean r17 = true;
        L15:
            if (r17 == false) goto L16;
            r16 = r16 + 1;
            goto L10
        L16:
            r12 = false;
            goto L18
        L14:
            r17 = false;
        L18:
            if (r12 == false) goto L23;
            LinkedHashMap r18 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r11.length), 16));
            int r19 = r11.length;
        L20:
            if (r13 >= r19) goto L28;
            Pair r20 = TuplesKt.to(r11[r13], Boolean.TRUE);
            r18.put(r20.getFirst(), r20.getSecond());
            r13 = r13 + 1;
            goto L20
        L28:
            return new ActivityResultContract.SynchronousResult(r18);
        L23:
            return null;
        L8:
            return new ActivityResultContract.SynchronousResult(MapsKt.emptyMap());
        L5:
            r14 = false;
            goto L6
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Map<String, Boolean> parseResult(int r10, Intent r11) {
            return parseResult2(r10, r11);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: parseResult, reason: avoid collision after fix types in other method */
        public Map<String, Boolean> parseResult2(int r10, Intent r11) {
            if (r10 != (-1)) goto L5;
            if (r11 == null) goto L8;
            String[] r12 = r11.getStringArrayExtra(EXTRA_PERMISSIONS);
            int[] r13 = r11.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
            if (r13 == null) goto L23;
            if (r12 == null) goto L23;
            ArrayList r14 = new ArrayList(r13.length);
            int r15 = r13.length;
            int r16 = 0;
        L14:
            if (r16 >= r15) goto L21;
            if (r13[r16] != 0) goto L18;
            boolean r17 = true;
        L19:
            r14.add(Boolean.valueOf(r17));
            r16 = r16 + 1;
            goto L14
        L18:
            r17 = false;
            goto L19
        L21:
            return MapsKt.toMap(CollectionsKt.zip(ArraysKt.filterNotNull(r12), r14));
        L23:
            return MapsKt.emptyMap();
        L8:
            return MapsKt.emptyMap();
        L5:
            return MapsKt.emptyMap();
        }
    }

    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        public RequestPermission() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, String r11) {
            return createIntent2(r10, r11);
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            return RequestMultiplePermissions.Companion.createIntent$activity_release(new String[]{r11});
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context r10, String r11) {
            return getSynchronousResult2(r10, r11);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult2(Context r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            if (ContextCompat.checkSelfPermission(r10, r11) != 0) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == true) goto L10;
            return null;
        L10:
            return new ActivityResultContract.SynchronousResult(Boolean.TRUE);
        L5:
            r12 = false;
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Boolean parseResult(int r10, Intent r11) {
            if (r11 == null) goto L24;
            if (r10 != (-1)) goto L24;
            int[] r12 = r11.getIntArrayExtra(RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS);
            boolean r13 = true;
            if (r12 == null) goto L20;
            int r14 = r12.length;
            int r15 = 0;
        L9:
            if (r15 >= r14) goto L17;
            if (r12[r15] != 0) goto L13;
            boolean r16 = true;
        L14:
            if (r16 == true) goto L15;
            r15 = r15 + 1;
            goto L9
        L15:
            boolean r17 = true;
        L18:
            if (r17 != true) goto L20;
        L22:
            return Boolean.valueOf(r13);
        L13:
            r16 = false;
            goto L14
        L17:
            r17 = false;
        L20:
            r13 = false;
        L24:
            return Boolean.FALSE;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Boolean parseResult(int r10, Intent r11) {
            return parseResult(r10, r11);
        }
    }

    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
        public static final Companion Companion = null;
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public StartActivityForResult() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, Intent r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            return r11;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, Intent r11) {
            return createIntent2(r10, r11);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResult parseResult(int r10, Intent r11) {
            return new ActivityResult(r10, r11);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResult parseResult(int r10, Intent r11) {
            return parseResult(r10, r11);
        }
    }

    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        public static final Companion Companion = null;
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public StartIntentSenderForResult() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, IntentSenderRequest r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            Intent r12 = new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, r11);
            Intrinsics.checkNotNullExpressionValue(r12, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return r12;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, IntentSenderRequest r11) {
            return createIntent2(r10, r11);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResult parseResult(int r10, Intent r11) {
            return new ActivityResult(r10, r11);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResult parseResult(int r10, Intent r11) {
            return parseResult(r10, r11);
        }
    }

    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        public TakePicture() {
        }

        @CallSuper
        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, Uri r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            Intent r12 = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", r11);
            Intrinsics.checkNotNullExpressionValue(r12, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return r12;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, Uri r11) {
            return createIntent2(r10, r11);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult2(Context r10, Uri r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context r10, Uri r11) {
            return getSynchronousResult2(r10, r11);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Boolean parseResult(int r10, Intent r11) {
            if (r10 != (-1)) goto L5;
            boolean r12 = true;
        L7:
            return Boolean.valueOf(r12);
        L5:
            r12 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Boolean parseResult(int r10, Intent r11) {
            return parseResult(r10, r11);
        }
    }

    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        public TakePicturePreview() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, Void r11) {
            return createIntent2(r10, r11);
        }

        @CallSuper
        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, Void r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context r10, Void r11) {
            return getSynchronousResult2(r10, r11);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult2(Context r10, Void r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Bitmap parseResult(int r10, Intent r11) {
            if (r10 != (-1)) goto L5;
            boolean r12 = true;
        L7:
            if (r12 == true) goto L10;
            r11 = null;
        L10:
            if (r11 != null) goto L12;
            return null;
        L12:
            return (Bitmap) r11.getParcelableExtra("data");
        L5:
            r12 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Bitmap parseResult(int r10, Intent r11) {
            return parseResult(r10, r11);
        }
    }

    @Deprecated(message = "The thumbnail bitmap is rarely returned and is not a good signal to determine\n      whether the video was actually successfully captured. Use {@link CaptureVideo} instead.")
    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        public TakeVideo() {
        }

        @CallSuper
        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r10, Uri r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            Intent r12 = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", r11);
            Intrinsics.checkNotNullExpressionValue(r12, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return r12;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r10, Uri r11) {
            return createIntent2(r10, r11);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult2(Context r10, Uri r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context r10, Uri r11) {
            return getSynchronousResult2(r10, r11);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Bitmap parseResult(int r10, Intent r11) {
            if (r10 != (-1)) goto L5;
            boolean r12 = true;
        L7:
            if (r12 == true) goto L10;
            r11 = null;
        L10:
            if (r11 != null) goto L12;
            return null;
        L12:
            return (Bitmap) r11.getParcelableExtra("data");
        L5:
            r12 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Bitmap parseResult(int r10, Intent r11) {
            return parseResult(r10, r11);
        }
    }

    private ActivityResultContracts() {
    }
}
